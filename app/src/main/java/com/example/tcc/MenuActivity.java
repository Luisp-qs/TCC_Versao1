package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout menuHome;
    private LinearLayout menuBalanca;
    private LinearLayout menuRefeicoes;
    private LinearLayout menuPerfil;
    private LinearLayout btnSobreNos;
    private LinearLayout menuEvolucao;
    private LinearLayout menuHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        // =========================
        // HOME
        // =========================

        menuHome = findViewById(R.id.menuHome);

        menuHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =========================
        // CONECTAR À BALANÇA
        // =========================

        menuBalanca = findViewById(R.id.menuBalanca);

        menuBalanca.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    ConexaoActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // REFEIÇÕES
        // =========================

        menuRefeicoes = findViewById(R.id.menuRefeicoes);

        menuRefeicoes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    RefeicoesActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =========================
        // PERFIL
        // =========================

        menuPerfil = findViewById(R.id.menuPerfil);

        menuPerfil.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =========================
        // SOBRE NÓS
        // =========================

        btnSobreNos = findViewById(R.id.btnSobreNos);

        btnSobreNos.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    SobreNosActivity.class
            );

            startActivity(intent);
            finish();
        });

        // EVOLUÇÃO
        menuEvolucao = findViewById(R.id.menuEvolucao);

        menuEvolucao.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuActivity.this,
                    EvolucaoActivity.class
            );

            startActivity(intent);
            finish();
        });

        // HISTÓRICO
        menuHistorico = findViewById(R.id.menuHistorico);

        menuHistorico.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    HistoricoActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}