package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    // Botão transparente sobre o banner
    private View btnBannerMontePrato;

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

            Intent intent = new Intent(
                    HomeActivity.this,
                    HistoricoActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // EVOLUÇÃO
        // =========================

        btnEvolucao = findViewById(R.id.btnEvolucao);

        btnEvolucao.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    EvolucaoActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // MONTE SEU PRATO
        // =========================

        btnMontePrato = findViewById(R.id.btnMontePrato);

        btnMontePrato.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MontePratoActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // MONTE SEU PRATO - BANNER
        // =========================

        btnBannerMontePrato = findViewById(R.id.btnBannerMontePrato);

        btnBannerMontePrato.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MontePratoActivity.class
            );

            startActivity(intent);
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