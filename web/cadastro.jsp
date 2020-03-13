<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 



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
    <link href="css/agendamento.css" rel="stylesheet"> 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="css/agendamento.css" rel="stylesheet">

    
    <script language="javascript" >
            function validaForm(){
                formulario = document.form_cadastro;
                
                if(formulario.login.value==""){
                    alert("O Campo login deve ser preenchido!!");
                    formulario.login.focus();
                    return false;
                }
                if(formulario.senha.value==""){
                    alert("O Campo senha deve ser preenchido!!");
                    formulario.senha.focus();
                    return false;
                }
                if(formulario.nome.value==""){
                    alert("O Campo nome deve ser preenchido!!");
                    formulario.nome.focus();
                    return false;
                }
                if(formulario.cpf.value==""){
                    alert("O Campo cpf deve ser preenchido!!");
                    formulario.cpf.focus();
                    return false;
                }
                if(formulario.email.value==""){
                    alert("O Campo email deve ser preenchido!!");
                    formulario.email.focus();
                    return false;
                }
                if(formulario.telefone.value==""){
                    alert("O Campo telefone deve ser preenchido!!");
                    formulario.telefone.focus();
                    return false;
                }
                return true;
            }
        </script>

</head>

<img class="agendamento_img" class="img-responsive" src="imagem/$_32.jpg">

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
    
    <nav id="formulario">

        
        
        <form method="post" action="EfetuarCadastro" name="form_cadastro" onsubmit="return validaForm();">
   
            <label for="login"> Login <input id="login" type="text" name="login" size="80px"></label>
            <label for="senha"> Senha <input id="senha" type="password" name="password" size="80px"></label>
            <label for="nome"> Nome <input id="nome" type="text" name="nome" size="80px"> </label> 
            <label for="cpf"> CPF <input id=cpf type="text" name="cpf" size="80px"> </label>
            <label for="email"> e-Mail <input id="email" type="text" name="email" size="80px"> </label>
            <label for="telefone">  Telefone <input id="telefone" type="text" name="telefone" size="80px"></label>
            
                <label for="confirmar" id="botão-confirmação"></label> 
                    <input type="submit" class="button" value="Prosseguir">    
            </form>
  
    </nav>

</body>
</html>