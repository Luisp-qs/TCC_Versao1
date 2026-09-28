package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SobreNosActivity extends AppCompatActivity {

    private ImageButton btnMenu;
    private ImageButton btnPerfilSobreNos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sobre_nos);

        // MENU
        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SobreNosActivity.this,
                    MenuActivity.class
            );

            startActivity(intent);
            finish();
        });

        // PERFIL
        btnPerfilSobreNos = findViewById(R.id.btnPerfilSobreNos);

        btnPerfilSobreNos.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SobreNosActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });
    }
}