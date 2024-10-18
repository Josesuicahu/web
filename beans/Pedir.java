
package beans;

import java.sql.Date;

public class Pedir {
    
    private int id;
    private String nombre;
    private boolean novedad;
    private String categoria;
    private String descripcion;
    private int precio;
    private Date fechaPedido;

    public Pedir(int id, String nombre, boolean novedad, String categoria, String descripcion, int precio, Date fechaPedido) {
        this.id = id;
        this.nombre = nombre;
        this.novedad = novedad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPedido = fechaPedido;
    }    

    public int getId() {                                    return id;}
    public void setId(int id) {                             this.id = id;}

    public String getNombre() {                             return nombre;}
    public void setNombre(String nombre) {                  this.nombre = nombre;}

    public boolean isNovedad() {                            return novedad;}
    public void setNovedad(boolean novedad) {               this.novedad = novedad;}

    public String getCategoria() {                          return categoria;}
    public void setCategoria(String categoria) {            this.categoria = categoria;}

    public String getDescripcion() {                        return descripcion;}
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;}

    public int getPrecio() {                                return precio;}
    public void setPrecio(int precio) {                     this.precio = precio;}

    public Date getFechaPedido() {                          return fechaPedido;}
    public void setFechaPedido(Date fechaPedido) {          this.fechaPedido = fechaPedido;}
    

    @Override
    public String toString() {
        return "Pedir{" + "id=" + id + ", nombre=" + nombre + ", novedad=" + novedad + ", categoria=" + categoria + ", descripcion=" + descripcion + ", precio=" + precio + ", fechaPedido=" + fechaPedido + '}';
    }

    
}
