package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Iterator;

public class ProductosActivity extends AppCompatActivity {
    public static final String CARGA_DATOS_CONFIGURACION = "./ProdcuctosActivity";
    Propiedades propiedades;
    Stock miStock = new Stock();
    TableLayout miTable;
    Iterator<Productos> iterator = miStock.getList().iterator();
    TableRow tablaImageButton;
    TableRow filaPrecio;
    ImageButton imageButton;
    TextView textPrecio;
    String cadenatMoneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent cargaDatos = getIntent();
        propiedades = (Propiedades) cargaDatos.getSerializableExtra("CARGA_DATOS_CONFIGURACION");
        setContentView(R.layout.activity_productos);
        miTable = findViewById(R.id.table_layout);

        cadenatMoneda = (propiedades.getMoneda());
    }


    public void crearLayoutProductos() {
        tablaImageButton = new TableRow(getApplicationContext());
        filaPrecio = new TableRow(getApplicationContext());
        while (iterator.hasNext()) {
            Productos pr = iterator.next();


            imageButton = new ImageButton(getApplicationContext());
            textPrecio = new TextView(getApplicationContext());
            imageButton.setImageResource(pr.getFoto());
            textPrecio.setText(Double.toString(pr.getPrecio()) + cadenatMoneda);

            tablaImageButton.addView(imageButton);
            filaPrecio.addView(textPrecio);

        }
    }
}
