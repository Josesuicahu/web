/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Venta extends DBConnection {

    private int idVenta;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String mesero;
    private String mesa;
    private double precio;
    private double descuento;
    private double precioFinal;
    private String cliente;
    private String documento;
    private String tipo;
    private ArrayList<DetalleVenta> detalles;

    // Constructor
    public Venta() {
        super();
        this.detalles = new ArrayList<>();
    }

    public Venta(int idVenta, String fecha, String horaInicio, String horaFin, String mesero,
            String mesa, double precio, double descuento, double precioFinal,
            String cliente, String documento, String tipo, ArrayList<DetalleVenta> detalles) {
        super();
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.mesero = mesero;
        this.mesa = mesa;
        this.precio = precio;
        this.descuento = descuento;
        this.precioFinal = precioFinal;
        this.cliente = cliente;
        this.documento = documento;
        this.tipo = tipo;
        this.detalles = detalles;
    }

    // Métodos getter y setter para acceder a los campos privados
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
    
    private String msg = "true";
    public String message(){
        return msg;
    }
    
    public void message(String msg){
        this.msg = msg;
    }

    // Método toString para representar la información de la clase como cadena
    @Override
    public String toString() {
        return "Venta{"
                + "idVenta=" + idVenta
                + ", fecha=" + fecha
                + ", horaInicio='" + horaInicio + '\''
                + ", horaFin='" + horaFin + '\''
                + ", mesero='" + mesero + '\''
                + ", mesa=" + mesa
                + ", precio=" + precio
                + ", descuento=" + descuento
                + ", precioFinal=" + precioFinal
                + ", cliente='" + cliente + '\''
                + ", documento='" + documento + '\''
                + ", tipo='" + tipo + '\''
                + ", detalles=" + detalles
                + '}';
    }

    public String register(String username, String mesa, String hora) throws ClassNotFoundException {

        Class.forName(DRIVER);
        try (Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            try (PreparedStatement prepared = conex.prepareStatement("Insert into ventas(mesero, mesa, hora_inicio, fecha, activo) values(?,?,?,CURRENT_DATE ,1)")) {
                prepared.setString(1, username);
                prepared.setString(2, mesa);
                prepared.setString(3, hora);
                prepared.executeUpdate();
            }

            try (PreparedStatement prepared = conex.prepareStatement("SELECT id_venta FROM ventas WHERE activo = 1 and mesa = ?")) {
                prepared.setString(1, mesa);
                ResultSet rs = prepared.executeQuery();
                while (rs.next()) {
                    Integer idVenta = rs.getInt("id_venta");

                    Venta nuevaVenta = new Venta();
                    nuevaVenta.setIdVenta(idVenta);
                    return GSON.toJson(nuevaVenta);            //convertimos el objeto usuario a Gson
                }
            }

            //convertimos el objeto usuario a Gson
        } catch (Exception ex) {
            System.out.println(ex.getMessage());    // pasa el parametro al servlet 
        }
        return GSON.toJson("Error");
    }

    public String validarMesa(String mesa) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try (Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            Venta nuevaVenta = new Venta();
            try (PreparedStatement prepared = conex.prepareStatement("SELECT mesa, mesero, hora_inicio, precio, id_venta, fecha FROM ventas WHERE activo = 1 and mesa = ?")) {
                prepared.setString(1, mesa);                                 //almacena
                ResultSet rs = prepared.executeQuery();
                if (rs.next()) {
                    nuevaVenta.setMesero(rs.getString("mesero"));
                    nuevaVenta.setHoraInicio(rs.getString("hora_inicio"));
                    nuevaVenta.setPrecio(rs.getDouble("precio"));
                    nuevaVenta.setIdVenta(rs.getInt("id_venta"));
                    nuevaVenta.setMesa(rs.getString("mesa"));
                    nuevaVenta.setFecha(rs.getString("fecha"));
                }
            }
            
            try (PreparedStatement prepared = conex.prepareStatement("SELECT * FROM detalle_venta WHERE id_venta = ?")) {
                prepared.setInt(1, nuevaVenta.getIdVenta());                    
                ResultSet rs = prepared.executeQuery();
                if (rs.next()) {
                    DetalleVenta nuevoDetalle = new DetalleVenta();
                    double precioD = rs.getDouble("precio");
                    Integer idVentaD = rs.getInt("id_venta");
                    Integer idDetalle = rs.getInt("id_detalle");
                    String consumo = rs.getString("consumo");

                    nuevoDetalle.setIdDetalle(idDetalle);
                    nuevoDetalle.setIdVentaFk(idVentaD);
                    nuevoDetalle.setPrecio(precioD);
                    nuevoDetalle.setConsumo(consumo);
//                
                    nuevaVenta.agregarDetalle(nuevoDetalle);
                    return GSON.toJson(nuevaVenta);
                }                
            }
            return GSON.toJson("Limpio");
//                return gson.toJson("HolA");            //convertimos el objeto usuario a Gson
        } catch (Exception ex) {
            System.out.println(ex.getMessage());    // pasa el parametro al servlet 
        }
        return GSON.toJson("Error");
    }

    public Venta obtenerVenta(int idVentaTMP) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try (Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            int idVenta = 0;
            try (PreparedStatement prepared = conex.prepareStatement("SELECT DISTINCT * FROM ventas JOIN usuarios on mesero = username WHERE id_venta = ?")) {
                prepared.setInt(1, idVentaTMP);
                ResultSet rs = prepared.executeQuery();
                if (rs.next()) {
                    
                    String mesero = rs.getString("nombre");
                    String mesaR = rs.getString("mesa");
                    String horaInicio = rs.getString("hora_inicio");
                    String horaFin = rs.getString("hora_fin");
                    double precio = rs.getDouble("precio");
                    idVenta = rs.getInt("id_venta");
                    String fecha = rs.getString("fecha");
                    double descuento = rs.getDouble("descuento");
                    double precioFinal = rs.getDouble("precio_final");
                    String cliente = rs.getString("cliente");
                    String documento = rs.getString("documento");
                    String tipoComprobante = rs.getString("tipo_comprobante");
                    
                    this.setMesero(mesero);
                    this.setMesa(mesaR);
                    this.setHoraInicio(horaInicio);
                    this.setHoraFin(horaFin);
                    this.setPrecio(precio);
                    this.setIdVenta(idVenta);
                    this.setFecha(fecha);
                    this.setDescuento(descuento);
                    this.setPrecioFinal(precioFinal);
                    this.setCliente(cliente);
                    this.setDocumento(documento);
                    this.setTipo(tipoComprobante);
                }
            }
            
            try (PreparedStatement prepared = conex.prepareStatement("SELECT id_detalle, id_venta, consumo, precio FROM detalle_venta WHERE id_venta = ?")) {
                prepared.setInt(1, idVentaTMP);
                ResultSet rs = prepared.executeQuery();
                while (rs.next()) {
                    DetalleVenta nuevoDetalle = new DetalleVenta();
                    double precioD = rs.getDouble("precio");
                    Integer idVentaD = rs.getInt("id_venta");
                    Integer idDetalle = rs.getInt("id_detalle");
                    String consumo = rs.getString("consumo");

                    nuevoDetalle.setIdDetalle(idDetalle);
                    nuevoDetalle.setIdVentaFk(idVentaD);
                    nuevoDetalle.setPrecio(precioD);
                    nuevoDetalle.setConsumo(consumo);

                    this.agregarDetalle(nuevoDetalle);
                }
            }
        } catch (SQLException ex) {
            this.message(GSON.toJson(ex.getMessage()));
        }
        return this;  
    }

    public String finalizarVenta(int idVenta, String fecha, String horaInicio, String horaFin, int mesero, int mesa, double precio, double descuento, double precioFinal, String cliente, String documento, String tipoComprobante) {
        try (Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            try (PreparedStatement prepared = conex.prepareStatement("UPDATE ventas SET fecha = ?, hora_inicio =  ?, hora_fin = ?, mesero = ?, mesa = ?, precio = ?, descuento = ?, precio_final = ?, cliente = ?, documento = ?, tipo_comprobante = ?, activo = 0 WHERE id_venta = ?")) {
                prepared.setString(1, fecha);
                prepared.setString(2, horaInicio);
                prepared.setString(3, horaFin);
                prepared.setInt(4, mesero);
                prepared.setInt(5, mesa);
                prepared.setDouble(6, precio);
                prepared.setDouble(7, descuento);
                prepared.setDouble(8, precioFinal);
                prepared.setString(9, cliente);
                prepared.setString(10, documento);
                prepared.setString(11, tipoComprobante);
                prepared.setInt(12, idVenta);
                prepared.executeUpdate();
            }
            return GSON.toJson("Exito");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());    // pasa el parametro al servlet 
        } 
        return GSON.toJson("Error");            //convertimos el objeto usuario a Gson
    }

}
