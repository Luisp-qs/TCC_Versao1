package com.example.tcc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout menuHome;
    private LinearLayout menuPerfil;
    private LinearLayout btnSobreNos;

    @SuppressLint("WrongViewCast")
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
    }
}