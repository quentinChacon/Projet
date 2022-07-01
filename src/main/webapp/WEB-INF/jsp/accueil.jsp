<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<link href="<c:url value="/css/Projet.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img src="css/logoProjet.png"/>

	<div>
		<a href="">Encheres</a>
	</div>

	<div>
		<a href="">Vendre un article</a>
	</div>

	<div>
		<a href="/Projet-ENI/profil">Mon profil</a>
	</div>

	<form method="post"
		action="${pageContext.request.contextPath}/deconnexionCompte">
		<input type="submit" value="Déconnexion" />
	</form>


	<h1>Liste des enchères</h1>

	<div id="searchbar">

		<div>Filtres</div>
		<form action="" class="formulaire">
			<input class="champ" type="text" value="Le nom de l'article contient" />
			<input class="bouton" type="button" value="Rechercher" />

		</form>
	</div>

	<div>Categories :</div>
	<select id="ListeDeroulanteAchat">

		<option selected>Toutes</option>
		<option value="Informatique">Informatique</option>
		<option value="Ameublement">Ameublement</option>
		<option value="Vetement">Vetement</option>
		<option value="Sport & Loisirs">Sport & Loisirs</option>
	</select>

	<fieldset>

		<div>
			<input type="radio" id="Achats" name="Achats"> <label
				for="Achats">Achats</label>
		</div>

		<div>
			<input type="radio" id="mesVentes" name="mesVentes"> <label
				for="mesVentes">Mes Ventes</label>
		</div>

	</fieldset>


	<fieldset>

		<div>
			<input type="checkbox" id="ouvertes" name="ouvertes"> <label
				for="scales">Enchères ouvertes</label>
		</div>

		<div>
			<input type="checkbox" id="enCours" name="enCours"> <label
				for="horns">Mes enchères en cours</label>
		</div>


		<div>
			<input type="checkbox" id="remportées" name="remportées"> <label
				for="horns">Mes enchères remportées</label>
		</div>
	</fieldset>

	<fieldset>


		<div>
			<input type="checkbox" id="vEnCours" name="vEnCours"> <label
				for="scales">Mes ventes en cours</label>
		</div>

		<div>
			<input type="checkbox" id="nonDébutées" name="nonDébutées"> <label
				for="horns">Ventes non débutées</label>
		</div>


		<div>
			<input type="checkbox" id="terminées" name="terminées"> <label
				for="horns">Ventes terminées</label>
		</div>
	</fieldset>


</body>
</html>