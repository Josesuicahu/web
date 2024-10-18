/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Panta
 */
public class datapedidos {

    private static final List<pedidos> lista = new ArrayList();

    public List<pedidos> obtenerlista() {
        return lista;

    }

    public pedidos obtener(int id) {
        for (pedidos p : datapedidos.lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void agregar(pedidos pedidos) {
        lista.add(pedidos);
    }
    
    public void agregar(int id, String plato, double precio,String fecha){
        this.agregar(new pedidos(id, plato, precio, fecha));
    }

    public boolean modificar(pedidos pedidos) {
        for (int i = 0; i < datapedidos.lista.size(); i++) {
            pedidos p = datapedidos.lista.get(i);
            if (p.getId() == pedidos.getId()) {
                datapedidos.lista.set(i, pedidos);
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        for (pedidos p : datapedidos.lista) {
            if (p.getId() == id) {
                return datapedidos.lista.remove(p);
            }
        }
        return false;
    }
}
