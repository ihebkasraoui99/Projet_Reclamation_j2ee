<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style type="text/css">
<%@
include file="./style1.css"
 
%>
</style>
 <c:if test="${not empty loginError}">
    <script>
    window.addEventListener("load",function(){
         alert("${loginError}");
    }
    </script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<ul id="menu">
    <li><a href="/ProjetServletJsp/TableauxEtd">Acceuil</a></li>
  <li><a href="/ProjetServletJsp/AddEtudiant">Etudiant</a></li>
  <li><a href="/ProjetServletJsp/AddAdm">Admin</a></li>
</ul>
<title>Add Administrateur</title>
</head>
<body>
	<div class="login-box">

		<h2>Ajouter Un Administrateur</h2>
		<form  method="post">
		
			<div class="user-box">
				<input type="text" name="email" required=""> <label>Email</label>
			</div>
			<div class="user-box">
				<input type="text" name="pass" required=""> <label>Mot de Pass</label>
			</div>
			<input  type="submit" class="button"name="action" value="Ajout"/> 
			
			
		</form>
	</div>


</body>
</html>

