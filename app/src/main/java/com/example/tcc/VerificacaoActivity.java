package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VerificacaoActivity extends AppCompatActivity {

    private Button btnVerificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verificacao);

        btnVerificacao = findViewById(R.id.btnVerificacao);


            btnVerificacao.setOnClickListener(v -> {

                Intent intent = new Intent(
                        VerificacaoActivity.this,
                        NovaSenhaActivity.class
                );

                startActivity(intent);
                finish();
            });

    }
}