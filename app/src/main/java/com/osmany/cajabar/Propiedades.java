package com.osmany.cajabar;

import java.io.Serializable;

/**
 * Created by Osmany on 22/11/2017.
 */

public class Propiedades implements Serializable {
    String moneda;
    boolean iva;
    boolean mayor18;


    public Propiedades() {
        this.moneda = "€";
        this.iva = false;
        this.mayor18 = true;
    }



    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public boolean isMayor18() {
        return mayor18;
    }

    public void setMayor18(boolean mayor18) {
        this.mayor18 = mayor18;
    }

}
