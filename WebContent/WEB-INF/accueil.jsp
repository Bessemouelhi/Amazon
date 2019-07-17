<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogues d'article</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${ !empty sessionScope.user }">
<p><i>Connecté : <c:out value="${ sessionScope.user }" /></i></p>
</c:if>

	<div class="container">
		<h2>Recherche d'articles</h2>
		<form method="POST" action="accueil">
			<div class="form-group">
				<label for="ref">Référence:</label> 
				<input type="text" class="form-control" id="ref" placeholder=""
					name="ref">
			</div>
			<div class="form-group">
				<label for="des">Designation:</label> 
				<input type="text" class="form-control" id="des" placeholder=""
					name="des">
			</div>
			<button type="submit" class="btn btn-primary">Rechercher</button>
		</form>
	</div>
	
	<br>
	
	<p>${ message }</p>
	<p>${ ref }</p>
	<p>${ des }</p>
	
	<br><hr><br>
	
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
      <tr>
        <td>AT980</td>
        <td>Smart Phone GT</td>
        <td>450.00</td>
        <td><a class="text-danger" href="deleteArticle">Supprimer</a></td>
        <td><a href="editArticle">Edit</a></td>
      </tr>
      <tr>
        <td>HP675</td>
        <td>Ordinateur HP</td>
        <td>800.00</td>
        <td><a class="text-danger" href="deleteArticle">Supprimer</a></td>
        <td><a href="editArticle">Edit</a></td>
      </tr>
      <tr>
        <td>SMG10</td>
        <td>Samsung Galaxy S10</td>
        <td>900.00</td>
        <td><a class="text-danger" href="deleteArticle">Supprimer</a></td>
        <td><a href="editArticle">Edit</a></td>
      </tr>
    </tbody>
  </table>
  </div>
</body>
</html>