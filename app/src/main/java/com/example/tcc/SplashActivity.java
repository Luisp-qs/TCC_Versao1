package com.example.tcc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        VideoView videoView = findViewById(R.id.videoView);

        Uri videoUri = Uri.parse(
                "android.resource://" + getPackageName() + "/" + R.raw.screen
        );

        videoView.setVideoURI(videoUri);

        // Zoom na animação
        videoView.setScaleX(1f);
        videoView.setScaleY(1f);

        videoView.start();

        new android.os.Handler().postDelayed(() -> {

            Intent intent = new Intent(
                    SplashActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
            finish();

        }, 1000);
    }
}