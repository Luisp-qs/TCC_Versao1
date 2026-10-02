package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionarioActivity extends AppCompatActivity {

    private Spinner spinnerGenero;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_questionario);

        spinnerGenero = findViewById(R.id.spinnerGenero);
        btnContinue = findViewById(R.id.btnContinue);

        // Opções de gênero
        String[] opcoesGenero = {
                "Selecione seu gênero",
                "Homem",
                "Mulher",
                "Prefiro não dizer"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opcoesGenero
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerGenero.setAdapter(adapter);

        // Botão Continue → Questionário 2
        btnContinue.setOnClickListener(v -> {

            Intent intent = new Intent(
                    QuestionarioActivity.this,
                    QuestionarioPessoalActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}