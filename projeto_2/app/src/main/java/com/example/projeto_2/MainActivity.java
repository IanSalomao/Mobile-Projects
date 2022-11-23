package com.example.projeto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    private Button calcular, views;
    private TextView resultado;
    private EditText valor_converter, cotacao_dolar, cotacao_real;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_moedas = (Spinner) findViewById(R.id.spinner_moedas);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.lista_moedas));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_moedas.setAdapter(myAdapter);

        calcular = findViewById(R.id.calcular);
        views = findViewById(R.id.views);
        resultado = findViewById(R.id.resultado);
        valor_converter = findViewById(R.id.valor_converter);
        cotacao_dolar = findViewById(R.id.cotacao_dolar);
        cotacao_real = findViewById(R.id.cotacao_real);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set_moeda = spinner_moedas.getSelectedItem().toString();

                if(set_moeda.equals("Dolar")){
                    double resultado_final = Double.parseDouble(valor_converter.getText().toString())
                            * Double.parseDouble(cotacao_dolar.getText().toString());
                    resultado.setText(Double.toString(resultado_final));

                }else if(set_moeda.equals("Real")){
                    double resultado_final = Double.parseDouble(valor_converter.getText().toString())
                            * Double.parseDouble(cotacao_real.getText().toString());
                    resultado.setText(Double.toString(resultado_final));

                }else {
                    resultado.setText("...");
                }


            }
        });


        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent segundaTela;
                segundaTela = new Intent(getApplicationContext(), Views.class);
                startActivity(segundaTela);
            }
        });


    }
}