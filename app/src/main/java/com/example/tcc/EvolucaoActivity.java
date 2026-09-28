package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class EvolucaoActivity extends AppCompatActivity {

    private ImageButton btnMenu;
    private ImageButton btnPerfilEvolucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_evolucao);

        // =========================
        // MENU
        // =========================

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {

            Intent intent = new Intent(
                    EvolucaoActivity.this,
                    MenuActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =========================
        // PERFIL
        // =========================

        btnPerfilEvolucao = findViewById(R.id.btnPerfilEvolucao);

        btnPerfilEvolucao.setOnClickListener(v -> {

            Intent intent = new Intent(
                    EvolucaoActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });
    }
}