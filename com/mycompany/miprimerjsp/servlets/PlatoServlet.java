package com.mycompany.miprimerjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.miprimerjsp.entidades.Plato;
import com.mycompany.miprimerjsp.model.PlatoData;
import com.mycompany.miprimerjsp.model.PlatoDatabaseData;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dafne
 */
public class PlatoServlet extends HttpServlet {

    private PlatoData platoData = new PlatoDatabaseData();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Plato> listaPlatos = platoData.obtenerLista();
            request.setAttribute("listaPlatos", listaPlatos);
            request.getRequestDispatcher("platos.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            try(PrintWriter out = response.getWriter()){
                out.print(ex.getException());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String id_cadena;
        Plato plato;
        int id;
        try {
            switch (accion) {
                case "nuevo":
                    request.getRequestDispatcher("form_plato.jsp")
                            .forward(request, response);
                    break;
                case "ver":
                    id_cadena = request.getParameter("codigo1");
                    id = Integer.parseInt(id_cadena);
                    plato = platoData.obtener(id);
                    request.setAttribute("plato", plato);
                    request.getRequestDispatcher("ver_plato.jsp")
                            .forward(request, response);
                    break;
                case "editar":
                    id_cadena = request.getParameter("codigo1");
                    id = Integer.parseInt(id_cadena);
                    plato = platoData.obtener(id);
                    request.setAttribute("plato", plato);
                    request.getRequestDispatcher("form_plato.jsp")
                            .forward(request, response);
                    break;
                case "eliminar":
                    id_cadena = request.getParameter("codigo1");
                    id = Integer.parseInt(id_cadena);
                    platoData.eliminar(id);
                    doGet(request, response);
                    break;
                case "guardar":
                    plato = new Plato();
                    id_cadena = request.getParameter("hdnIdPlatos");
                    id = (id_cadena == null || id_cadena.equals("")) ? 0 : Integer.parseInt(id_cadena);
                    plato.setNombre(request.getParameter("txtNombrePlato"));
                    plato.setId(id);
                    plato.setCategoria(request.getParameter("txtCategoriaPlato"));
                    plato.setDescripcion(request.getParameter("txtDescripcionPlato"));
                    String stock_cadena = request.getParameter("txtStockPlato");
                    plato.setStock(Integer.parseInt(stock_cadena));
                    String novedad_cadena = request.getParameter("txtNovedadPlato");
                    boolean novedad = (novedad_cadena != null && novedad_cadena.equals("on"));
                    plato.setNovedad(novedad);
                    String precio_cadena = request.getParameter("txtPrecioPlato");
                    plato.setPrecio(Integer.parseInt(precio_cadena));
                    if (id > 0) {
                        platoData.modificar(plato);
                    } else {
                        platoData.agregar(plato);
                    }       doGet(request, response);
                    break;
                case "volver":
                    doGet(request, response);
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            try(PrintWriter out = response.getWriter()){
                out.print(ex.getException());
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
