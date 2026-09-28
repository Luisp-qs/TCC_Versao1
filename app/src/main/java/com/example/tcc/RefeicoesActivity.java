package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RefeicoesActivity extends AppCompatActivity {

    private ImageButton btnMenu;
    private ImageButton btnPerfilRefeicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_refeicoes);

        // =========================
        // MENU
        // =========================

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RefeicoesActivity.this,
                    MenuActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =========================
        // PERFIL
        // =========================

        btnPerfilRefeicoes = findViewById(R.id.btnPerfilRefeicoes);

        btnPerfilRefeicoes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RefeicoesActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });
    }
}