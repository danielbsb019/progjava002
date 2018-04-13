<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import= "model.Pais"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> - Novo Pais</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>


              <c:import url="Menu.jsp"/>

<div id="main" class="container">
<h3 class="page-header">Ultimo Pais Incluido</h3>




<div class="row">
<div class="col-md-4">
<p>id: ${Pais.id}</p>
 
</div>
</div>
<br>
<div class="row">
<div class ="col-md-3">
<p>Nome:  ${Pais.nome}</p>


</div>
</div>
<br>
<div class="row">
<div class="col-md-3">
<p>Populacao:  ${Pais.pop} </p>


</div>
</div>
<br>

<div class="row">
<div class="col-md-2">
<p>Area:  ${Pais.area}</p>
 

</div>
</div>




</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>