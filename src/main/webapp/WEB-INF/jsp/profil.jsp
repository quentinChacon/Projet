<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Mon profil :</h1>

<div>
Pseudo :
<br>
Nom : 
<br>
Prenom : ${utilisateur.prenom}
<br>
Email : 
<br>
Telephone : 
<br>
Rue : 
<br>
Code Postal : 
<br>
Ville :
</div>

<div>
<button onclick= "window.location.href ='/Projet-ENI/modificationprofil'">
Modifier
</button>
</div>

</body>
</html>