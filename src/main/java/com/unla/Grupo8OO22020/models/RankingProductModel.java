package com.unla.Grupo8OO22020.models;

public class RankingProductModel {
    private int idProducto;
    private String descripcion;
    private int cantidadVendida;

    public RankingProductModel() {
    	
    }
    
    public RankingProductModel(String descripcion, int cantidadVendida) {
        super();
        this.descripcion = descripcion;
        this.cantidadVendida = cantidadVendida;
    }

    public int getIdProducto() {
        return idProducto;
    }
    protected void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String nombre) {
        this.descripcion = nombre;
    }
    public int getCantidadVendida() {
        return cantidadVendida;
    }
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }


}
