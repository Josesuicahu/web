<%-- 
    Document   : index
    Created on : 6 sept 2023, 23:52:58
    Author     : Dafne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/comun.js"></script>
        <script src="js/index.js"></script>
        <link href="css/index.css" rel="stylesheet">
        <title>Login - LA GUERRILLA</title>
    </head>
    <body class="d-flex justify-content-center align-items-center vh-100 fondo-login">
        <div class="container py-3s">
            <div class="card my-3" >
                <div class="card-body">
                    <div class="row m-3">
                        <div class="col-md-6 bg-login-image"></div>
                        <div class="col-md-6">
                            <h1 class="h4 text-gray-900 my-3">Bienvenido</h1>
                            <form id="form-login">
                                <div class="form-group">
                                    <input autocomplete="off" type="text" name="username" class="form-control" id="usuario" placeholder="Usuario" required>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="Contraseña" required>
                                </div>
                                <input type="submit" class="btn btn-primary btn.block" id="BTNENTRAR" value="Iniciar Sesión">
                                <hr>
                            </form>
                        </div>
                    </div>
                    <div id="login-error" class="alert alert-danger d-none" role="alert">Usuario o contraseña incorrectos</div>
                </div>
            </div>
        </div>
    </body>
</html>

