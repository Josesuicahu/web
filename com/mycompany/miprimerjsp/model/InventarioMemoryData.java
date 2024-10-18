/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.miprimerjsp.model;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.miprimerjsp.entidades.Inventario;

public class InventarioMemoryData {
    
    private static List<Inventario> lista = new ArrayList<Inventario>();
    
    public InventarioMemoryData() {
        lista.add(new Inventario(1, "Gaseosa Inka-Cola", 55, 48));
        lista.add(new Inventario(2, "Gaseosa Coca-Cola", 65, 48));
        lista.add(new Inventario(3, "Agua sin gas", 35, 50));
        lista.add(new Inventario(4, "Agua con gas", 51, 50));
        lista.add(new Inventario(5, "Trufa", 25, 25));
        lista.add(new Inventario(6, "Pie de manzana", 13, 10));
        lista.add(new Inventario(7, "Pie de limon", 15, 15));
        lista.add(new Inventario(8, "Cheescake de fresa", 15, 10));
        lista.add(new Inventario(9, "Chesscake de maracuya", 16, 10));
        lista.add(new Inventario(10, "Torta tres leches", 10, 10));
        lista.add(new Inventario(11, "Torta selva negra", 15, 10));
        lista.add(new Inventario(12, "Keke de naranja", 21, 20));
        lista.add(new Inventario(13, "Keke marmoleado", 23, 20));
        lista.add(new Inventario(15, "Keke de zanahoria", 17, 15));
        
    }
    
    public List<Inventario> obtenerLista() {
        return InventarioMemoryData.lista;
    }
    
    public Inventario obtener(int id) {
        for (Inventario in: InventarioMemoryData.lista) {
            if (in.getId() == id) {
                return in;
            }
        }
        return null;
    }
    
    public void agregar(Inventario inventario) {
        lista.add(inventario);
    }
    
    public void modificar(Inventario inventario) {
        for (int i=0; i<InventarioMemoryData.lista.size(); i++) {
            Inventario in = InventarioMemoryData.lista.get(i);
            if (in.getId() == inventario.getId()) {
                InventarioMemoryData.lista.set(i, inventario);
            }
        }
    }
    
    public boolean eliminar(int id) {
        for (Inventario in: InventarioMemoryData.lista) {
            if (in.getId() == id) {
                return InventarioMemoryData.lista.remove(in);
            }
        }
        return false;
    }
    
}
