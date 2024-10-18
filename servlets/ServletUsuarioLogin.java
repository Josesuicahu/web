package servlets;

import controller.UsuarioController;
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

@WebServlet(name = "ServletUsuarioLogin", urlPatterns = {"/ServletUsuarioLogin"})
public class ServletUsuarioLogin extends HttpServlet {

    private static final long serialVersionUID =1L;
    
    public ServletUsuarioLogin(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //crea un objeto UsuarioController
        UsuarioController usuario = new UsuarioController();
        
        //leemos los parametros ingresados
        String usernameParam = request.getParameter("username");
        String contrasenaParam = request.getParameter("contrasena");
        String result = "";

        if (usernameParam != null || contrasenaParam != null) {
            try {
                result = usuario.login(Integer.parseInt(usernameParam), contrasenaParam);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletUsuarioLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Devolvemos datos al usuario
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println(result);  // Mostrar
            out.flush();            // Asegura
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
