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
<c:if test="${ !empty sessionScope.user }">
<p><i>Connecté : <c:out value="${ sessionScope.user }" /></i></p>
</c:if>
	<div class="container">
		<h2>Ajouter un article</h2>
		<form method="POST" action="article">
			<div class="form-group">
				<label for="ref">Référence:</label>
				<input type="ref" class="form-control" id="ref" placeholder="" name="ref">
			</div>
			<div class="form-group">
				<label for=des>Designation:</label>
				<input type="des" class="form-control" id="des" placeholder="" name="des">
			</div>
			<div class="form-group">
				<label for=des>Prix:</label>
				<input type="prix" class="form-control" id="prix" placeholder="" name="prix">
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
	<p>${ message }</p>
	<p>${ ref }</p>
	<p>${ des }</p>
	<p>${ prix }</p>
</body>
</html>