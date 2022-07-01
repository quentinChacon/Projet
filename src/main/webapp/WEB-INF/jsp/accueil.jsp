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
		<input type="submit" value="D�connexion" />
	</form>


	<h1>Liste des ench�res</h1>

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
				for="scales">Ench�res ouvertes</label>
		</div>

		<div>
			<input type="checkbox" id="enCours" name="enCours"> <label
				for="horns">Mes ench�res en cours</label>
		</div>


		<div>
			<input type="checkbox" id="remport�es" name="remport�es"> <label
				for="horns">Mes ench�res remport�es</label>
		</div>
	</fieldset>

	<fieldset>


		<div>
			<input type="checkbox" id="vEnCours" name="vEnCours"> <label
				for="scales">Mes ventes en cours</label>
		</div>

		<div>
			<input type="checkbox" id="nonD�but�es" name="nonD�but�es"> <label
				for="horns">Ventes non d�but�es</label>
		</div>


		<div>
			<input type="checkbox" id="termin�es" name="termin�es"> <label
				for="horns">Ventes termin�es</label>
		</div>
	</fieldset>


</body>
</html>