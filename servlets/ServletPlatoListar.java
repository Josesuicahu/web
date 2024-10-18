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

@WebServlet(name = "ServletPlatoListar", urlPatterns = {"/ServletPlatoListar"})
public class ServletPlatoListar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPlatoListar() {
        super();        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlatoController plato = new PlatoController();
        boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
        String orden = request.getParameter("orden");
        try {
            
            String platoStr = plato.listar(ordenar, orden);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(platoStr);
                out.flush();
            }
            
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletPlatoListar.class.getName()).log(Level.SEVERE, null, ex);
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
