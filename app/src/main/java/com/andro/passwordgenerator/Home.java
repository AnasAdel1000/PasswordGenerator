package com.andro.passwordgenerator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.content.Intent;

import java.util.Random;

public class Home extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%*";
        Toast.makeText(Home.this, "Welcome User !", Toast.LENGTH_SHORT).show();
        TextView about = findViewById(R.id.about);
        CardView generate = findViewById(R.id.generate);
        CardView copy = findViewById(R.id.copy);
        EditText pass= findViewById(R.id.pass);
        float copyelv= copy.getCardElevation();
        float generateelv =generate.getCardElevation();


                about.setOnLongClickListener((View v) -> {
            about.setTextColor(Color.parseColor("#0F28ED"));

            new android.os.Handler().postDelayed(()->{
                about.setTextColor(getResources().getColor(R.color.white));
            },1000);
            return true;
        });

        about.setOnClickListener((View v)->{
            Intent intent = new Intent(Home.this,about_app.class);
            startActivity(intent);
        });

        generate.setOnClickListener((View v)->{
            Random r = new Random();
            String password = "";
            Toast.makeText(Home.this,"Generating new password .....",Toast.LENGTH_LONG).show();

            generate.setCardElevation(generateelv * 2);

            new android.os.Handler().postDelayed(()->{
                generate.setCardElevation(generateelv);
            },300);

            for (int i =0; i<12; i++){
                int index = r.nextInt(chars.length());
                password += chars.charAt(index);
            }
            pass.setText(password);
        });

        copy.setOnClickListener((View v)->{
            Toast.makeText(Home.this,"Copied To Clipboard",Toast.LENGTH_LONG).show();

            copy.setCardElevation(generateelv * 2);

            new android.os.Handler().postDelayed(()->{
                copy.setCardElevation(generateelv);
            },300);

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied password",pass.getText().toString());
            clipboard.setPrimaryClip(clip);
        });

    }
}
