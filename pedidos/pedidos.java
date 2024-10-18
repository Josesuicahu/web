/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos;

/**
 *
 * @author Cristian Panta
 */
public class pedidos {
    private int id;
    private String nombre;
    private double precio;
    private String fecha;
    public pedidos(){
    }
    public pedidos(int id, String nombre, double precio, String fecha){
        this.id= id;
        this.nombre= nombre;
        this.precio=precio;
        this.fecha=fecha;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
 
}
