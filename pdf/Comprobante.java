
package pdf;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ventas.DetalleVenta;

public class Comprobante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
        
        String fecha = "2024-06-23";
        String horaInicio = "19:00";
        String horaFin = "20:00";
        String mesero = "Xiomara";
        String mesa = "Mesa 5";
        double precio = 530.0;
        double descuento = 10.0;
        double precioFinal = precio * (100 - descuento) / 100;
        String cliente = "Gaston Acurio recontra oficial";
        String documento = "DNI 95162348";
        String tipo = "Factura";

        ArrayList<DetalleVenta> detalles = new ArrayList<>();
        detalles.add(new DetalleVenta(1,3, "Ratatouille", 380.0));
        detalles.add(new DetalleVenta(2,3, "T Bone americano", 150.0));

        try {
            String path = getServletContext().getRealPath("/") + "pdf/";
            String nombreArchivo = ComprobantePDF.generarComprobante(path, fecha, horaInicio, horaFin, mesero, mesa, precio, descuento, precioFinal, cliente, documento, tipo, detalles);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("Comprobante generado: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al generar el comprobante: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al generar el comprobante");
        }
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
        doGet(request, response);
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
