package com.osmany.cajabar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import java.util.Iterator;

public class ProductosActivity extends AppCompatActivity {

    Stock miStock = new Stock();
    TableLayout miTable;
    Iterator<Productos> iterator = miStock.getList().iterator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        miTable = findViewById(R.id.table_layout);
    }
}
