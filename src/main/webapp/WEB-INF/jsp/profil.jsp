<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="fr.eni.javaee.projet.bo.Utilisateur"%>    
    
=======

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page import="fr.eni.javaee.projet.bo.Utilisateur"%>    
    

>>>>>>> branch 'main' of https://github.com/quentinChacon/Projet.git
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Mon profil :</h1>


<tbody>


<tr>



<td>${id.pseudo}</td>


</tr>





</tbody>

<div>
Pseudo :
</div>
 
<br>
Nom : ${profilutilisateur.nom} 
<br>
Prenom : ${profilutilisateur.prenom} 
<br>
Email : ${profilutilisateur.email} 
<br>
Telephone : ${profilutilisateur.telephone} 
<br>
Rue : ${profilutilisateur.rue} 
<br>
Code Postal : ${profilutilisateur.codePostal} 
<br>
Ville : ${profilutilisateur.ville} 
</div>

<div>
<button onclick= "window.location.href ='/Projet-ENI/modificationprofil'">
Modifier
</button>
</div>

</body>
</html>