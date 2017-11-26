package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.osmany.cajabar.MainActivity.PEDIDO_NUEVO;

public class ProductosActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String CARGA_DATOS_CONFIGURACION = "./ProdcuctosActivity";
    Propiedades propiedades;
    Stock miStock = new Stock();
    Stock listaPedido;
    List<Productos> pedidoNuevo = new ArrayList<>();
    TableLayout miTable;
    Iterator<Productos> iterator = miStock.getList().iterator();
    TableRow filaButton;
    TableRow filaPrecio;
    ImageButton imageButton;
    TextView textPrecio;
    String cadenatMoneda;
    TextView cantidad_productos;
    TextView precio_producto;
    TextView moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_productos);
        miTable = findViewById(R.id.table_layout);
        propiedades = (Propiedades) getIntent().getSerializableExtra(CARGA_DATOS_CONFIGURACION);
        cadenatMoneda = (propiedades.getMoneda());
        crearLayoutProductos();
        cantidad_productos = findViewById(R.id.tv_cantidad_productos);
        precio_producto = findViewById(R.id.tv_precio_producto);
        moneda = findViewById(R.id.tv_moneda);

    }


    public void crearLayoutProductos() {
        int contadorFila = 0;
        while (iterator.hasNext()) {

            filaButton = new TableRow(this);
            filaPrecio = new TableRow(this);
            filaPrecio.setGravity(Gravity.CENTER);
            filaButton.setGravity(Gravity.CENTER);
            while (contadorFila != 3) {
                Productos pr = iterator.next();

                imageButton = new ImageButton(this);
                imageButton.setImageResource(pr.getFoto());
                imageButton.setClickable(true);
                imageButton.setId(pr.getId());
                imageButton.setOnClickListener(this);
                filaButton.addView(imageButton);

                textPrecio = new TextView(this);
                textPrecio.setGravity(Gravity.CENTER);
                textPrecio.setText(Double.toString(pr.getPrecio()) + cadenatMoneda);
                filaPrecio.addView(textPrecio);

                contadorFila++;


            }
            miTable.addView(filaButton);
            miTable.addView(filaPrecio);


            contadorFila = 0;

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case 1:
                setTitle(miStock.getList().get(0).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(0).getPrecio()));
                break;
            case 2:
                setTitle(miStock.getList().get(1).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(1).getPrecio()));
                break;
            case 3:
                setTitle(miStock.getList().get(2).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(2).getPrecio()));
                break;
            case 4:
                setTitle(miStock.getList().get(3).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(3).getPrecio()));
                break;
            case 5:
                setTitle(miStock.getList().get(4).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(4).getPrecio()));
                break;
            case 6:
                setTitle(miStock.getList().get(5).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(5).getPrecio()));
                break;
            case 7:
                setTitle(miStock.getList().get(6).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(6).getPrecio()));
                break;
            case 8:
                setTitle(miStock.getList().get(7).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(7).getPrecio()));
                break;
            case 9:
                setTitle(miStock.getList().get(8).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(8).getPrecio()));
                break;
            case 10:
                setTitle(miStock.getList().get(9).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(9).getPrecio()));
                break;
            case 11:
                setTitle(miStock.getList().get(10).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(10).getPrecio()));
                break;
            case 12:
                setTitle(miStock.getList().get(11).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(11).getPrecio()));
                break;
            case 13:
                setTitle(miStock.getList().get(12).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(12).getPrecio()));
                break;
            case 14:
                setTitle(miStock.getList().get(13).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(13).getPrecio()));
                break;
            case 15:
                setTitle(miStock.getList().get(14).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(14).getPrecio()));
                break;
            case 16:
                setTitle(miStock.getList().get(15).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(15).getPrecio()));
                break;
            case 17:
                setTitle(miStock.getList().get(16).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(16).getPrecio()));
                break;
            case 18:
                setTitle(miStock.getList().get(17).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(17).getPrecio()));
                break;
            case 19:
                setTitle(miStock.getList().get(18).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(18).getPrecio()));
                break;
            case 20:
                setTitle(miStock.getList().get(19).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(19).getPrecio()));
                break;
            case 21:
                setTitle(miStock.getList().get(20).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(20).getPrecio()));
                break;
        }

    }

    public void eventoAñadir(View view) {

        String nom = getTitle().toString();
        int cant = Integer.parseInt(cantidad_productos.getText().toString());
        Iterator<Productos> iterator = miStock.getList().iterator();
        while (iterator.hasNext()) {
            Productos producto = iterator.next();
            if (producto.getName().equals(nom)) {
                for (int i = 1; i <= cant; i++) {
                    pedidoNuevo.add(producto);
                }
            }
        }
        listaPedido.setList(pedidoNuevo);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(PEDIDO_NUEVO, listaPedido);
        startActivity(intent);
        this.finish();

    }
}
