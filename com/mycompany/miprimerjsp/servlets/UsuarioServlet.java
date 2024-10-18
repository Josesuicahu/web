package com.mycompany.miprimerjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.miprimerjsp.entidades.Usuario;
import com.mycompany.miprimerjsp.model.UsuarioData;
import com.mycompany.miprimerjsp.model.UsuarioDatabaseData;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioServlet extends HttpServlet {
    
    private final UsuarioData usuarioData = new UsuarioDatabaseData();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<Usuario> listaUsuarios = usuarioData.obtenerLista();
            request.setAttribute("listaUsuarios", listaUsuarios);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String username_cadena;
        Usuario usuario;
        int username;
        try {            
            switch (accion) {
                case "nuevo":
                    request.getRequestDispatcher("form_usuario.jsp")
                            .forward(request, response);
                    break;
                case "ver":
                    username_cadena = request.getParameter("codigo1");
                    username = Integer.parseInt(username_cadena);
                    usuario = usuarioData.obtener(username);
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("ver_usuario.jsp")
                            .forward(request, response);
                    break;
                case "editar":
                    username_cadena = request.getParameter("codigo1");
                    username = -1;
                    if (username_cadena != null && !username_cadena.isEmpty() && username_cadena.matches("\\d+")) {
                        username = Integer.parseInt(username_cadena);
                    }
                    usuario = usuarioData.obtener(username);
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("form_usuario.jsp").forward(request, response);
                    break;
                case "eliminar":
                    username_cadena = request.getParameter("codigo1");
                    username = Integer.parseInt(username_cadena);
                    usuarioData.eliminar(username);
                    doGet(request, response);
                    break;
                case "guardar":
                    usuario = new Usuario();
                    username_cadena = request.getParameter("hdnUsernameUsuarios");
                    username = (username_cadena == null || username_cadena.equals("")) ? 0 : Integer.parseInt(username_cadena);
                    usuario.setContrasena(request.getParameter("txtContrasena"));
                    usuario.setUsername(username);
                    usuario.setNombre(request.getParameter("txtNombreUsuario"));
                    usuario.setApellidos(request.getParameter("txtApellidos"));
                    usuario.setEmail(request.getParameter("txtEmail"));
                    usuario.setCargo(request.getParameter("txtCargo"));
                    if (username > 0) {
                        usuarioData.modificar(usuario);
                    } else {
                        usuarioData.agregar(usuario);
                    }       doGet(request, response);
                    break;
                case "volver":
                    doGet(request, response);
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
