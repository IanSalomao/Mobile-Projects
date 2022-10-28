package com.example.android;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;




public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private TextInputEditText litroGasolina, litroEtanol;
    private TextView valor;
    private ImageView img_gasolina, img_etanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = findViewById(R.id.btnCalcular);
        litroGasolina = findViewById(R.id.litroGasolina);
        litroEtanol = findViewById(R.id.litroEtanol);
        valor = findViewById(R.id.valor);
        img_etanol = findViewById(R.id.imageView_etanol);
        img_gasolina = findViewById(R.id.imageView_gasolina);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gasolina = litroGasolina.getText().toString();
                String etanol = litroEtanol.getText().toString();
                if(!gasolina.isEmpty() && !etanol.isEmpty() ) {
                    double inpGasolina = Double.parseDouble(gasolina);
                    double inpEtanol = Double.parseDouble(etanol);
                    double resultado = (inpEtanol/inpGasolina);
                    if (resultado <= 0.7) {
                        valor.setText("Abasteça com Etanol");
                        valor.setTextColor(0xFF00FF0A);
                        img_etanol.setVisibility(View.VISIBLE);
                    } else {
                        valor.setText("Abastaça com Gasolina");
                        valor.setTextColor(0xFFFF0000);
                        img_gasolina.setVisibility(View.VISIBLE);
                    }
                } else {
                    valor.setText("Preencha todos os campos");
                }
                }
            });
    }
}