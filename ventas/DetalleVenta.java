/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 *
 * @author Jorge
 */
public class DetalleVenta {
    private int idDetalle;
    private int idVentaFk;
    private String consumo;
    private double precio;

    public DetalleVenta() {
        
    }
    
    // Constructor
    public DetalleVenta(int idDetalle, int idVentaFk, String consumo, double precio) {
        this.idDetalle = idDetalle;
        this.idVentaFk = idVentaFk;
        this.consumo = consumo;
        this.precio = precio;
    }

    // Métodos getter y setter para acceder a los campos privados

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVentaFk() {
        return idVentaFk;
    }

    public void setIdVentaFk(int idVentaFk) {
        this.idVentaFk = idVentaFk;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString para representar la información de la clase como cadena
    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle=" + idDetalle +
                ", idVentaFk=" + idVentaFk +
                ", consumo='" + consumo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
