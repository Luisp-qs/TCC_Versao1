package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnMenu;
    private ImageButton btnPerfilHome;

    private LinearLayout btnHistorico;
    private LinearLayout btnEvolucao;
    private LinearLayout btnMontePrato;

    private LinearLayout cardJejum;
    private LinearLayout cardMassaMagra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        // =========================
        // BOTÃO MENU
        // =========================

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MenuActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // BOTÃO PERFIL
        // =========================

        btnPerfilHome = findViewById(R.id.btnPerfilHome);

        btnPerfilHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // HISTÓRICO
        // =========================

        btnHistorico = findViewById(R.id.btnHistorico);

        btnHistorico.setOnClickListener(v -> {

            // Tela de histórico será conectada posteriormente.

        });


        // =========================
        // EVOLUÇÃO
        // =========================

        btnEvolucao = findViewById(R.id.btnEvolucao);

        btnEvolucao.setOnClickListener(v -> {

            // Tela de evolução será conectada posteriormente.

        });


        // =========================
        // MONTE SEU PRATO
        // =========================

        btnMontePrato = findViewById(R.id.btnMontePrato);

        btnMontePrato.setOnClickListener(v -> {

            // Tela "Monte seu Prato" será conectada posteriormente.

        });


        // =========================
        // CARD JEJUM
        // =========================

        cardJejum = findViewById(R.id.cardJejum);

        cardJejum.setOnClickListener(v -> {

            // Conteúdo sobre jejum será conectado posteriormente.

        });


        // =========================
        // CARD MASSA MAGRA
        // =========================

        cardMassaMagra = findViewById(R.id.cardMassaMagra);

        cardMassaMagra.setOnClickListener(v -> {

            // Conteúdo sobre massa magra será conectado posteriormente.

        });

    }
}