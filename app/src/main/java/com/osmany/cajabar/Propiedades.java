package com.osmany.cajabar;

/**
 * Created by Osmany on 22/11/2017.
 */

public class Propiedades {
    String moneda;
    boolean iva;
    boolean mayor18;

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

    public Propiedades(String moneda, boolean iva, boolean mayor18){
        this.iva=iva;

        this.moneda=moneda;
        this.mayor18=mayor18;
    }

}
