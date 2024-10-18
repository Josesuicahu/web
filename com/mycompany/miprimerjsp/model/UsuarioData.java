package com.mycompany.miprimerjsp.model;

import com.mycompany.miprimerjsp.entidades.Usuario;
import java.util.List;

/**
 *
 * @author User
 */
public interface UsuarioData {
    
    List<Usuario> obtenerLista()  throws ClassNotFoundException;
    Usuario obtener(int username)  throws ClassNotFoundException;
    void agregar(Usuario usuario)  throws ClassNotFoundException;
    int modificar(Usuario usuario)  throws ClassNotFoundException;
    boolean eliminar(int username)  throws ClassNotFoundException;
}
