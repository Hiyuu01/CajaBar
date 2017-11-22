package com.osmany.cajabar;

/**
 * Created by Osmany on 22/11/2017.
 */

public class Propiedades {
    String moneda;
    boolean iva;
    boolean mayor18;

    public Propiedades(String moneda,boolean iva, boolean mayor18){
        this.iva=iva;
        this.moneda=moneda;
        this.mayor18=mayor18;
    }

}
