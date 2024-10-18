
package servlets;

import controller.PlatoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dafne
 */
@WebServlet(name = "ServletPlatoPedir", urlPatterns = {"/ServletPlatoPedir"})
public class ServletPlatoPedir extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPlatoPedir() {
        super();        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlatoController plato = new PlatoController();
        String nombrePlato = request.getParameter("nombre");
        String idstr = request.getParameter("id");
        String preciostr = request.getParameter("precio");
        String ventas = request.getParameter("idventa");
        int precio = 0;
        int id = 0;
        int idVenta = 0;
        
        try {
            
            if(idstr != null){
                id = Integer.parseInt(idstr);
            }
            
            if(preciostr != null){
                precio = Integer.parseInt(preciostr);
            }
            
            if(ventas != null){
                idVenta = Integer.parseInt(ventas);
            }
            
            String platoStr = plato.pedir(id,nombrePlato,precio,idVenta);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(platoStr);
                out.flush();
            }
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletPlatoPedir.class.getName()).log(Level.SEVERE, null, ex);
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
