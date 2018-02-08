<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="UTF-8">
			<title>Document</title>
			<link rel="stylesheet" type="text/css" href="css/homeuser.css">
		</head>
		<body>
			<header>
				<div class="head"><img src="img/Persona.jpg" width="55" height="55"><h3>Bienvenido/a ${id_user}</h3>
	            <a href="#">Editar perfil</a></div>
	            <div class="head"><h1>Banana GEST</h1><img src="img/banana.png" width="65" height="55"/></div>
	            <div class="head"><h4><a href="LogoutServlet">Logout</a></h4></div>    
			</header>
			<main>
				<section class="tareas">
					<nav>
						<h2>Tus tareas</h2>
						
						<table id="tabla" border="3" cellspacing="0" cellpadding="2" bordercolor="#666633" style="text-align: center; width: 90%"/>
							<tr>
								<td>
									<div>Tarea</div>
								</td>
								<td>
									<div>Nombre</div>
								</td>
								<td>
									<div>Fecha de inicio</div>
								</td>
								<td>
									<div>Descripción</div>
								</td>
								<td>
									<div>Estado</div>
								</td>
								<td>
									<div>Horas</div>
								</td>
								<td>
									<div></div>
								</td>
							</tr>
							<c:forEach items="${taskList}" var="task">	
							    <tr>
							    	<td>${task.id}</td>
							    	<td>${task.name}</td>
									<td>${task.date_start}</td>
									<td>${task.description}</td>
									<td>${task.state}</td>
									<td>${task.hours}</td>
									<td><a href="createtask"> <button class = "edit"> Editar</button></a></td>
							    </tr>
							</c:forEach>
						</table>
					</nav>	
				</section>
				<sidebar class="botones">
						<a href="createproject">
							<input class="crear" type="submit" name="boton" value="Crear proyecto" style="width:300px; height:40px;">
						</a>
						<a href="createproject.jsp">
						</a>
						<a href="createtask">
							<input class="crear" type="submit" name="boton" value="Crear tarea" style="width:300px; height:40px;">
						</a>
						<a href="createtask.jsp">		
						</a>
				</sidebar>
			</main>
			<br/>
			<footer>
				<div class="row">
					<span class="col-xs-12 col-sm-12 col-md-12 col-lg-12">Banana GEST - Política de privacidad y cookies</span>
				</div>
			</footer>
		</body>
	</html>