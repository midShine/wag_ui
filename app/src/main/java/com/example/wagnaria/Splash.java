package com.example.wagnaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.logging.LogRecord;

public class Splash extends AppCompatActivity {
    Animation splash;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        imageView = findViewById(R.id.logo_splash);

        imageView.startAnimation(splash);

        android.os.Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(Splash.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        },2500);
    }
}
