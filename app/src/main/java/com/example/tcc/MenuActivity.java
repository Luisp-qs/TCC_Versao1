package com.example.tcc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
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
    private LinearLayout menuMontePrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Tema do menu
        setTheme(R.style.Theme_TCC_Menu);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        // =====================================================
        // CONFIGURAÇÃO DA JANELA
        // =====================================================

        Window window = getWindow();

        // Fundo transparente
        window.setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT)
        );

        // Escurece a tela que está atrás
        window.addFlags(
                WindowManager.LayoutParams.FLAG_DIM_BEHIND
        );

        WindowManager.LayoutParams params =
                window.getAttributes();

        // Escurecimento
        params.dimAmount = 0.35f;

        // Metade da largura da tela
        params.width =
                getResources()
                        .getDisplayMetrics()
                        .widthPixels / 2;

        // Toda a altura
        params.height =
                WindowManager.LayoutParams.MATCH_PARENT;

        // Canto superior esquerdo
        params.gravity =
                Gravity.START | Gravity.TOP;

        window.setAttributes(params);


        // =====================================================
        // HOME
        // =====================================================

        menuHome = findViewById(R.id.menuHome);

        menuHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // BALANÇA
        // =====================================================

        menuBalanca = findViewById(R.id.menuBalanca);

        menuBalanca.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    ConexaoActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // REFEIÇÕES
        // =====================================================

        menuRefeicoes = findViewById(R.id.menuRefeicoes);

        menuRefeicoes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    RefeicoesActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // PERFIL
        // =====================================================

        menuPerfil = findViewById(R.id.menuPerfil);

        menuPerfil.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // SOBRE NÓS
        // =====================================================

        btnSobreNos = findViewById(R.id.btnSobreNos);

        btnSobreNos.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    SobreNosActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // EVOLUÇÃO
        // =====================================================

        menuEvolucao = findViewById(R.id.menuEvolucao);

        menuEvolucao.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    EvolucaoActivity.class
            );

            startActivity(intent);
            finish();
        });


        // =====================================================
        // HISTÓRICO
        // =====================================================

        menuHistorico = findViewById(R.id.menuHistorico);

        menuHistorico.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    HistoricoActivity.class
            );

            startActivity(intent);
            finish();
        });

        // =========================
// MONTE SEU PRATO
// =========================

        menuMontePrato = findViewById(R.id.menuMontePrato);

        menuMontePrato.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    MontePratoActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}