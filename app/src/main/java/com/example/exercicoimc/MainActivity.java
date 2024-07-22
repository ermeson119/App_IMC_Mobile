package com.example.exercicoimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout edit_peso;
    private TextInputLayout edit_altura;
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

            Double peso = Double.parseDouble(edit_peso.toString());
            Double altura = Double.parseDouble(edit_altura.toString());

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", calcularImc(peso, altura));

            startActivity(intent);
        });

    }

    public double calcularImc(double altura, double peso){
        return peso / (altura * altura);
    }
}