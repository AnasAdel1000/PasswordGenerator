package com.andro.passwordgenerator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView splash = findViewById(R.id.splash);
        TextView label = findViewById(R.id.label);
        ProgressBar progress = findViewById(R.id.progress);

        new android.os.Handler().postDelayed(()-> {
            progress.setVisibility(View.GONE);
            label.setVisibility(View.GONE);
            splash.setVisibility(View.GONE);

            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
            },3000);
    }
}