package com.andro.passwordgenerator;

import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.random.*;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.content.Context;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;

public class about_app extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);

        ImageView back = findViewById(R.id.back);
        ImageView contact = findViewById(R.id.contact);

        back.setOnClickListener((View v)->{
            Intent intent = new Intent(about_app.this, Home.class);
            startActivity(intent);
            finish();
        });

        contact.setOnClickListener((View v)->{
            Toast.makeText(about_app.this,"Email copied successfully",Toast.LENGTH_LONG).show();
            ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipboard = ClipData.newPlainText("Email","anasdev530@gmail.com");
            clip.setPrimaryClip(clipboard);

            contact.setElevation(8f);

            new android.os.Handler().postDelayed(()->{contact.setElevation(0f); },300);

        });

    }
}