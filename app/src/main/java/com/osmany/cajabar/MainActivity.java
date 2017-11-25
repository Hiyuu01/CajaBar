package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static com.osmany.cajabar.ProductosActivity.CARGA_DATOS_CONFIGURACION;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Propiedades propiedades = new Propiedades();
    Button añadir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadir=findViewById(R.id.btn_añadir_main_activity);
        añadir.setOnClickListener(this);

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
}
