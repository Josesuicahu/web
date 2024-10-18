/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pdf;

import ventas.Venta;
import ventas.DetalleVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public pdf() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venta nuevaVenta = new Venta();

        int idVenta = Integer.parseInt(request.getParameter("idventa"));
        try {

            nuevaVenta.obtenerVenta(idVenta);
            String tipoP = request.getParameter("tipo");
            String msg = nuevaVenta.message();
            if (!msg.equals("true")) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
                return;
            }
            
            String fecha = nuevaVenta.getFecha();
            String horaInicio = nuevaVenta.getHoraInicio();
            String horaFin = nuevaVenta.getHoraFin();
            String mesero = nuevaVenta.getMesero();
            String mesa = nuevaVenta.getMesa();
            double precio = nuevaVenta.getPrecio();
            double descuento = nuevaVenta.getDescuento();
            double precioFinal = nuevaVenta.getPrecioFinal();
            String cliente = nuevaVenta.getCliente();
            String documento = nuevaVenta.getDocumento();
            String tipo = nuevaVenta.getTipo();
            ArrayList<DetalleVenta> detalles = nuevaVenta.getDetalles();
            String path = getServletContext().getRealPath("/") + "pdf/";
            String pedidoStr = "'TIPO' NOT FOUND!";
            if(tipoP != null)switch(tipoP){
                case "boleta":
                    pedidoStr = constructorPDF.crearPDF(path,fecha, horaInicio, horaFin, mesero, mesa, precio, descuento, precioFinal, cliente, documento, "boleta", detalles);
                    break;
                case "factura":
                    pedidoStr = ComprobantePDF.generarComprobante(path,fecha, horaInicio, horaFin, mesero, mesa, precio, descuento, precioFinal, cliente, documento, "factura", detalles);
                    break;
                default:
            }
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(pedidoStr);
                out.flush();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
