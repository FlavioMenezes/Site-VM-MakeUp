
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Perfil"%>
<%@page import="modelo.PerfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>VM MakeUp</title>
    <link rel="shortcut icon" href="imagem/brush.png">
    <!-- Bootstrap Core CSS -->
    <link href="css/reset.css" rel="stylesheet">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/formulario.css" rel="stylesheet">
    <link href="css/plogin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.css" rel="stylesheet">
    <link href="css/portifolio.css" rel="stylesheet">
    <link href="css/indexjsp.css" rel="stylesheet">  
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Gerenciar Menu</title>
        
        <script language="javascript" >
            function validaForm(){
                formulario = document.form_gerenciar;
                if(formulario.id_menu.value === ""){
                    alert("Nao ha Menus a Vincular!!!");
                    formulario.id_menu.focus();
                    return false;
                }
              

                return true;
            }
        </script>
        
        
    </head>
   <body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-portifolio">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">VM MakeUp</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">                 
                    <li>
                        <a href="index.html"> VOLTAR </a>
                    </li>
                    <li>
                        <a class="page-scroll" href="agendamento.jsp">Agendar</a>
                    </li>
                    <li>
                        <a href="login.jsp">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
        <div>
          <selection id="corpo">
         <div class="container-fluid tabela">
             <table id="tabela-dados">
                 
                <tr>
                        <td> <%@include file="menu.jsp" %> </td>
                </tr>
                <td width="760" height="330">
                        <div align="center">
                            <form name="form_gerenciar" method="post" action="PerfilServlet" onsubmit="return validaForm();">
                                <%
                                    //int id = Integer.parseInt(request.getParameter("id"));
                                    //int id = 1;
                                    //Perfil perfil = new Perfil();
                                   // ArrayList<Menu> listaVinculados = new ArrayList<Menu>();
                                   // ArrayList<Menu> listaDesvinculados = new ArrayList<Menu>();
                                %>
                                <input type="hidden" name="id_perfil" value="${perfil.id}" >
                                <input type="hidden" name="cmd" value="vincular" >
                                 PERFIL ATUAL:${perfil.perfil}<br>
                                MENU:<select name="id_menu" size="1">
                                    <option value="">Escolha um menu</option>
                                    <c:forEach var="lista" items="${listaDesvinculados}">
                                    <option value="${lista.id}">${lista.menu}</option>
                                    </c:forEach>
                                </select>
                                <input type="submit" value="Vincular" onclick="return validaForm();" >
                            </form>                            
                            <br><br>
                            <table id="tabela-dados2">
                                <tr>
                                    <td>ID</td>
                                    <td>MENU</td>
                                    <td>DESVINCULAR</td>
                                </tr>
                                    <c:forEach var="lista" items="${ listaVinculados }">
                                 <tr>
                                    <td>${lista.id}</td>
                                    <td>${lista.menu}</td>
                                    <td align="center"><a href="PerfilServlet?id_menu=${lista.id}&id_perfil=${perfil.id}&cmd=desvincular"><img src="imagem/excluir.png" border="0"></a></td>
                                </tr>
                                    </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </table>  
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br>                                    <br>                                    
    </body>
    <footer>
        
        
    </footer>