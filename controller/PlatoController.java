package controller;

import beans.Plato;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlatoController extends DBConnection implements IPlatoController{

    //GSON
    public PlatoController() {
        super();
    }

    @Override
    public String listar(boolean ordenar, String orden) throws ClassNotFoundException {
        
        //se crea una lista para almacenar  los Platos
        List<String> platos = new ArrayList<>();

        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){   
            
            //creamos objetos tipo statement y resulset
            Statement st = conex.createStatement();   //ejecuta
            ResultSet rs = st.executeQuery("Select * from platos"); 

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                boolean novedad = rs.getBoolean("novedad");
                int precio = rs.getInt("precio");

                //creamos objeto Plato
                Plato plato = new Plato(id,nombre,categoria,descripcion,stock,novedad,precio);

                platos.add(GSON.toJson(plato));     //objt Json se agreaga a la lista Platos
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());        // pasa el parametro al servlet 
        }

        return GSON.toJson(platos);             //se decuelve como resultad del metodo
    }

    @Override
    public String pedir(int id, String nombrePlato, int precio, int idVenta ) throws ClassNotFoundException {
        String msg = "";
        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement prepared = conex.prepareStatement("Insert into detalle_venta(consumo, precio, id_venta ) values (?,?,?)");
            prepared.setString(1, nombrePlato);
            prepared.setInt(2, precio);
            prepared.setInt(3, idVenta);
            prepared.executeUpdate();

            return modificar(id);
        }
        catch(Exception ex) {
            msg = ex.toString();
        }
        return msg;
    }

    @Override
    public String modificar(int id) throws ClassNotFoundException {
        String msg = "";
        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement prepared = conex.prepareStatement("Update platos set stock = (stock - 1) where id = ?" );
            prepared.setInt(1, id);
            prepared.executeUpdate();

            return "true";
        }
        catch(Exception ex) {
            msg = ex.toString();
        }

        return msg;
    }

    @Override
    public String devolver(int id, String consumo) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            try(PreparedStatement prepared = conex.prepareStatement("Delete from detalle_venta where id_detalle = ?")){
                prepared.setInt(1, id);
                prepared.executeUpdate();
            }
            
            try(PreparedStatement prepared = conex.prepareStatement("UPDATE platos SET stock = stock + 1 WHERE nombre = ?")){
                prepared.setString(1, consumo);
                prepared.executeUpdate();
            }
            
            return "true";
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return "false";
    }

    @Override
    public String sumarCantidad(int id) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement prepared = conex.prepareStatement("Update platos set stock = stock + 1 where id = ?");
            prepared.setInt(1, id);
            prepared.executeUpdate();
            
            return "true";
        }
        catch(Exception ex) {
                System.out.println(ex.toString());
        }
        return "false";

    }
}