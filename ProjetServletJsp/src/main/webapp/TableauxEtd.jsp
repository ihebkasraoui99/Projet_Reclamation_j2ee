<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style type="text/css">

</style>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@
include file="./style.css"
 
%>

</style>
<head>
<title>Liste Des Etudiants</title>
<ul id="menu">
  <li><a href="/ProjetServletJsp/TableauxEtd">Acceuil</a></li>
  <li><a href="/ProjetServletJsp/AddEtudiant">Etudiant</a></li>
  <li><a href="/ProjetServletJsp/AddAdm">Admin</a></li>
</ul>
</head>

</head>
<body>
	
<div class="container">

	<h1><b> Liste Des Etudiants </b></h1><br><br><br>
	
	<div class="table" >
		<div class="table-header">
			<div class="header__item"><a id="name" class="filter__link" href="#">Nom</a></div>
			<div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Prenom</a></div>
			<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Email</a></div>
		<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Password</a></div>
			<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Etat</a></div>
					<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Reclamation</a></div>
		</div>
		<div class="table-content">	
					
			<c:forEach items="${comptes}" var="cp">
				<div class="table-row">
				<div class="table-data">${cp.getNom()}</div>
				<div class="table-data">${cp.getPrenom()}</div>
				<div class="table-data">${cp.getEmail()}</div>
				<div class="table-data">${cp.getPassword()}</div>
				<div class="table-data"><a href="/ProjetServletJsp/Validation?name=${cp.getNom()}&prenom=${cp.getPrenom()}&username1=${cp.getEmail()}&userpass1=${cp.getPassword()}&active=${cp.isActive()}">${cp.isActive()}</a></div>
				<div class="table-data"><a href="/ProjetServletJsp/TableauFinaleAdmin?name=${cp.getNom()}&prenom=${cp.getPrenom()}&username1=${cp.getEmail()}&userpass1=${cp.getPassword()}&active=${cp.isActive()}">Voir</a></div>
				</div></c:forEach><br><br><a class="button"  href="/ProjetServletJsp/AddTypeReclamation">Ajouter Un Type De Reclamation</a>
				<a href="/ProjetServletJsp/Login" class="button" >Deconnexion</a>
			
		
		</div>	
	</div>
</div>
	

	
</body>
</html>

