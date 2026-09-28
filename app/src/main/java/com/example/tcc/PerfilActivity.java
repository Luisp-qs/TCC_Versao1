package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    private Button btnSair;
    private Button btnSairConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);

        // BOTÃO SAIR
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    HomeActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });

        // BOTÃO SAIR DA CONTA
        btnSairConta = findViewById(R.id.btnSairConta);

        btnSairConta.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    CadastroActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);
            finish();
        });
    }
}