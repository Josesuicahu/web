package controller;

/**
 *
 * @author Dafne
 */
public interface IPlatoController {
    
    //definir metodos
    
    public String listar (boolean ordenar,String orden) throws ClassNotFoundException ;
    public String pedir(int id, String nombrePlato, int precio, int idVenta) throws ClassNotFoundException ;
    public String modificar(int id) throws ClassNotFoundException ;
    public String devolver(int id, String consumo) throws ClassNotFoundException ;
    public String sumarCantidad(int id) throws ClassNotFoundException ;

}
