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
@WebServlet(name = "ObtenerVenta", urlPatterns = {"/ObtenerVenta"})
public class ObtenerVenta extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ObtenerVenta() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson gson = new Gson();                
        
        Venta nuevaVenta = new Venta();
        
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        
        
//        String result = nuevaVenta.obtenerVenta(idVenta);
        String otra = "Pruab de que entra al servelt";
        
//        String result = username + mesa + hora;
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(otra);
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
