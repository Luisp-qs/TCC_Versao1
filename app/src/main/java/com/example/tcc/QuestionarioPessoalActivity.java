package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionarioPessoalActivity extends AppCompatActivity {

    private Button btnPerderPeso;
    private Button btnGanharMusculo;
    private Button btnManterPeso;
    private Button btnComerSaudavel;
    private Button btnObjetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_questionario_pessoal);

        btnPerderPeso = findViewById(R.id.btnPerderPeso);
        btnGanharMusculo = findViewById(R.id.btnGanharMusculo);
        btnManterPeso = findViewById(R.id.btnManterPeso);
        btnComerSaudavel = findViewById(R.id.btnComerSaudavel);
        btnObjetivo = findViewById(R.id.btnObjetivo);

        btnObjetivo.setOnClickListener(v -> {

            Intent intent = new Intent(
                    QuestionarioPessoalActivity.this,
                    ExercicioActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}