package com.osmany.cajabar;

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
    TableRow filaButton;
    TableRow filaPrecio;
    ImageButton imageButton;
    TextView textPrecio;
    String cadenatMoneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       //propiedades = (Propiedades) getIntent().getSerializableExtra("CARGA_DATOS_CONFIGURACION");
        setContentView(R.layout.activity_productos);
        miTable = findViewById(R.id.table_layout);

       //cadenatMoneda = (propiedades.getMoneda());
       crearLayoutProductos();
    }


    public void crearLayoutProductos() {
        int contadorFila = 0;
        while (iterator.hasNext()) {
            Productos pr = iterator.next();
            filaButton = new TableRow(this);
            while (contadorFila != 3) {


                //filaPrecio = new TableRow(this);
                imageButton = new ImageButton(this);

                imageButton.setImageResource(pr.getFoto());
                filaButton.addView(imageButton);
                contadorFila++;


            }
            miTable.addView(filaButton);
            contadorFila = 0;

        }
    }
}
