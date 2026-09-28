package com.example.tcc;

import android.Manifest;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ConexaoActivity extends AppCompatActivity {

    private ImageButton btnVoltar;
    private Button btnConectar;

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;

    private static final int REQUEST_BLUETOOTH = 100;

    private static final UUID UUID_SPP =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_conexao);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnConectar = findViewById(R.id.btnConectar);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // BOTÃO VOLTAR
        btnVoltar.setOnClickListener(v -> finish());

        // BOTÃO CONECTAR
        btnConectar.setOnClickListener(v -> mostrarDispositivos());
    }

    // =====================================================
    // MOSTRA OS DISPOSITIVOS BLUETOOTH PAREADOS
    // =====================================================

    private void mostrarDispositivos() {

        if (bluetoothAdapter == null) {

            Toast.makeText(
                    this,
                    "Este celular não possui Bluetooth.",
                    Toast.LENGTH_LONG
            ).show();

            return;
        }

        // VERIFICA PERMISSÃO
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
        ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.BLUETOOTH_SCAN
                    },
                    REQUEST_BLUETOOTH
            );

            return;
        }

        // VERIFICA SE O BLUETOOTH ESTÁ LIGADO
        if (!bluetoothAdapter.isEnabled()) {

            Toast.makeText(
                    this,
                    "Ative o Bluetooth do celular.",
                    Toast.LENGTH_LONG
            ).show();

            return;
        }

        // PEGA OS DISPOSITIVOS PAREADOS
        Set<BluetoothDevice> dispositivosPareados =
                bluetoothAdapter.getBondedDevices();

        if (dispositivosPareados == null ||
                dispositivosPareados.isEmpty()) {

            Toast.makeText(
                    this,
                    "Nenhum dispositivo Bluetooth pareado foi encontrado.",
                    Toast.LENGTH_LONG
            ).show();

            return;
        }

        // LISTAS PARA O MENU
        List<BluetoothDevice> dispositivos =
                new ArrayList<>();

        List<String> nomes =
                new ArrayList<>();

        for (BluetoothDevice dispositivo : dispositivosPareados) {

            dispositivos.add(dispositivo);

            String nome = dispositivo.getName();

            if (nome == null || nome.trim().isEmpty()) {
                nome = "Dispositivo Bluetooth";
            }

            nomes.add(nome);
        }

        // CONVERTE PARA ARRAY
        String[] nomesArray =
                nomes.toArray(new String[0]);

        // MOSTRA A JANELA
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Selecione a balança")
                .setItems(nomesArray, (dialogInterface, position) -> {

                    BluetoothDevice dispositivoSelecionado =
                            dispositivos.get(position);

                    conectarDispositivo(dispositivoSelecionado);
                })
                .setNegativeButton("Cancelar", null)
                .create();

        dialog.show();
    }

    // =====================================================
    // CONECTA AO DISPOSITIVO ESCOLHIDO
    // =====================================================

    private void conectarDispositivo(BluetoothDevice dispositivo) {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
        ) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        String nomeDispositivo = dispositivo.getName();

        if (nomeDispositivo == null) {
            nomeDispositivo = "Dispositivo Bluetooth";
        }

        final String nomeFinal = nomeDispositivo;

        btnConectar.setEnabled(false);
        btnConectar.setText("Conectando...");

        Toast.makeText(
                this,
                "Conectando a " + nomeFinal + "...",
                Toast.LENGTH_SHORT
        ).show();

        // CONEXÃO EM SEGUNDO PLANO
        new Thread(() -> {

            BluetoothSocket socket = null;
            boolean conectado = false;

            try {

                socket =
                        dispositivo.createRfcommSocketToServiceRecord(
                                UUID_SPP
                        );

                socket.connect();

                bluetoothSocket = socket;

                conectado = true;

            } catch (IOException e) {

                try {

                    if (socket != null) {
                        socket.close();
                    }

                } catch (IOException ignored) {
                }
            }

            boolean resultado = conectado;

            runOnUiThread(() -> {

                btnConectar.setEnabled(true);
                btnConectar.setText("Conectar Dispositivo");

                if (resultado) {

                    Toast.makeText(
                            ConexaoActivity.this,
                            "Conexão bem-sucedida!",
                            Toast.LENGTH_LONG
                    ).show();

                } else {

                    Toast.makeText(
                            ConexaoActivity.this,
                            "Falha na conexão com " + nomeFinal + ".",
                            Toast.LENGTH_LONG
                    ).show();
                }
            });

        }).start();
    }

    // =====================================================
    // RESULTADO DA PERMISSÃO
    // =====================================================

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {

        super.onRequestPermissionsResult(
                requestCode,
                permissions,
                grantResults
        );

        if (requestCode == REQUEST_BLUETOOTH) {

            if (grantResults.length > 0
                    && grantResults[0]
                    == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(
                        this,
                        "Permissão concedida. Toque novamente em Conectar Dispositivo.",
                        Toast.LENGTH_LONG
                ).show();

            } else {

                Toast.makeText(
                        this,
                        "Permissão Bluetooth necessária.",
                        Toast.LENGTH_LONG
                ).show();
            }
        }
    }

    // =====================================================
    // FECHA A CONEXÃO AO SAIR DA TELA
    // =====================================================

    @Override
    protected void onDestroy() {

        super.onDestroy();

        try {

            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }

        } catch (IOException ignored) {
        }
    }
}