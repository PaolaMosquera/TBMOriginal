<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/Login2.css" type="text/css" rel="stylesheet" />
<title>Iniciar sesion</title>
</head>
<body>
<div class="mobile-screen">
  <div class="header">
    <h1>Iniciar sesion</h1>
  </div>
  
  <div class="logo"><img src="IMG/Logotipo.png" alt="TBM" class="logo"></div>

  <form action="controladorlogin" method="post" id="login-form">
    <input type="text" name="user" placeholder="Usuario" required="" id="username" />
    <input type="password" name="password" placeholder="Contraseña" required="" id="password" />
    <input type="submit" class="login-btn" value="Ingresar">
  </form>
   
  
</div>
</body>
</html>