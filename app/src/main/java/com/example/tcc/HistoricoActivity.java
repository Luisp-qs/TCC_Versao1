package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HistoricoActivity extends AppCompatActivity {

    private ImageButton btnMenu;
    private ImageButton btnPerfilHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historico);

        // =========================
        // MENU
        // =========================

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HistoricoActivity.this,
                    MenuActivity.class
            );

            // Não usar finish().
            // O Histórico continua atrás do menu.
            startActivity(intent);
        });


        // =========================
        // PERFIL
        // =========================

        btnPerfilHistorico = findViewById(R.id.btnPerfilHistorico);

        btnPerfilHistorico.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HistoricoActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });
    }
}