package com.example.exercicoimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edit_peso;
    private EditText edit_altura;
    private Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calcular = findViewById(R.id.btn_Calcular);
        edit_peso = findViewById(R.id.edit_peso);
        edit_altura = findViewById(R.id.edit_altura);

        btn_calcular.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, ResultsIMC.class);


            Double peso = Double.parseDouble(edit_peso.getText().toString());
            Double altura = Double.parseDouble(edit_altura.getText().toString());

            if(!peso.toString().isEmpty() && !altura.toString().isEmpty() ){


                double imc = calcularImc(altura, peso);
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", imc);

                startActivity(intent);

            }

        });

    }

    public double calcularImc(double altura, double peso){
        double resultado = peso / (altura * altura);
        DecimalFormat df = new DecimalFormat("#.#");
        String formatadoResultado = df.format(resultado);
        resultado = Double.parseDouble(formatadoResultado);

        if (resultado < 18.5){
            System.out.println("Abaixo do peso");
        }else if(resultado >= 18.5 && resultado <= 24.9){
            System.out.println("Peso Normal");
        }else if(resultado >= 25.0 && resultado <= 29.9){
            System.out.println("Sobrepeso");
        }else {
            System.out.println("Obesidade");
        }


        return resultado;

    }
}