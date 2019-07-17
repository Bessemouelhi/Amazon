<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
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
		<c:when test="${ !empty sessionScope.user }">
			<h2><i>Vous êtes connecté : <c:out value="${ sessionScope.user }" /></i></h2>
		</c:when>
		<c:otherwise>
		<div class="login">
				<form class="form-inline" action="connexion" method="POST">
					<label for="user">Utilisateur:</label> <input type="user"
						class="form-control" name="user" id="user">
					<button type="submit" class="btn btn-primary">Connexion</button>
				</form>
			</div>
		</c:otherwise>
	</c:choose>



</body>
</html>