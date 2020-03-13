<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%
  Usuario usuario = new Usuario();
    try{
        usuario = (Usuario) session.getAttribute("usuario");
        out.print("<tr><td> Seja bem vindo "+usuario.getPerfil().getPerfil()
                +    "---- " +"<a href='sair.jsp'>  sair</a></td></tr><tr> <td></td></tr>");
    } catch(Exception e){
        response.sendRedirect("login.jsp");
    }
    
    
%>    


<section id="corpo">
        <div class="container-fluid menu">
           
                <tr><c:forEach var="lista" items="${ usuario.perfil.menu }"> 
                    
                        <td><ul><li><a a href="${lista.link}">${lista.menu} <img src="${lista.icone}"</a></li></ul></td>
                           
                </c:forEach>
            
        </div>
     </section>



