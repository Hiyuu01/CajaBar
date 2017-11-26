package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;

import static com.osmany.cajabar.ConfiguracionActivity.DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY;
import static com.osmany.cajabar.ConfiguracionActivity.DATOS_DE_LA_ACTIVIDAD_PROPIEDADES_A_PMAIN_ACTIVITY;
import static com.osmany.cajabar.ProductosActivity.CARGA_DATOS_CONFIGURACION;
import static com.osmany.cajabar.ProductosActivity.LISTA_PRODUCTOS_NUEVOS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PEDIDO_NUEVO = "pedidoNuevo";
    public static final int REQUEST_CODE_PRODUCTOS = 10;
    public static final int REQUEST_CODE_CONFIGURACION = 5;
    Button añadir;
    TextView pedido;
    Stock stockNuevoProducto = new Stock();
    Stock listaProductos = new Stock();
    LinearLayout miLineal;
    FrameLayout linea;
    LinearLayout impuestos, totales;
    private Propiedades propiedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadir=findViewById(R.id.btn_añadir_main_activity);
        añadir.setOnClickListener(this);
        listaProductos.getList().clear();
        miLineal = findViewById(R.id.linea_del_Scroll);
        propiedades = new Propiedades();
        linea = findViewById(R.id.separador_main_activity);
        impuestos = findViewById(R.id.layout_impuestos);
        totales = findViewById(R.id.layout_totales_main_activity);

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent config = new Intent(getApplicationContext(),ConfiguracionActivity.class);
        config.putExtra(DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY, propiedades);
        startActivityForResult(config, REQUEST_CODE_CONFIGURACION);
        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btn_añadir_main_activity:
                Intent inte = new Intent(this, ProductosActivity.class);
                inte.putExtra(LISTA_PRODUCTOS_NUEVOS, stockNuevoProducto);
                inte.putExtra(CARGA_DATOS_CONFIGURACION, propiedades);
                startActivityForResult(inte, REQUEST_CODE_PRODUCTOS);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PRODUCTOS && resultCode == RESULT_OK) {
            stockNuevoProducto = (Stock) data.getSerializableExtra(PEDIDO_NUEVO);
            listaProductos.getList().add(stockNuevoProducto.getList().get(0));
            creaLayouts();
        }
        if (requestCode == REQUEST_CODE_CONFIGURACION && requestCode == RESULT_OK) {
            propiedades = (Propiedades) data.getSerializableExtra(DATOS_DE_LA_ACTIVIDAD_PROPIEDADES_A_PMAIN_ACTIVITY);
            creaLayouts();
        }
    }

    public void creaLayouts() {
        Iterator<Productos> iterator = stockNuevoProducto.getList().iterator();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 200);

        linearLayout.setLayoutParams(params);

        while (iterator.hasNext()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(100, 0, 0, 0);
            Productos producto = iterator.next();


            ImageView imageView = new ImageView(this);
            imageView.setImageResource(producto.getFoto());

            TextView tvNombre = new TextView(this);
            tvNombre.setText(producto.getName());
            tvNombre.setLayoutParams(layoutParams);


            TextView tvPrecio = new TextView(this);

            tvPrecio.setLayoutParams(layoutParams);
            tvPrecio.setText(Double.toString(producto.getPrecio()) + propiedades.getMoneda());



            TextView tvCantidad = new TextView(this);
            tvCantidad.setText("1");
            tvCantidad.setLayoutParams(layoutParams);

            TextView tvTotal = new TextView(this);
            tvTotal.setLayoutParams(layoutParams);
            double total = producto.getPrecio() * Integer.parseInt(tvCantidad.getText().toString());

            tvTotal.setText(Double.toString(total));


            linearLayout.addView(imageView);
            linearLayout.addView(tvNombre);
            linearLayout.addView(tvPrecio);
            linearLayout.addView(tvCantidad);
            linearLayout.addView(tvTotal);
            miLineal.addView(linearLayout);

        }
        linea.setVisibility(View.VISIBLE);
        impuestos.setVisibility(View.VISIBLE);
        totales.setVisibility(View.VISIBLE);


    }
}
