/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.miprimerjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.miprimerjsp.entidades.Inventario;
import com.mycompany.miprimerjsp.model.InventarioMemoryData;

public class InventarioServlet extends HttpServlet {

    private InventarioMemoryData inventarioData = new InventarioMemoryData();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Inventario> listaInventarios = inventarioData.obtenerLista();
        //request.getSession().setAttribute("lista.Inventarios", listaInventarios);
        request.setAttribute("lista.Inventarios", listaInventarios);
        request.getRequestDispatcher("inventario.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String accion = request.getParameter("accion");
        if (accion.equals("nuevo")) { //Nuevo
            //Colocar lineas para nuevo
            request.getRequestDispatcher("agregarInventario.jsp")
                    .forward(request, response);
        }/* else if (accion.equals("añadir")) { //añadir
            //Colocar lineas para añadir
            int id = Integer.parseInt(request.getParameter("txtIDInsumo"));
            String insumo = request.getParameter("txtInsumo");
            int stock = Integer.parseInt(request.getParameter("txtStockInsumo"));
            int stockMinimo = Integer.parseInt(request.getParameter("txtStockMinimoInsumo"));

            // Crear un nuevo objeto Inventario con los datos proporcionados
            Inventario nuevoInventario = new Inventario(id, insumo, stock, stockMinimo);

            // Agregar el nuevo inventario
            inventarioData.agregar(nuevoInventario);

            // Redirigir a la página de inventario
            List<Inventario> listaInventarios = inventarioData.obtenerLista();
            request.setAttribute("lista.Inventarios", listaInventarios);
            request.getRequestDispatcher("inventario.jsp")
                    .forward(request, response);
        }*/ else if (accion.equals("editar")) { //Editar
            //Colocar lineas para editar
            String id_cadena = request.getParameter("codigo1");
            int id = Integer.parseInt(id_cadena);
            Inventario inventario = inventarioData.obtener(id);
            request.setAttribute("inventario", inventario);
            request.getRequestDispatcher("agregarInventario.jsp")
                    .forward(request, response);
        } else if (accion.equals("eliminar")) {//Eliminar
            //Colocar lineas para eliminar
            String id_cadena = request.getParameter("codigo1");
            int id = Integer.parseInt(id_cadena);
            Inventario inventario = inventarioData.obtener(id);
            inventarioData.eliminar(id);
            List<Inventario> listaInventarios = inventarioData.obtenerLista();
            request.setAttribute("lista.Inventarios", listaInventarios);
            request.getRequestDispatcher("inventario.jsp").forward(request, response);
            
        } else if (accion.equals("volver")) {//Volver
            //Colocar lineas para volver (listado)
            doGet(request, response);
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
    }

}
