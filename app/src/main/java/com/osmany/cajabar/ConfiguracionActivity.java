package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfiguracionActivity extends AppCompatActivity implements View.OnClickListener {



    public static final String DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY = "datos para Configuracion";

    RadioGroup tipoMoneda;
    RadioGroup tipoImpuesto;
    RadioButton euro, dollar, bitcoin, iva, igic;
    CheckBox mayor;
    Button volver;
    private Propiedades propiedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        propiedades = (Propiedades) getIntent().getSerializableExtra(DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY);
        volver = findViewById(R.id.btn_Guardar);
        volver.setOnClickListener(this);


        mayor = findViewById(R.id.check_propiedades_activity);
        mayor.setOnClickListener(this);
        euro = findViewById(R.id.Radio_Euro);
        euro.setOnClickListener(this);
        dollar = findViewById(R.id.Radio_Dollar);
        dollar.setOnClickListener(this);
        bitcoin = findViewById(R.id.Radio_Bitcoin);
        bitcoin.setOnClickListener(this);
        iva = findViewById(R.id.Radio_IVA);
        iva.setOnClickListener(this);
        igic = findViewById(R.id.Radio_IGIC);
        igic.setOnClickListener(this);


        rellenaLayout();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_propiedades_activity:
                if (propiedades.isMayor18()) {
                    propiedades.setMayor18(false);
                } else {
                    propiedades.setMayor18(true);
                }
                break;
            case R.id.Radio_IGIC:
                propiedades.setIva(false);
                break;
            case R.id.Radio_IVA:
                propiedades.setIva(true);
                break;
            case R.id.Radio_Bitcoin:
                propiedades.setMoneda("BTC");
                break;
            case R.id.Radio_Euro:
                propiedades.setMoneda("€");
                break;
            case R.id.Radio_Dollar:
                propiedades.setMoneda("$");
                break;
            case R.id.btn_Guardar:
                Log.d("moneda", propiedades.getMoneda());
                Intent intent = new Intent();

                intent.putExtra(DATOS_DE_LA_ACTIVIDAD_PMAIN_ACTIVITY, propiedades);
                setResult(RESULT_OK, intent);
                finish();
                break;

        }


    }

    public void rellenaLayout() {
        if (propiedades.getMoneda().contains("€")) {
            euro.setChecked(true);
        } else if (propiedades.getMoneda().contains("$")) {
            dollar.setChecked(true);
        } else {
            bitcoin.setChecked(true);
        }

        if (propiedades.isIva()) {
            iva.setChecked(true);
        } else {
            igic.setChecked(true);
        }
        if (propiedades.mayor18) {
            mayor.setChecked(true);
        } else {
            mayor.setChecked(false);
        }
    }

}
