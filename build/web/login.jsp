<%-- 
    Document   : login
    Created on : 17/11/2016, 10:45:36
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- Swett Alert -->
    <script src="dist/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
    
    <script language="javascript" >
            function validaForm(){
                formulario = document.form_login;
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


                return true;
            }
        </script>
    
</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
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
    
    
    
    <header>
        
        <div class="header-content">
            <div class="header-content-inner">    
                <h1 id="homeHeading"> VM MAkeUp </h1>
                <hr>
                <p> Ficar linda, nunca foi tão fácil!</p>
            </div>
        </div>
    </header>

    <div class="campo-formulario-login">
    <nav id="formulario">         
        <form method="post" action="EfetuarLogin" name="form_login" onsubmit="return validaForm();">
             <a href="" onClick="document.getElementById('login.php').submit(); ">
                <input type="button" class="button2" value="CADASTRAR" 
                       onclick="location.href='cadastro.html'"></a> <br>
            <label for="login">LOGIN</label><br>
                <input type="text" id="login" name="login"><br>
            <label for="senha">SENHA</label><br>
                <input type="password" id="senha" name="senha"><br>
            <label for="confirmar" id="botão-confirmação"></label> 
                <input type="submit" class="button" value="Entrar"> 
        </form>
    </nav>    
    </div>
    <section class="bg-primary" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 text-center">
                        <h2 class="section-heading"> Nós temos o que você precisa!</h2>
                        <hr class="light">
                        <p class="text-faded"> VM MakeUp sempre está onde você mais precisa. Com serviços a domicílio, oferencedo o melhor para as melhores!</p>

                    </div>
                </div>
            </div>
        </section>
    
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/creative.min.js"></script>
    
    <footer class="rodape-da-pagina">
        
        &emsp;&emsp;&emsp;&copy; <em> VM MakeUp </em>
        
    </footer>
    
</body>

</html>
