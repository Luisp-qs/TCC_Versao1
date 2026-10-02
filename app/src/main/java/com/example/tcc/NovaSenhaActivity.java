package com.example.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NovaSenhaActivity extends AppCompatActivity {

    private EditText edtNovaSenha;
    private EditText edtConfirmarSenha;
    private Button btnAlterarSenha;
    private TextView btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nova_senha);

        edtNovaSenha = findViewById(R.id.edtNovaSenha);
        edtConfirmarSenha = findViewById(R.id.edtConfirmarSenha);
        btnAlterarSenha = findViewById(R.id.btnAlterarSenha);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Voltar para a tela anterior
        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        // Alterar senha
        btnAlterarSenha.setOnClickListener(v -> {

            String novaSenha = edtNovaSenha.getText().toString();
            String confirmarSenha = edtConfirmarSenha.getText().toString();

            if (novaSenha.isEmpty()) {

                edtNovaSenha.setError("Digite sua nova senha");
                return;
            }

            if (confirmarSenha.isEmpty()) {

                edtConfirmarSenha.setError("Confirme sua senha");
                return;
            }

            if (!novaSenha.equals(confirmarSenha)) {

                edtConfirmarSenha.setError("As senhas não coincidem");
                return;
            }

            Toast.makeText(
                    NovaSenhaActivity.this,
                    "Senha alterada com sucesso!",
                    Toast.LENGTH_SHORT
            ).show();

            // Depois de alterar a senha → Login
            Intent intent = new Intent(
                    NovaSenhaActivity.this,
                    LoginActivity.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_NEW_TASK
            );

            startActivity(intent);
            finish();
        });
    }
}