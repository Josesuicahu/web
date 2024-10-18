/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miprimerjsp.entidades;

/**
 *
 * @author Jesus
 */
public class Inventario {
    
    private int id;
    private String insumo;
    private int stock;
    private int stockMinimo;
    
    public Inventario() {
        //
    }
    
    public Inventario(int id, String insumo, int stock, int stockMinimo) {
        this.id = id;
        this.insumo = insumo;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }   
    

        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the insumo
     */
    public String getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getStockMinimo() {
        return stockMinimo;
    }

    /**
     * @param stockMinimo the stockMinimo to set
     */
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}
