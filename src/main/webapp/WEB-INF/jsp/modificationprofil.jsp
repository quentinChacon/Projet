<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<link href="<c:url value="/css/Projet.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>

<a class="logo" href="/Projet-ENI/accueil"><img src="css/logoProjet.png"/></a>

	<div>
		Pseudo :<input type="text" name="pseudo" />
	</div>

	<div>
		Nom :<input type="text" name="nom" />
	</div>

	<div>
		Prenom :<input type="text" name="prenom" />
	</div>

	<div>
		Email :<input type="text" name="email" />
	</div>

	<div>
		Telephone :<input type="tel" name="telephone" />
	</div>

	<div>
		Code Postal :<input type="text" name="codepostal" />
	</div>

	<div>
		Rue :<input type="text" name="rue" />
	</div>

	<div>
		Ville :<input type="text" name="ville" />
	</div>

	<div>
		Mot de passe actuel : <input type="password" name="motdepasse" />
	</div>

	<div>
		Nouveau mot de passe : <input type="password" name="nouveaumotdepasse" />
	</div>

	<div>
		Confirmation :<input type="password" name="confirmation" />
	</div>

	<div>vous avez .... de cr?dits</div>

	<div>
		<button>Enregistrer</button>
	</div>



	<form method="post"
		action="${pageContext.request.contextPath}/suppressionCompte">
		<input type="submit" value="Supprimer mon compte" />
	</form>


</body>
</html>