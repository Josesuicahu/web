<%-- 
    Document   : index
    Created on : 9 sept 2023, 23:52:58
    Author     : Dafne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - LA GUERRILLA</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
        
        <script src="js/comun.js"></script>
        <script src="js/index.js"></script>
        <script src="js/pedido.js"> </script>
        <script src="js/usuario.js"> </script>
        
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        
    </head>
    <body class="fondoHome">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid mx-5">
                <a class="navbar-brand logo">
                    <span class="text-white">LA GUERRILLA</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item px-2">
                            <a id="inventario-btn" class="nav-link"  href="platos">Platos</a>
                        </li>                 
                        <li class="nav-item px-2">
                            <a id="inventario-btn" class="nav-link" onclick="realizarAccion('volver')" href="usuarios">Usuarios</a>
                        </li> 
                        <li class="nav-item dropdown px-2">
                            <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                HOME
                            </a>
                            <ul class="dropdown-menu bg-secondary" aria-labelledby="navbarDropdown">
                                <li><span class="dropdown-item" onClick="salir()">Cerrar Sesión</span></li>
                            </ul>
                        </li>
                        <li class="nav-item bg-secondary px-2 rounded">
                            <a class="nav-link"  aria-current="page" href="#">
                                <span class="text-white" id="nombreusuario"></span>
                            </a>
                        </li>
                        <li class="nav-item bg-secondary px-2 rounded">
                            <a class="nav-link"  aria-current="page" href="#">
                                <span class="text-white" id="cargousuario"></span>
                            </a>
                        </li>
                        
                    </ul>
                    <hr class="d-md-none text-white-50">
                </div>
            </div>  
        </nav>
        <div class="container my-5 text-center">
            <div class=" card jumbotron">
                <h1 class="display-4">Bienvenido al Sistema de Administración</h1>
                <p class="lead">Gestiona tus usuarios, productos de forma sencilla y eficiente.</p>
                <hr class="my-4">
                <p>Registra usuarios ahora.</p>
                <a id="registerHome-btn" class=" mx-5 btn btn-primary btn-lg" href="register.jsp" role="button">Registrar</a>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
