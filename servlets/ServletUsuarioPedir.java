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
@WebServlet(name = "ServletUsuarioPedir", urlPatterns = {"/ServletUsuarioPedir"})
public class ServletUsuarioPedir extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletUsuarioPedir() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            //crea un objeto UsuarioController
            UsuarioController usuario = new UsuarioController();       //Llamar metodo del controlador
            
            String user = request.getParameter("username");
            if(user == null){
                user = "";
            }
            
            int username = Integer.parseInt(user.matches("^\\d+$")? user:"0");
            
            //Se llama al método pedir en el objeto usuario
            String usuarioStr = usuario.pedir(username);
            
            try (
                    PrintWriter out = response.getWriter()) {
                out.println(usuarioStr);
                out.flush();
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuarioPedir.class.getName()).log(Level.SEVERE, null, ex);
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
