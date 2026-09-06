package com.example.wavemusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    Button btnIngresar;
    TextView tvError;

    // Usuario de prueba
    private static final String USUARIO_VALIDO = "admin";
    private static final String PASSWORD_VALIDO = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        tvError = findViewById(R.id.tvError);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (usuario.equals(USUARIO_VALIDO) && password.equals(PASSWORD_VALIDO)) {
                    tvError.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this, SongListActivity.class);
                    startActivity(intent);
                } else {
                    tvError.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}