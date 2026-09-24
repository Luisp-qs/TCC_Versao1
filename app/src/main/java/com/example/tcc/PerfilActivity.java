package com.example.tcc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    private ImageButton btnMenuPerfil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);

        btnMenuPerfil = findViewById(R.id.btnMenuPerfil);

        btnMenuPerfil.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    MenuActivity.class
            );

            startActivity(intent);
        });
    }
}