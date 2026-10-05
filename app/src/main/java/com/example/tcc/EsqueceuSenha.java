package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EsqueceuSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnEsqueceuSenha;

        setContentView(R.layout.activity_esqueci_senha);

        btnEsqueceuSenha = findViewById(R.id.esqueciSenha);

        btnEsqueceuSenha.setOnClickListener(v -> {

            Intent intent = new Intent(
                    EsqueceuSenha.this,
                    VerificacaoActivity.class
            );

            startActivity(intent);
            finish();
        });



    }
}
