package com.osmany.cajabar;

import java.io.Serializable;

/**
 * Created by Osmany on 23/11/2017.
 */

public class Productos implements Serializable {
    int id;
    String name;
    double precio;
    int foto;
    boolean mayor;

    public Productos(String name, int id, double precio, int foto, boolean mayor) {
        this.id = id;
        this.precio = precio;
        this.name = name;
        this.foto = foto;
        this.mayor = mayor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


}
