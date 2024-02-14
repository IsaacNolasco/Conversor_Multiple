package com.esquivel.conversor_multiple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Conver_area extends AppCompatActivity {
    Button btn;
    TextView temp;
    Spinner spn;

    public void Volver(View View) {
        Intent miIntent = new Intent(Conver_area.this, MainActivity.class);
        startActivity(miIntent);
    }

    conversor_a miConversor = new conversor_a();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conver_area);

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtcantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                spn = findViewById(R.id.spnde);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = findViewById(R.id.lblRespuesta);
                temp.setText("Respuesta: " + miConversor.convertir(0, de, a, cantidad));

            }
        });

    }

}
class conversor_a {
    double[][] valores = {
            {0.092903,1.423,1.195,1,628.8,6474.9,9.10000,}//area
    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}