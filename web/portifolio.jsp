<%-- 
    Document   : portifolio
    Created on : 17/11/2016, 10:41:00
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
    <link href="css/portifolio.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
    
    <div class="bannerimg">
    <img id="banner" src="imagem/portifolio/Portifolio.png">
    </div>
    
    <div class="container">
        <div class="portifolio">
            <ul id="album-fotos">
                <li id="foto01"><span> <img src="imagem/portifolio/1_Small.jpg"> </span></li>
                <li id="foto02"><span> <img src="imagem/portifolio/2_Small.jpg"> </span></li>
                <li id="foto03"><span> <img src="imagem/portifolio/3_Small.jpg"> </span></li>
                <li id="foto04"><span> <img src="imagem/portifolio/4_Small.jpg"> </span></li>
                <li id="foto05"><span> <img src="imagem/portifolio/5_Small.jpg"> </span></li>
                <li id="foto06"><span> <img src="imagem/portifolio/6_Small.jpg"> </span></li>
                <li id="foto07"><span> <img src="imagem/portifolio/7_Small.jpg"> </span></li>
                <li id="foto08"><span> <img src="imagem/portifolio/8_Small.jpg"> </span></li>
                <li id="foto09"><span> <img src="imagem/portifolio/9_Small.jpg"> </span></li>
            </ul>
        </div>
    </div>   
    
     <footer class="rodape-da-pagina">
        
        &emsp;&emsp;&emsp;&copy; <em> VM MakeUp </em>
        
    </footer>
        
</body>
</html>
