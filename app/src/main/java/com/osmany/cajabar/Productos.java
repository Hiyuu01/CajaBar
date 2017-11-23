package com.osmany.cajabar;

/**
 * Created by Osmany on 23/11/2017.
 */

public class Productos {
    String name;
    double precio;
    int foto;
    boolean mayor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public boolean isMayor() {
        return mayor;
    }

    public void setMayor(boolean mayor) {
        this.mayor = mayor;
    }

    public Productos(String name, double precio, int foto, boolean mayor){
        this.name=name;
        this.precio=precio;

        this.foto=foto;
        this.mayor=mayor;

    }


}
