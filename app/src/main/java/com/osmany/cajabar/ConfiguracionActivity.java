package com.osmany.cajabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfiguracionActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String DATOS_DE_LA_ACTIVIDAD_PROPIEDADES_A_PMAIN_ACTIVITY = "datos para la main Activity";
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

        euro = findViewById(R.id.Radio_Euro);
        dollar = findViewById(R.id.Radio_Dollar);
        bitcoin = findViewById(R.id.Radio_Bitcoin);
        iva = findViewById(R.id.Radio_IVA);
        igic = findViewById(R.id.Radio_IGIC);
        dollar.setOnClickListener(this);


        if (propiedades.getMoneda().contains("€")) {
            euro.setChecked(true);
        }
        if (propiedades.getMoneda().contains("$")) {
            dollar.setChecked(true);
        }
        if (propiedades.getMoneda().contains("BTC")) {
            bitcoin.setChecked(true);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Radio_Euro:
                propiedades.setMoneda("€");
                break;
            case R.id.Radio_Dollar:
                propiedades.setMoneda("$");
                break;
            case R.id.btn_Guardar:
                Intent intent = new Intent();
                intent.putExtra(DATOS_DE_LA_ACTIVIDAD_PROPIEDADES_A_PMAIN_ACTIVITY, propiedades);
                setResult(RESULT_OK, intent);
                finish();
                break;

        }
    }
}
