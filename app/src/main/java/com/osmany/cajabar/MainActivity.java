package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;

import static com.osmany.cajabar.ProductosActivity.CARGA_DATOS_CONFIGURACION;
import static com.osmany.cajabar.ProductosActivity.LISTA_PRODUCTOS_NUEVOS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PEDIDO_NUEVO = "pedidoNuevo";
    public static final int REQUEST_CODE = 10;
    Propiedades propiedades = new Propiedades();
    Button añadir;
    TextView pedido;
    Stock stockNuevoProducto = new Stock();
    LinearLayout miLineal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadir=findViewById(R.id.btn_añadir_main_activity);
        añadir.setOnClickListener(this);

        miLineal = findViewById(R.id.linea_del_Scroll);



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
                inte.putExtra(LISTA_PRODUCTOS_NUEVOS, stockNuevoProducto);
                inte.putExtra(CARGA_DATOS_CONFIGURACION, propiedades);
                startActivityForResult(inte, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            stockNuevoProducto = (Stock) data.getSerializableExtra(PEDIDO_NUEVO);
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


    }
}
