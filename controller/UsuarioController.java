package controller;

import beans.Usuario;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dafne
 */
public class UsuarioController extends DBConnection implements IUsuarioController {
    
    public UsuarioController() {
        super();
    }
    
    

    //implementacion de metodos (login)
    
    @Override
    public String login(int username, String contrasena) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection conex = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){    
            PreparedStatement prepared = conex.prepareStatement("Select * from usuarios where username = ? and contrasena = ?");
            prepared.setInt(1, username);
            prepared.setString(2, contrasena);
            ResultSet result = prepared.executeQuery(); 
             
            if(result.next()){
                String nombre= result.getString("nombre");
                String apellidos= result.getString("apellidos");
                String email= result.getString("email");
                String cargo= result.getString("cargo");
                
                //creamos objeto usuario
                Usuario usuario = new Usuario(username,contrasena,nombre,apellidos,email,cargo);
                return GSON.toJson(usuario);            //convertimos el objeto usuario a Gson
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage()); // pasa el parametro al servlet 
        }
        
        return "false";
    }

    //implementacion de metodos (register)
    
    @Override
    
    public String register(int username, String contrasena, String nombre, String apellidos, String email, String cargo) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            PreparedStatement prepared = con.prepareStatement("INSERT INTO usuarios(username, contrasena, nombre, apellidos, email, cargo) VALUES (?,?,?,?,?,?)");
            prepared.setInt(1, username);
            prepared.setString(2, contrasena);
            prepared.setString(3, nombre);
            prepared.setString(4, apellidos);
            prepared.setString(5, email);
            prepared.setString(6, cargo);
            prepared.executeUpdate();
            
            //creamos objeto usuario
            Usuario usuario = new Usuario(username,contrasena,nombre,apellidos,email,cargo);

            return GSON.toJson(usuario); 
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
            return "false";
    }

    //implementacion de metodos (pedir)
    @Override
    public String pedir(int username) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            PreparedStatement prepared = con.prepareStatement("Select * from usuarios where username = ?");
            prepared.setInt(1, username);
            ResultSet result = prepared.executeQuery();
            
            if (result.next()) {
                String contrasena = result.getString("contrasena");
                String nombre = result.getString("nombre");
                String apellidos = result.getString("apellidos");
                String email = result.getString("email");
                String cargo = result.getString("cargo");
   
                Usuario usuario = new Usuario(username,contrasena,nombre,apellidos,email,cargo);

                return GSON.toJson(usuario);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());        // pasa el parametro al servlet 
        }
        return "false";
    }
}
