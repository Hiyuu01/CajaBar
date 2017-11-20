package com.osmany.cajabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfiguracionActivity extends AppCompatActivity{

    Button guardar;
    RadioGroup rg1;
    RadioGroup rg2;
    CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        rg1=findViewById(R.id.Radio_G1) ;
        rg2=findViewById(R.id.Radio_G2) ;
        guardar = findViewById(R.id.btn_Guardar);
        guardar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToPedido = new Intent(getApplicationContext(),MainActivity.class);
                backToPedido.putExtra("Moneda",rg1.getCheckedRadioButtonId());
                backToPedido.putExtra("Impuesto",rg2.getCheckedRadioButtonId());
                startActivity(backToPedido);
            }
        });

    }


}
