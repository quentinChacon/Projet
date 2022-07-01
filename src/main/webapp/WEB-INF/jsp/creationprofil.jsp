<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <link href="<c:url value="/css/Projet.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un utilisateur</title>
</head>
<body>

<img class="logo" src="css/logoProjet.png"/>

<h1>Créer votre profile ici</h1>

<form method="post" action="${pageContext.request.contextPath}/creationcompteservlet">




<div>
Pseudo :<input type ="text" name = "pseudo" value="${param.pseudo}" required/>
</div>



<div>
Nom :<input type ="text" name = "nom" value="${param.nom }" required/>
</div>



<div>
Prenom :<input type ="text" name = "prenom" value="${param.prenom }" required/>
</div>



<div>
Email :<input type ="text" name = "email" value="${param.email }"required/>
</div>



<div>
Telephone :<input type ="tel" name = "telephone" value="${param.telephone }" required/>
</div>



<div>
Code Postal :<input type ="text" name = "codepostal" value="${param.codePostal }" required/>
</div>




<div>
Rue :<input type ="text" name = "rue" value="${param.rue }" required/>
</div>



<div>
Ville :<input type ="text" name = "ville" value="${param.ville }" required/>
</div>



<div>
Mot de passe : <input type ="password" name = "motdepasse" value="${param.motDePasse }" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"/>
</div>



<div>
Confirmation :<input type ="password" name = "confirmation" value="${param.motDePasse }" required/>
</div>






<div>
<button>
Créer
</button>
</div>

</form>

<div>
<button onclick= "window.location.href ='/Projet-ENI/encheres'">
Annuler
</button>
</div>



</body>
</html>