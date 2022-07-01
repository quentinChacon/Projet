<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="fr.eni.javaee.projet.bo.Utilisateur"%>

<link href="<c:url value="/css/Projet.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img class="logo" src="css/logoProjet.png"/>

	<h1 class="connexionSite">Connexion</h1>

	<form method="post" action="${pageContext.request.contextPath}/accueil">

		<label for="identifiant">Identifiant</label> <input type="text"
			id="pseudo" name="pseudo" placeholder="Entrez votre pseudo"
			value="<c:out value="${connexionUtilisateur.pseudo}"/>" /> <span
			class="erreur">${form.erreurs['pseudo']}</span> <br /> <label
			for="motdepasse">Mot de passe</label> <input type="password"
			id="motdepasse" name="motdepasse" /> <span class="erreur">${form.erreurs['motDePasse']}</span>
		<br />

		<button type="submit">Connexion</button>

	</form>





	<div>
		<input type="checkbox" name="" id="mdp"> <label for="mdp">Se
			souvenir de moi</label>
	</div>

	<div>
		<a href="">Mot de passe oublié</a>
	</div>

	<div>

		<button onclick="window.location.href ='/Projet-ENI/creationprofil'">
			Créer un compte</button>

	</div>


</body>
</html>