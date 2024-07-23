package com.example.exercicoimc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsIMC extends AppCompatActivity {

    private TextView result_altura;
    private TextView result_peso;
    private TextView resultado_imc;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_imc);

        result_peso = findViewById(R.id.result_peso);
        result_altura = findViewById(R.id.result_altura);
        resultado_imc = findViewById(R.id.resultado_imc);

        Intent it = getIntent();

        double peso = it.getDoubleExtra("peso", 0.0);
        result_peso.setText("Peso informado "+ peso +" kg");

        double altura = it.getDoubleExtra("altura", 0.0);
        result_altura.setText("altura informado "+ altura +" m");

        double resultado = it.getDoubleExtra("imc", 0.0);

        resultado_imc.setText("IMC: " + statusDePeso(resultado) +" "+ resultado);



    }

    public String statusDePeso(double resultadoPeso ){

        if (resultadoPeso < 18.5){
            return "Abaixo do peso";
        }else if(resultadoPeso >= 18.5 && resultadoPeso <= 24.9){
            return "Peso Normal";
        }else if(resultadoPeso >= 25.0 && resultadoPeso <= 29.9){
            return "Sobrepeso";
        }else {
            return "Obesidade";
        }
    }
}