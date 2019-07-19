<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<c:choose>
		<c:when test="${ !empty art }">
			<c:set var="btnSubmit" value="Modifier" scope="page" />
			<c:set var="readonly" value="readonly" scope="page" />
		</c:when>
		<c:otherwise>
			<c:set var="btnSubmit" value="Ajouter" scope="page" />
		</c:otherwise>
	</c:choose>
	
	<c:if test="${ !empty sessionScope.user }">
		<p>
			<i>Connecté : <c:out value="${ sessionScope.user }" /></i>
		</p>
	</c:if>
	
	<div class="container">
		<h2><c:out value="${ btnSubmit }" /> un article</h2>
		<c:if test="${ !empty exception }"><h3 style="color:red;"><c:out value="${ exception }" /></h3></c:if>
		<form method="POST" action="article">
			<div class="form-group">
				<label for="ref">Référence:</label> <input type="ref"
					class="form-control" id="ref" placeholder="" name="ref"
					value="${ art.reference }" <c:out value="${ readonly }" />><!-- <c:out value="${ readonly }" /> -->
			</div>
			<div class="form-group">
				<label for=des>Designation:</label> <input type="des"
					class="form-control" id="des" placeholder="" name="des"
					value="${ art.designation }">
			</div>
			<div class="form-group">
				<label for=des>Prix:</label> <input type="prix" class="form-control"
					id="prix" placeholder="" name="prix" value="${ art.decimal }">
			</div>
			<!-- <button type="submit" class="btn btn-primary" name="submitType" value="submitType">
				<c:out value="${ btnSubmit }" />
			</button> -->
			<div class="form-group">
				<input type="submit" class="form-control btn btn-info btn-lg"
				 name="submitType" value="${ btnSubmit }">
			</div>
		</form>
	</div>
	<br>
	<div class="container jumbotron">
		<p>${ message }</p>
		<p>${ ref }</p>
		<p>${ des }</p>
		<p>${ prix }</p>
		<p>submitType : ${ submitType }</p>
	</div>


	<br>
	<hr>
	<br>

	<div class="container">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Référence</th>
					<th>Désignation</th>
					<th>Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ articles }" var="article">
					<tr>
						<td><c:out value="${ article.reference }" /></td>
						<td><c:out value="${ article.designation }" /></td>
						<td><c:out value="${ article.decimal }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>