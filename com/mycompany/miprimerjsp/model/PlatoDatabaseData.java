package com.mycompany.miprimerjsp.model;

import com.mycompany.miprimerjsp.entidades.Plato;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlatoDatabaseData extends DBConnection implements PlatoData {

    @Override
    public List<Plato> obtenerLista() throws ClassNotFoundException {
        List<Plato> lista = new ArrayList<>();
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM platos");
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setId(rs.getInt("id"));
                plato.setNombre(rs.getString("nombre"));
                plato.setCategoria(rs.getString("categoria"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setStock(rs.getInt("stock"));
                plato.setNovedad(rs.getBoolean("novedad"));
                plato.setPrecio(rs.getInt("precio"));
                lista.add(plato);
            }
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Plato obtener(int id) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){  
            Plato plato = new Plato();
            String sql = "SELECT * FROM platos WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                plato.setId(rs.getInt("id"));
                plato.setNombre(rs.getString("nombre"));
                plato.setCategoria(rs.getString("categoria"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setNovedad(rs.getBoolean("novedad"));
                plato.setStock(rs.getInt("stock"));
                plato.setPrecio(rs.getInt("precio"));

            }
            return plato;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void agregar(Plato plato) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){  
            PreparedStatement ps = con.prepareStatement("INSERT INTO platos (id, nombre, categoria, descripcion, stock, novedad, precio) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, plato.getId());
            ps.setString(2, plato.getNombre());
            ps.setString(3, plato.getCategoria());
            ps.setString(4, plato.getDescripcion());
            ps.setInt(5, plato.getStock());
            ps.setBoolean(6, plato.isNovedad());
            ps.setInt(7, plato.getPrecio());
            
            if (plato.isNovedad()) {
                ps.setInt(7, (int) (plato.getPrecio() * 1.3));
            } else {
                ps.setInt(7, plato.getPrecio());
            }
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int modificar(Plato plato) throws ClassNotFoundException {
        int filasAfectadas = 0;

        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement ps = con.prepareStatement("UPDATE platos SET nombre = ?, categoria = ?, descripcion = ?, stock = ?, novedad = ?, precio = ? WHERE id = ?");
            ps.setString(1, plato.getNombre());
            ps.setString(2, plato.getCategoria());
            ps.setString(3, plato.getDescripcion());
            ps.setInt(4, plato.getStock());
            ps.setBoolean(5, plato.isNovedad());
            

            // Multiplicar el precio por 0.3 si es una novedad
            if (plato.isNovedad()) {
                ps.setInt(6, (int) (plato.getPrecio() * 1.3));
            } else {
                ps.setInt(6, plato.getPrecio());
            }

            ps.setInt(7, plato.getId());
            filasAfectadas = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return filasAfectadas;
    }

    @Override
    public boolean eliminar(int id) throws ClassNotFoundException {

        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD)){
            PreparedStatement ps = con.prepareStatement("DELETE FROM platos WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}