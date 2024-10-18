<%-- 
    Document   : index
    Created on : 4 dec 2023, 01:13:48
    Author     : Jorge
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
        <script src="js/pedido.js"></script>
        <script src="js/usuario.js"></script>

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
                            <a id="ventas-btn" class="nav-link"  href="ventas.jsp">Ventas Realizadas</a>
                        </li>                
                        <li class="nav-item px-2">
                            <a id="pedido-btn" class="nav-link"  href="pedido.jsp">Menú</a>
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
        <div class="container my-2 text-center">
            <div class=" card jumbotron">
                <h3 class="display-6">Finalizar venta mesa <span id="numero-mesa"></span></h3>
                <form  id="finalizarMesaForm">
                    <div class="row">
                        <div class="col-md-6">

                            <div class="form-group">
                                <label for="tipo">Tipo:</label>
                                <select class="form-control" id="tipo" name="tipo" required>
                                    <option value="Boleta">Boleta</option>
                                    <option value="Factura">Factura</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="cliente">Cliente:</label>
                                <input type="text" class="form-control" id="cliente" name="cliente" required>
                            </div>
                            <div class="form-group">
                                <label for="documento">Documento:</label>
                                <input type="text" class="form-control" id="documento" name="documento">
                            </div>

                            <!-- Columna 1 del formulario -->
                            <div class="form-group">
                                <label for="fecha">Fecha:</label>
                                <input type="date" class="form-control" id="fecha" name="fecha" required disabled>
                            </div>
                            <div class="form-group">
                                <label for="horaInicio">Hora Inicial:</label>
                                <input type="time" class="form-control" id="horaInicio" name="horaInicio" required disabled>
                            </div>
                            <div class="form-group">
                                <label for="horaFin">Hora Final:</label>
                                <input type="time" class="form-control" id="horaFin" name="horaFin" required disabled>
                            </div>

                        </div>

                        <!-- Columna 2 del formulario -->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="mesero">Mesero:</label>
                                <input type="text" class="form-control" id="mesero" name="mesero" required disabled>
                            </div>

                            <div class="form-group">
                                <label for="precio">Precio:</label>
                                <input type="number" class="form-control" id="precio" name="precio" required disabled>
                            </div>
                            <div class="form-group">
                                <label for="descuento">Descuento en %:</label>
                                <input value="0" type="number" class="form-control" id="descuento" name="descuento" onchange="calcular_final(this)">
                            </div>
                            <div class="form-group">
                                <label for="precioFinal">Precio Final:</label>
                                <input type="text" class="form-control" id="precioFinal" name="precioFinal" required disabled>
                            </div>
                            <br>
                            <button type="submit" class="btn btn-mesa btn-success">Finalizar</button>
                            <button class="btn btn-mesa btn-warning" onClick="volver_mesa()">Volver</button>
                        </div>
                    </div>
                </form>

            </div>

        </div>
    </div>

    <script src="js/finalizarventa.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
