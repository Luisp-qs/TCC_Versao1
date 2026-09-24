package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro);

        btnCriarConta = findViewById(R.id.btnCriarConta);

        btnCriarConta.setOnClickListener(v -> {

            Intent intent = new Intent(
                    CadastroActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}