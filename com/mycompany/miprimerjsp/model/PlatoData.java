package com.mycompany.miprimerjsp.model;

import com.mycompany.miprimerjsp.entidades.Plato;
import java.util.List;

/**
 *
 * @author User
 */
public interface PlatoData {
    
    List<Plato> obtenerLista() throws ClassNotFoundException;
    Plato obtener(int id) throws ClassNotFoundException;
    void agregar(Plato plato) throws ClassNotFoundException;
    int modificar(Plato plato) throws ClassNotFoundException;
    boolean eliminar(int id) throws ClassNotFoundException;
}
