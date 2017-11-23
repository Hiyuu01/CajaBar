package com.osmany.cajabar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osmany on 23/11/2017.
 */

public class Stock {

    List<Productos> list = new ArrayList<>();

    Stock(){

    }

    public List<Productos> getList() {
        return list;
    }

    public void setList(List<Productos> list) {
        this.list = list;
    }
}
