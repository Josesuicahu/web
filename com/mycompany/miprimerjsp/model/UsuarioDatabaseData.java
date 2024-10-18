package com.mycompany.miprimerjsp.model;

import com.mycompany.miprimerjsp.entidades.Usuario;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDatabaseData extends DBConnection implements UsuarioData {

    @Override
    public List<Usuario> obtenerLista() throws ClassNotFoundException {
        List<Usuario> lista = new ArrayList<>();
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM usuarios");
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsername(result.getInt("username"));
                usuario.setContrasena(result.getString("contrasena"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setApellidos(result.getString("apellidos"));
                usuario.setEmail(result.getString("email"));
                usuario.setCargo(result.getString("cargo"));
                lista.add(usuario);
            }
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return null;
    }

    @Override
    public Usuario obtener(int username) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            Usuario usuario = new Usuario();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE username = ?");
            ps.setInt(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setUsername(rs.getInt("username"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCargo(rs.getString("cargo"));

            }
            return usuario;
        } catch (Exception ex) {
            ex.printStackTrace();            
        }
        return null;
    }

    @Override
    public void agregar(Usuario usuario) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){ 
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios ( username, contrasena, nombre, apellidos, email, cargo) VALUES ( ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, usuario.getUsername());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getCargo());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int modificar(Usuario usuario) throws ClassNotFoundException {
        int filasAfectadass = 0;
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET contrasena = ?, nombre = ?,apellidos = ?, email = ?, cargo = ? where username = ?");
            ps.setString(1, usuario.getContrasena());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getCargo());
            ps.setInt(6, usuario.getUsername());  // Asumiendo que id es el séptimo parámetro
            filasAfectadass = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return filasAfectadass;
    }

    @Override
    public boolean eliminar(int username) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE username = ?");
            ps.setInt(1, username);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return false;
    }
}
