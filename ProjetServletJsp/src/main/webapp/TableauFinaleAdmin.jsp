<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style type="text/css">
<style type="text/css">
<%@
include file="./style.css"
 
%>

</style>
</style>
<!DOCTYPE html>
<html>
<head>

<title>Liste Des Reclamations</title>
</head>
<body>
	

	


<div class="container">

<h1><b> Liste Des Reclamations </b></h1><br><br><br>
	<div class="table" >
		<div class="table-header">
			<div class="header__item"><a id="name" class="filter__link" href="#">Titre</a></div>
			<div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Description</a></div>
			<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">type</a></div>
	
		</div>
		<div class="table-content">	
					
			<c:forEach items="${reclamation}" var="cp">
				<div class="table-row">
				<div class="table-data">${cp.getTitre()}</div>
				<div class="table-data">${cp.getDescription()}</div>
				<div class="table-data">${cp.getTypereclamation().getType()}</div>
			
				</div></c:forEach>
			
		
		</div>	
	</div>
</div>
</body>
</html>

