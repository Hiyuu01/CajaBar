package com.osmany.cajabar;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.osmany.cajabar.MainActivity.PEDIDO_NUEVO;

public class ProductosActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String CARGA_DATOS_CONFIGURACION = "./ProdcuctosActivity";
    public static final String LISTA_PRODUCTOS_NUEVOS = "listaProductos";
    Propiedades propiedades;
    Stock miStock = new Stock();
    Stock listaPedido;
    List<Productos> pedidoNuevo = new ArrayList<>();
    TableLayout miTable;
    Iterator<Productos> iterator = miStock.getList().iterator();
    TableRow filaButton;
    TableRow filaPrecio;
    ImageView imageView;
    TextView textPrecio;
    String cadenatMoneda;
    TextView cantidad_productos;
    TextView precio_producto;
    TextView moneda;
    Button añadirProducto, sumarProducto, restarProducto, cancelarProducto;
    double primerPrecio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_productos);
        miTable = findViewById(R.id.table_layout);
        propiedades = (Propiedades) getIntent().getSerializableExtra(CARGA_DATOS_CONFIGURACION);
        listaPedido = (Stock) getIntent().getSerializableExtra(LISTA_PRODUCTOS_NUEVOS);
        listaPedido.getList().clear();
        cadenatMoneda = (propiedades.getMoneda());
        crearLayoutProductos();
        cantidad_productos = findViewById(R.id.tv_cantidad_productos);
        precio_producto = findViewById(R.id.tv_precio_producto);
        moneda = findViewById(R.id.tv_moneda);
        añadirProducto = findViewById(R.id.btn_añadir_productos_activity);
        añadirProducto.setOnClickListener(this);
        sumarProducto = findViewById(R.id.btn_Suma);
        sumarProducto.setOnClickListener(this);
        restarProducto = findViewById(R.id.btn_Resta);
        restarProducto.setOnClickListener(this);
        cancelarProducto = findViewById(R.id.btn_cancelar_productos_activity);
        cancelarProducto.setOnClickListener(this);
    }


    public void crearLayoutProductos() {
        Display ventana = getWindowManager().getDefaultDisplay();
        Point tamaño = new Point();
        ventana.getSize(tamaño);
        int ancho = tamaño.x;
        int tamañoTotal = ancho / 3;

        int contadorFila = 0;
        while (iterator.hasNext()) {

            filaButton = new TableRow(this);
            filaPrecio = new TableRow(this);
            filaPrecio.setGravity(Gravity.CENTER);
            filaButton.setGravity(Gravity.CENTER);
            while (contadorFila != 3) {
                Productos pr = iterator.next();
                TableRow.LayoutParams params = new TableRow.LayoutParams();
                params.width = tamañoTotal;
                params.height = tamañoTotal;

                imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(params);
                imageView.setImageResource(pr.getFoto());
                imageView.setClickable(true);
                imageView.setId(pr.getId());
                imageView.setOnClickListener(this);
                filaButton.addView(imageView);

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
                cantidad_productos.setText("1");
                primerPrecio = miStock.getList().get(0).getPrecio();
                break;
            case 2:
                setTitle(miStock.getList().get(1).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(1).getPrecio()));
                primerPrecio = miStock.getList().get(1).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 3:
                setTitle(miStock.getList().get(2).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(2).getPrecio()));
                primerPrecio = miStock.getList().get(2).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 4:
                setTitle(miStock.getList().get(3).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(3).getPrecio()));
                primerPrecio = miStock.getList().get(3).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 5:
                setTitle(miStock.getList().get(4).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(4).getPrecio()));
                primerPrecio = miStock.getList().get(4).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 6:
                setTitle(miStock.getList().get(5).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(5).getPrecio()));
                primerPrecio = miStock.getList().get(5).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 7:
                setTitle(miStock.getList().get(6).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(6).getPrecio()));
                primerPrecio = miStock.getList().get(6).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 8:
                setTitle(miStock.getList().get(7).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(7).getPrecio()));
                primerPrecio = miStock.getList().get(9).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 9:
                setTitle(miStock.getList().get(8).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(8).getPrecio()));
                primerPrecio = miStock.getList().get(8).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 10:
                setTitle(miStock.getList().get(9).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(9).getPrecio()));
                primerPrecio = miStock.getList().get(9).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 11:
                setTitle(miStock.getList().get(10).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(10).getPrecio()));
                primerPrecio = miStock.getList().get(10).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 12:
                setTitle(miStock.getList().get(11).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(11).getPrecio()));
                primerPrecio = miStock.getList().get(11).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 13:
                setTitle(miStock.getList().get(12).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(12).getPrecio()));
                primerPrecio = miStock.getList().get(12).getPrecio();
                cantidad_productos.setText("1");

                break;
            case 14:
                setTitle(miStock.getList().get(13).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(13).getPrecio()));
                primerPrecio = miStock.getList().get(13).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 15:
                setTitle(miStock.getList().get(14).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(14).getPrecio()));
                primerPrecio = miStock.getList().get(14).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 16:
                setTitle(miStock.getList().get(15).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(15).getPrecio()));
                primerPrecio = miStock.getList().get(15).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 17:
                setTitle(miStock.getList().get(16).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(16).getPrecio()));
                primerPrecio = miStock.getList().get(16).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 18:
                setTitle(miStock.getList().get(17).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(17).getPrecio()));
                primerPrecio = miStock.getList().get(17).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 19:
                setTitle(miStock.getList().get(18).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(18).getPrecio()));
                primerPrecio = miStock.getList().get(18).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 20:
                setTitle(miStock.getList().get(19).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(19).getPrecio()));
                primerPrecio = miStock.getList().get(19).getPrecio();
                cantidad_productos.setText("1");
                break;
            case 21:
                setTitle(miStock.getList().get(20).getName());
                precio_producto.setText(Double.toString(miStock.getList().get(20).getPrecio()));
                primerPrecio = miStock.getList().get(20).getPrecio();
                cantidad_productos.setText("1");
                break;
            case R.id.btn_añadir_productos_activity:
                String nom = getTitle().toString();
                int cant = Integer.parseInt(cantidad_productos.getText().toString());

                Iterator<Productos> iterator = miStock.getList().iterator();

                while (iterator.hasNext()) {
                    Productos producto = iterator.next();
                    if (producto.getName().equals(nom)) {

                        pedidoNuevo.add(producto);

                    }

                }
                listaPedido.setList(pedidoNuevo);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(PEDIDO_NUEVO, listaPedido);
                intent.putExtra("cantidad", cant);
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.btn_Suma:
                if (Integer.parseInt(cantidad_productos.getText().toString()) != 10 && !getTitle().equals("CajaBar")) {

                    int sumaCantidad = Integer.parseInt(cantidad_productos.getText().toString()) + 1;
                    double sumaPrecio = primerPrecio * sumaCantidad;
                    cantidad_productos.setText(Integer.toString(sumaCantidad));
                    precio_producto.setText(Double.toString(sumaPrecio));
                }
                break;
            case R.id.btn_Resta:
                if (Integer.parseInt(cantidad_productos.getText().toString()) != 1 && !getTitle().equals("CajaBar")) {

                    int restaCantidad = Integer.parseInt(cantidad_productos.getText().toString()) - 1;
                    cantidad_productos.setText(Integer.toString(restaCantidad));
                    double restaPrecio = Double.parseDouble(precio_producto.getText().toString()) - primerPrecio;
                    precio_producto.setText(Double.toString(restaPrecio));
                }
                break;
            case R.id.btn_cancelar_productos_activity:
                finish();
                break;
        }

    }


}
