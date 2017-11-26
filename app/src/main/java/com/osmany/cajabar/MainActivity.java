package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Iterator;

import static com.osmany.cajabar.ProductosActivity.CARGA_DATOS_CONFIGURACION;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PEDIDO_NUEVO = "pedidoNuevo";
    Propiedades propiedades = new Propiedades();
    Button añadir;
    TextView pedido;
    Stock stockNuevoProducto;
    ScrollView miScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadir=findViewById(R.id.btn_añadir_main_activity);
        añadir.setOnClickListener(this);
        stockNuevoProducto = (Stock) getIntent().getSerializableExtra(PEDIDO_NUEVO);
        miScroll = findViewById(R.id.scroll_avtivity_main);

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent config = new Intent(getApplicationContext(),ConfiguracionActivity.class);
        startActivity(config);
        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btn_añadir_main_activity:
                Intent inte = new Intent(this, ProductosActivity.class);
                inte.putExtra(CARGA_DATOS_CONFIGURACION, propiedades);
                startActivity(inte);
                break;
        }
    }

    public void creaLayouts() {
        Iterator<Productos> iterator = stockNuevoProducto.getList().iterator();
        while (iterator.hasNext()) {
            Productos producto = iterator.next();
            LinearLayout linearLayout = new LinearLayout(this);

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(producto.getFoto());

            TextView tvNombre = new TextView(this);
            tvNombre.setText(producto.getName());

            TextView tvPrecio = new TextView(this);
            tvPrecio.setText(Double.toString(producto.getPrecio()) + propiedades.getMoneda());


            TextView tvCantidad = new TextView(this);
            tvCantidad.setText("1");

            TextView tvTotal = new TextView(this);

            double total = producto.getPrecio() * Integer.parseInt(tvCantidad.getText().toString());

            tvTotal.setText(Double.toString(total));


            linearLayout.addView(imageView);
            linearLayout.addView(tvNombre);
            linearLayout.addView(tvPrecio);
            linearLayout.addView(tvCantidad);
            linearLayout.addView(tvTotal);


        }
    }
}
