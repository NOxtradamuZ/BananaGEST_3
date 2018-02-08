<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Banana GEST | Login</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
		<header class="container-fluid">			
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><h1>Banana GEST</h1></div>
			</div>		
		</header>
		<main class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<img id= "bananas" src="img/banana.png" width="100" height="90"/>
					<form action="login" method="POST" id="formulario">
						<p class="error">${error}</p>
						<p class="disconnect">${disconnect}</p>
						<div class="intro_user">
							<img class="alinear" src="img/name.png"/>
							<input type="text" name="email" placeholder="Email" required="true" autofocus/>
						</div>
						<div class="intro_user">
							<img class="alinear" src="img/padlock.png"/>
							<input type="password" name="password" placeholder="Password" maxlength="12" minlength="4" required="true"/>
						</div>
						<div class="intro_user">
						<a class="password" href="#">He olvidado mi contraseña</a>
						</div>	
						<div class="intro_user">
							<button style="width:150px; height:40px;">Log In</button>
						</div>
					</form>										
					<div class="intro_user">
						<a href="https://twitter.com/?lang=es">
						<img src="img/twitter.png" width="35" height="35"/>
						</a>
						<a href="https://es-es.facebook.com/">
						<img src="img/facebook.png" width="35" height="35"/>
						</a>
						<a href="https://es.linkedin.com/">
						<img src="img/linkedin.png" width="35" height="35"/>	
						</a>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<div>
				<span>Banana GEST - Todos los derechos reservados</span>
			</div>
		</footer>
	</body>
</html>