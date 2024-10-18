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
@WebServlet(name = "NuevaVenta", urlPatterns = {"/NuevaVenta"})
public class NuevaVenta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public NuevaVenta() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Gson gson = new Gson();
            Venta nuevaVenta = new Venta();

            String username = request.getParameter("username");
            String mesa = request.getParameter("mesa");
            String hora = request.getParameter("hora");
            String result = nuevaVenta.register(username, mesa, hora);

//        String result = username + mesa + hora;
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(gson.toJson(result));
                out.flush();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
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
