<style type="text/css">
<%@ include file="./style1.css"%>
</style>
<!DOCTYPE html>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${existe == false}">
    <p> n'existe pas</p>
</c:if>


<body>
	<div class="login-box">

		<h2>Login </h2>
		<form  method="post" action="Login">
			<div class="user-box">
				<input type="text" name="username" required=""> <label>Email</label>  
			</div>
			<div class="user-box">
				<input type="password" name="userpass" required=""> <label>Mot de Pass</label>
			</div>
			
    <input type="checkbox" name="remember" value="true"> <label>Se souvenir de moi</label>
  <br>
			<br>
			
			<input  type="submit" class="button" name="action" value="login"> 
			
			
		</form>
	</div>

	
</body>
</html>