package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private TextView esqueciSenha;
    private TextView txtCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        btnEntrar = findViewById(R.id.btnEntrar);
        esqueciSenha = findViewById(R.id.esqueciSenha);
        txtCadastro = findViewById(R.id.txtCadastro);

        // Entrar → Home
        btnEntrar.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
            finish();
        });

        // Esqueceu a senha?
        esqueciSenha.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    EsqueceuSenha.class
            );

            startActivity(intent);
        });

        // Cadastre-se → Cadastro
        txtCadastro.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    CadastroActivity.class
            );

            startActivity(intent);
        });
    }
}