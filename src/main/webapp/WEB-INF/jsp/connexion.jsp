<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Connexion</h1>

<div>
Identifiant <input type = "text" name = "identifiant"/>
</div>

<div>
Mot de passe <input type = "password" name = "motdepasse"/>
</div>



<form method = "get" action ="${pageContext.request.contextPath}/accueil">
<div>
<button type="submit">
Connexion
</button>
</div>
</form>


<div>
<input type = "checkbox" name = "" id ="mdp">
<label for = "mdp">Se souvenir de moi</label>
</div>

<div>
<a href ="">Mot de passe oublié</a>
</div>

<div>

<button onclick= "window.location.href ='/Projet-ENI/creationprofil'">
Créer un compte
</button>

</div>


</body>
</html>