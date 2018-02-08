<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- <jsp:useBean id="saveTask" class="com.generation.jwd.p1.beans.Task" scope="request"></jsp:useBean> --%>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear tarea | Banana GEST</title>
        <link rel="stylesheet" type="text/css" href="css/createTask.css">
    </head>
    <body>
        <header>
            <div class="head"><img src="img/Persona.jpg" widtd="55" height="55"><h3>Bienvenido/a ${id_user}</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="img/banana.png" width="65" height="55"/></a></div>
            <div class="head"><h4><a href="LogoutServlet">Logout</a></h4></div>
        </header>
            <h2>Registro de nueva tarea</h2>
            <hr>
        <main>
            <form method="post" action="createtask" id ="createtask">
                <p>
                    <table id="basic">
                        <tr class="contenttable">
                            <td class="namecontent" align="right">Nombre</td>
                            <td class="contenttable">
                                <input style="background-color:#F5BFB2;" type="text" placeholder="Nombre de la tarea" required="true"
                                name="name" id="name" autofocus/>
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent" align="left">Descripción</td>
                            <td class="contenttable">
                                <textarea id="description" name="description" required="true" rows="15" cols="60"
                                 ></textarea>
                            </td>
                        </tr>
                         <tr>
                            <td class="namecontent" align="left">Fecha de inicio</td>
                            <td class="contenttable">
                                <input id="date_start" type="date" name="date_start" required="true"/>               
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent" align="left">Estado</td>
                            <td class="contenttable">
                                <select  class="selectionbuton" id="state" name="state" required="true">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent" align="left">Horas asignadas</td>
                            <td class="contenttable">
                                 <input type="number" id="hours" name="hours" min="0"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent" align="left">Usuario asignado</td>
                            <td class="contenttable">
                                <select  class="selectionbuton" id="id_user" name="id_user" required="true">
                                    <c:forEach items="${userList}" var="user">
	                                    <option value="${user}">${user}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                         <tr>
                            <td class="namecontent" align="left">Proyecto asignado</td>
                            <td class="contenttable">
                                <select  class="selectionbuton" id="id_project" name="id_project" required="true">
                                    <c:forEach items="${projectList}" var="project">
	                                    <option value="${project}">${project}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>                                  
                    </table>
                </p>
                <div id="boton">
                    <button  style="width:150px; height:40px;">Crear Tarea</button>
                </div>
            </form>
        </main>
        <footer>
            <span>Banana GEST - Todos los derechos reservados</span>
        </footer>
        <script>
           /*  function validar(){
                var inpObj = document.getElementById("formtask");
                if (inpObj.checkValidity() == false) {
                    alert("Task has not created")
                } else{ 
                    alert("Task has been created")
                }            
            } */
        </script>
    </body>
    </html>