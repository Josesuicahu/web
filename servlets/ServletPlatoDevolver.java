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
@WebServlet(name = "ServletPlatoDevolver", urlPatterns = {"/ServletPlatoDevolver"})
public class ServletPlatoDevolver extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPlatoDevolver() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlatoController plato = new PlatoController();
        int id = Integer.parseInt(request.getParameter("id"));
        String consumo = request.getParameter("consumo");
        try {
            String platoStr = plato.devolver(id, consumo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(platoStr);
                out.flush();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletPlatoDevolver.class.getName()).log(Level.SEVERE, null, ex);
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
    }

}
