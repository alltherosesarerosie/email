package com.geektech.a3lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText email, theme, message;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.btn_first);
        theme = findViewById(R.id.btn_second);
        message = findViewById(R.id.btn_third);
        btn = findViewById(R.id.btn_next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_str = email.getText().toString().trim();
                String theme_str = theme.getText().toString().trim();
                String message_str = message.getText().toString().trim();

                sendEmail(email_str, theme_str, message_str);
            }
        });


    }

    @SuppressLint("IntentReset")
    private void sendEmail(String email_str, String theme_str, String message_str) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto"));
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email_str});
        intent.putExtra(Intent.EXTRA_SUBJECT, theme_str);
        intent.putExtra(Intent.EXTRA_TEXT, message_str );

        try{
            startActivity(Intent.createChooser(intent,"hello"));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}