package com.osmany.cajabar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osmany on 23/11/2017.
 */

public class Stock implements Serializable {

    List<Productos> list = new ArrayList<>();
    private String[] nombres = {"apletizer", "arrugadas", "calamares", "tropical", "clipper", "coca-cola",
            "ensalada", "flan", "helados", "burger", "nuggets", "nestea", "papas frita",
            "perritos calientes", "pizza", "redbull", "sandwitch", "tarta de chocolate", "tiramisu", "vino blanco", "vino tinto"};
    private int[] id = {1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21};
    private double[] precios = {2.5, 3.5, 5, 1.5, 1, 1, 3, 4.5, 1.5, 6.5, 5.5, 1, 2, 1.5, 6, 0, 1.8, 2, 3.5, 3.5, 4, 4.5};
    private int[] fotos = {R.mipmap.ic_apletizer, R.mipmap.ic_arrugadas, R.mipmap.ic_calamares, R.mipmap.ic_cerveza_tropical,
            R.mipmap.ic_cliper, R.mipmap.ic_cocacola, R.mipmap.ic_ensalada, R.mipmap.ic_flan, R.mipmap.ic_helado,
            R.mipmap.ic_burguer, R.mipmap.ic_nugget, R.mipmap.ic_nestea, R.mipmap.ic_papas,
            R.mipmap.ic_hotdog, R.mipmap.ic_pizza, R.mipmap.ic_redbull, R.mipmap.ic_sandwich,
            R.mipmap.ic_tarta, R.mipmap.ic_tiramisu, R.mipmap.ic_vino_blanco, R.mipmap.ic_vino_tinto};
    private boolean[] mayores = {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true};

    Stock(){
        for (int i = 0; i < id.length; i++) {
            Productos p = new Productos(nombres[i], id[i], precios[i], fotos[i], mayores[i]);
            list.add(p);
        }
    }

    public List<Productos> getList() {
        return list;
    }

    public void setList(List<Productos> list) {
        this.list = list;
    }
}
