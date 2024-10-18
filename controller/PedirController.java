
package controller;

import ventas.Venta;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dafne
 */
public class PedirController extends DBConnection implements IPedirController {
    //GSON
    public PedirController() {
        super();
    }

    @Override
    public String listarPedir(String username) throws ClassNotFoundException {
        List<String> pedir = new ArrayList<>();

        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){ 
            PreparedStatement prepared = conex.prepareStatement("SELECT * FROM ventas WHERE mesero = ? and activo = 0");
            prepared.setString(1, username);
            ResultSet rs =  prepared.executeQuery();
            while (rs.next()) {
                Venta nuevaVenta = new Venta();
                
                Integer idVenta = rs.getInt("id_venta");
                String fecha = rs.getString("fecha");
                String horaInicio = rs.getString("hora_inicio");
                String horaFin = rs.getString("hora_fin");
                String mesero = rs.getString("mesero");
                String mesaR = rs.getString("mesa");
                double precio = rs.getDouble("precio");
                double descuento = rs.getDouble("descuento");
                double precioF = rs.getDouble("precio_final");
                String cliente = rs.getString("cliente");
                
                nuevaVenta.setIdVenta(idVenta);
                nuevaVenta.setFecha(fecha);
                nuevaVenta.setHoraInicio(horaInicio);
                nuevaVenta.setHoraFin(horaFin);
                nuevaVenta.setMesero(mesero);
                nuevaVenta.setMesa(mesaR);
                nuevaVenta.setPrecio(precio);
                nuevaVenta.setDescuento(descuento);
                nuevaVenta.setPrecioFinal(precioF);
                nuevaVenta.setCliente(cliente);
                
                pedir.add(GSON.toJson(nuevaVenta));

            }
        }
        catch(Exception ex) {
                System.out.println(ex.getMessage());
        }

        return GSON.toJson(pedir);
    }
    
}
