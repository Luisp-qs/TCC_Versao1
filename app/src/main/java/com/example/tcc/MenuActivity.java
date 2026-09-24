package com.example.tcc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout menuHome;
    private LinearLayout menuPerfil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        menuHome = findViewById(R.id.menuHome);
        menuPerfil = findViewById(R.id.menuPerfil);

        menuHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
        });

        menuPerfil.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuActivity.this,
                    PerfilActivity.class
            );

            startActivity(intent);
        });
    }
}