<%-- 
    Document   : form_plato
    Created on : 16 oct 2023, 2:13:01
    Author     : Dafne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.miprimerjsp.entidades.Plato" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuarios - Dominio</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">

        <script src="js/comun.js"></script>
        <script src="js/register.js"></script>
        <script src="js/usuario.js"></script>
        <script src="js/pedido.js"></script>

        <link href="css/index.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">

        <script>
            function realizarAccion(acc) {
                document.getElementById("accion").value = acc;
                document.forms[0].submit();
            }
        </script>
    </head>
    <body>
    <body class= "fondo">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid mx-5">
                <a id="home-btn" class="navbar-brand logo" href="home.jsp">
                    <span class="text-white">DOMINIO</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav ms-auto">                        
                        <li class="nav-item px-2 active">
                            <a id="inventario-btn" class="nav-link"">PLATOS</a>
                        </li>
                        <li class="nav-item px-2">
                            <a id="inventario-btn" class="nav-link" onclick="realizarAccion('volver')" href="usuarios">Usuarios</a>
                        </li> 
                        
                        <li class="nav-item dropdown px-2">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                HOME
                            </a>
                            <ul class="dropdown-menu bg-secondary" aria-labelledby="navbarDropdown">
                                <li><a id="inicio-btn" class="dropdown-item" href="home.jsp">Inicio</a></li>
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


        <main class="p-5 flex-column align-items-center">
            <div class="card col-6 mx-auto">

                <div class="px-5 pt-5 container text-center">
                    <h1>Ventana "Plato"</h1>
                </div>
                <hr class="my-4 mx-5">
                <div class="card-body ">
                    <form method="POST" action="platos" style="background-color: white " id="plato-form">
                        <br>
                        <div class="container">
                            <input type="hidden" name="accion" id="accion" value=""/>
                            <button type="submit" class="btn btn-outline-secondary" onclick="realizarAccion('volver')">&nbsp;Regresar</button>
                            <br>
                            <br>
                            <div class="px-5">
                                <div class="form-group">
                                    <label for="txtCodigoPlato">Id</label>
                                    <input type="hidden" name="hdnIdPlatos" id="hdnIdPlatos" value="${requestScope.plato.id}" />
                                    <input type="text" class="form-control form-control-sm" id="txtIdPlato" name="txtIdPlato" aria-describedby="nombreAyuda"
                                           value="${requestScope.plato.id}" disabled="disable"/>
                                </div>
                                <div class="form-group">
                                    <label for="txtNombrePlato">Nombre</label>
                                    <input type="text" class="form-control form-control-sm" id="txtNombrePlato" name="txtNombrePlato" placeholder="Ingrese el nombre del plato" aria-describedby="apellidoAyuda"
                                           value="${requestScope.plato.nombre}" />
                                </div>
                                <div class="form-group">
                                    <label for="txtCategoriaPlato">Categoria</label>
                                    <input type="text" class="form-control form-control-sm" id="txtCategoriaPlato" name="txtCategoriaPlato" placeholder="Ingrese la categoría del plato" aria-describedby="edadAyuda"
                                           value="${requestScope.plato.categoria}" />
                                </div>
                                <div class="form-group">
                                    <label for="txtDescripcionPlato">Descripción</label>
                                    <input type="text" class="form-control form-control-sm" id="txtDescripcionPlato" name="txtDescripcionPlato" placeholder="Ingrese su descripción del plato" aria-describedby="edadAyuda"
                                           value="${requestScope.plato.descripcion}" />
                                </div>
                                <div class="form-group">
                                    <label for="txtStockPlato">Stock</label>
                                    <input onchange="validarEntero(this)" type="number" class="form-control form-control-sm" id="txtStockPlato" name="txtStockPlato" placeholder="Ingrese el stock del plato" aria-describedby="correoAyuda1"
                                           value="${requestScope.plato.stock}" />
                                </div>
                                <div class="form-group">
                                    <label for="txtNovedadPlato">Novedad</label>
                                    <br>
                                    <input type="checkbox" class="form-check-input ml-auto mr-3" id="txtNovedadPlato" name="txtNovedadPlato" 
                                           ${requestScope.plato.novedad ? 'checked' : ''} />
                                </div>
                                <br>
                                <div class="form-group">
                                    <label for="txtPrecioPlato">Precio</label>
                                    <input onchange="validarEntero(this)" type="number" class="form-control form-control-sm" id="txtPrecioPlato" name="txtPrecioPlato" placeholder="Ingrese el precio del plato" aria-describedby="telefonoAyuda1"
                                           value="${requestScope.plato.precio}" />
                                    
                                </div>  
                                <button type="submit" class="btn btn-primary bi-save" onclick="realizarAccion('guardar');">&nbsp;Guardar</button>&nbsp;
                                <br><br>
                            </div>    
                        </div>
                    </form>
                </div>
            </div>               
        </main> 
                                        <script src="js/validacion.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</body>
</html>