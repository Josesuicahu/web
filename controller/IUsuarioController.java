package controller;

/**
 *
 * @author Dafne
 */
public interface IUsuarioController {
    
    //definir metodos
    
    public String login(int username, String contrasena) throws ClassNotFoundException;
    public String register(int username, String contrasena,String nombre,String apellidos,String email, String cargo) throws ClassNotFoundException;
    public String pedir(int username) throws ClassNotFoundException;
    
    
}
