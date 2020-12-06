package com.example.aesencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    EditText inputText, inputPassword;
    Button encButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.inputText);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        encButton = (Button) findViewById(R.id.encButton);

        encButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EncryptedActivity.class);
                String gettext=inputText.getText().toString();
                String getpass=inputPassword.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("text",gettext);
                bundle.putString("pass", getpass);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}