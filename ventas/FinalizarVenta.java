/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ventas;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "FinalizarVenta", urlPatterns = {"/FinalizarVenta"})
public class FinalizarVenta extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public FinalizarVenta() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson gson = new Gson();                
        
        Venta nuevaVenta = new Venta();
        
        int idVenta =  Integer.parseInt(request.getParameter("idVenta"));
        String fecha = request.getParameter("fecha");
        String horaInicio = request.getParameter("horaInicio");
        String horaFin = request.getParameter("horaFin");
        int mesero =  Integer.parseInt(request.getParameter("mesero"));
        int mesa =  Integer.parseInt(request.getParameter("mesa"));
        double precio =  Double.parseDouble(request.getParameter("precio"));
        double descuento =  Double.parseDouble(request.getParameter("descuento"));
        double precioFinal =  Double.parseDouble(request.getParameter("precioFinal"));
        String cliente = request.getParameter("cliente");
        String documento = request.getParameter("documento");
        String tipoComprobante = request.getParameter("tipoComprobante");
        
        System.out.println(idVenta);    // pasa el parametro al servlet 
        
        System.out.println(tipoComprobante);    // pasa el parametro al servlet 
        
        String result = nuevaVenta.finalizarVenta(idVenta, fecha, horaInicio, horaFin, mesero, mesa, precio, descuento, precioFinal, cliente, documento, tipoComprobante);
        String otra = "Pruab de que entra al servelt";
        
//        String result = username + mesa + hora;
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
