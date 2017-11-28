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
import android.widget.Toast;

import java.util.Iterator;

import static com.osmany.cajabar.ConfiguracionActivity.DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY;
import static com.osmany.cajabar.ProductosActivity.CARGA_DATOS_CONFIGURACION;
import static com.osmany.cajabar.ProductosActivity.LISTA_PRODUCTOS_NUEVOS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PEDIDO_NUEVO = "pedidoNuevo";
    public static final int REQUEST_CODE_PRODUCTOS = 10;
    public static final int REQUEST_CODE_CONFIGURACION = 5;
    Button añadir, cancelar, enviar;
    TextView pedido, tv_Total_Precio, tv_Total_Cantidad, tv_Impuesto_Nombre, tv_Impuesto_Valor, tv_Impuesto_Total;
    Stock stockNuevoProducto = new Stock();
    Stock listaProductos = new Stock();
    LinearLayout miLineal;
    FrameLayout linea;
    LinearLayout impuestos, totales;
    double precioTotal = 0;
    private Propiedades propiedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listaProductos.getList().clear();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadir=findViewById(R.id.btn_añadir_main_activity);
        añadir.setOnClickListener(this);
        miLineal = findViewById(R.id.linea_del_Scroll);
        propiedades = new Propiedades();
        linea = findViewById(R.id.separador_main_activity);
        impuestos = findViewById(R.id.layout_impuestos);
        totales = findViewById(R.id.layout_totales_main_activity);
        tv_Total_Precio = findViewById(R.id.tv_total_main_activity);
        tv_Total_Cantidad = findViewById(R.id.tv_cantidad_total_main_activity);
        cancelar = findViewById(R.id.btn_cancelar_main_activity);
        cancelar.setOnClickListener(this);
        enviar = findViewById(R.id.Boton_Enviar);
        enviar.setOnClickListener(this);
        tv_Impuesto_Nombre = findViewById(R.id.tv_impuesto_main_activity);
        tv_Impuesto_Valor = findViewById(R.id.tv_porcentaje_main_activity);
        tv_Impuesto_Total = findViewById(R.id.tv_total_impuestos_main_activity);
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
            case R.id.btn_cancelar_main_activity:
                listaProductos.getList().clear();
                miLineal.removeAllViews();
                linea.setVisibility(View.INVISIBLE);
                impuestos.setVisibility(View.INVISIBLE);
                totales.setVisibility(View.INVISIBLE);
                break;
            case R.id.Boton_Enviar:
                if (miLineal != null) {
                    listaProductos.getList().clear();
                    miLineal.removeAllViews();
                    linea.setVisibility(View.INVISIBLE);
                    impuestos.setVisibility(View.INVISIBLE);
                    totales.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "Pedido enviado", Toast.LENGTH_LONG).show();

                    break;
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PRODUCTOS && resultCode == RESULT_OK) {

            stockNuevoProducto = (Stock) data.getSerializableExtra(PEDIDO_NUEVO);
            if (!stockNuevoProducto.getList().isEmpty()) {
                listaProductos.getList().add(stockNuevoProducto.getList().get(0));

                miLineal.removeAllViews();
                creaLayouts();
                calcularTotales();
            }
        }
        if (requestCode == REQUEST_CODE_CONFIGURACION && resultCode == RESULT_OK) {
            propiedades = (Propiedades) data.getSerializableExtra(DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY);
            miLineal.removeAllViews();
            creaLayouts();
            calcularTotales();
        }
    }

    public void creaLayouts() {
        if (listaProductos.getList() != null) {
            precioTotal = 0;
            int cantidadDeProductos = 0;

            Iterator<Productos> iterator = listaProductos.getList().iterator();


            while (iterator.hasNext()) {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setGravity(Gravity.CENTER_VERTICAL);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 200);
                linearLayout.setLayoutParams(params);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(100, 0, 0, 0);
                Productos producto = iterator.next();

                cantidadDeProductos = cantidadDeProductos + producto.getCantidad();

                ImageView imageView = new ImageView(this);
                imageView.setImageResource(producto.getFoto());

                TextView tvNombre = new TextView(this);
                tvNombre.setText(producto.getName());
                tvNombre.setLayoutParams(layoutParams);


                TextView tvPrecio = new TextView(this);

                tvPrecio.setLayoutParams(layoutParams);
                tvPrecio.setText(Double.toString(producto.getPrecio()) + propiedades.getMoneda());


                TextView tvCantidad = new TextView(this);
                tvCantidad.setText(Integer.toString(producto.getCantidad()));
                tvCantidad.setLayoutParams(layoutParams);

                TextView tvTotal = new TextView(this);
                tvTotal.setLayoutParams(layoutParams);
                double total = producto.getPrecio() * Integer.parseInt(tvCantidad.getText().toString());
                precioTotal = precioTotal + total;
                tvTotal.setText(Double.toString(total) + propiedades.getMoneda());


                linearLayout.addView(imageView);
                linearLayout.addView(tvNombre);
                linearLayout.addView(tvPrecio);
                linearLayout.addView(tvCantidad);
                linearLayout.addView(tvTotal);
                miLineal.addView(linearLayout);


                tv_Total_Cantidad.setText(Integer.toString(cantidadDeProductos));

            }


        }

    }

    public void calcularTotales() {
        double imp;
        if (propiedades.isIva()) {
            tv_Impuesto_Nombre.setText("IVA");
            tv_Impuesto_Valor.setText("21%");
            imp = precioTotal * 0.21;
            tv_Impuesto_Total.setText(Double.toString(imp) + propiedades.getMoneda());
        } else {
            tv_Impuesto_Nombre.setText("IGIC");
            tv_Impuesto_Valor.setText("6%");
            imp = precioTotal * 0.06;
            tv_Impuesto_Total.setText(Double.toString(imp) + propiedades.getMoneda());
        }
        tv_Total_Precio.setText(Double.toString((precioTotal + imp)) + propiedades.getMoneda());
        linea.setVisibility(View.VISIBLE);
        impuestos.setVisibility(View.VISIBLE);
        totales.setVisibility(View.VISIBLE);

    }
}
