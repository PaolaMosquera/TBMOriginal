<%@page import="controlador.conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaProveedores.css" type="text/css" rel="stylesheet" />
<title>Pagina Proveedores</title>
</head>
<header>
<div class="logo"><img src="IMG/TBMBanner.jpg" alt="TBM" class="logo"></div>
	<nav>
		<a href="/Proyecto/PaginaUsuario.jsp" class="nav-item">Usuarios</a>
		<a href="/Proyecto/PaginaCliente.jsp" class="nav-item">Clientes</a>
		<a href="/Proyecto/PaginaProveedores.jsp" class="nav-item">Proveedores</a>
		<a href="/Proyecto/PaginaProductos.jsp" class="nav-item">Productos</a>
		<a href="/Proyecto/PaginaVentas.jsp" class="nav-item">Ventas</a>
		<a href="/Proyecto/PaginaReportes.jsp" class="nav-item">Reportes</a>
		<div class="animation start-home"></div>
	</nav>	
	
</header>
<body>
<%
conexion cn=new conexion();
cn.conexionbd();
String nit="";
String ciudad="";
String direccion="";
String nombre="";
String telefono="";

if(request.getParameter("ni")!=null){
nit=request.getParameter("ni");
ciudad=request.getParameter("ci");
direccion=request.getParameter("di");
nombre=request.getParameter("no");
telefono=request.getParameter("te");
}
%>
<form action="Servletproveedores" method="post">
	<div><h1>Información de proveedores</h1></div>
	
	<div class="form-content">
		<div>
			<label class="labelestil" for="cedula">Nit:</label>
			<input type="number" id="nit" value="<%=nit %>" required="" name="nit"/>
		</div>
		<div>
			<label class="labelestil" for="nombreusuario">Nombre proveedor:</label>
			<input type="text" id="nombre" value="<%=nombre %>" name="nombre">
		</div>
		<div>
			<label class="labelestil" for="email">Ciudad:</label>
			<input type="text" id="ciudad" value="<%=ciudad %>" name="ciudad">
		</div>
		<div>
			<label class="labelestil" for="usuario">Dirección:</label>
			<input type="text" id="direccion" value="<%=direccion %>" name="direccion">
		</div>
		<div>
			<label class="labelestil" for="password">Telefono:</label>
			<input type="text" id="telefono" value="<%=telefono %>" name="telefono">
		</div>
	</div>
	<div>
		<input type="submit" name="btninsc" class="btninsu" value="Crear Proveedor">
		<input type="submit" name="btncrsu" class="btninsu" value="Consultar Proveedor">
		<input type="submit" name="btnacsu" class="btninsu" value="Actualizar Proveedor">
		<input type="submit" name="btnelsu" class="btninsu" value="Eliminar Proveedor">
	</div>
</form>	
</body>
</html>