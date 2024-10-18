<%-- 
    Document   : profile
    Created on : 11 sept 2023, 2:12:17
    Author     : Dafne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <!-- jQuery library -->
        <title>Detalle de Pedido - LA GUERRILLA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        
        <script src="js/comun.js"></script>
        <script src="js/register.js"></script>
        <script src="js/usuario.js"></script>
        <script src="js/detallePedido.js"></script>
        <script src="js/pedido.js"></script>
        
        <link href="css/index.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/detallePedido.css" rel="stylesheet">
        
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid mx-5">
                <a id="home-btn" class="navbar-brand logo" href="mesero.jsp">
                    <span class="text-white">LA GUERRILLA</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div id="user-data-profile">
                    <span class="badge bg-secondary mr-3 user-saldo" id="user-saldo"></span>
		</div>
                
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item px-2">
                            <a id="ventas-btn" class="nav-link"  href="ventas.jsp">Pedido</a>
                        </li>                 
                        <li class="nav-item dropdown px-2">
                            <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                DETALLE PEDIDO
                            </a>
                            <ul class="dropdown-menu bg-secondary" aria-labelledby="navbarDropdown">                             
                                <li><a id="pedido-btn" class="dropdown-item" href="pedido.jsp">Menú</a></li>
                            </ul>
                        </li>                                              
                        <li class="nav-item dropdown px-2">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                HOME
                            </a>
                            <ul class="dropdown-menu bg-secondary" aria-labelledby="navbarDropdown">
                                <li><a id="inicio-btn" class="dropdown-item" href="mesero.jsp">Inicio</a></li>
                                <li><span class="dropdown-item" onClick="salir()">Cerrar Sesión</span></li>
                            </ul>
                        </li>
                        <li class="nav-item bg-secondary px-2 rounded">
                            <a class="nav-link"  aria-current="page" href="profile.jsp">
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
        
        <main class="p-4 d-flex flex-column align-items-center">
		<h1>Detalle de pedido</h1>
		
                <table class="table d-none" id="historial-table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Categoria</th>
                                        <th scope="col">Descripcion</th>
                                        <th scope="col">Precio</th>
					<th scope="col">Novedad</th>
					<th scope="col">Fecha</th>
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody id="historial-tbody">
			</tbody>
		</table>
                <div id="historial-lleno">
                    <a  class=" mx-5 btn btn-success btn-lg" href="ventas.jsp" role="button">Ver pedido</a>
                </div>
                
		<div id="historial-vacio" class="alert alert-info" role="alert">
                    No hay elementos en el Pedido
                </div>
		 
	</main>
        
        <!--<!-- despegable -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
