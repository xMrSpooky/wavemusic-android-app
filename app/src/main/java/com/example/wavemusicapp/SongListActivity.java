package com.example.wavemusicapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        ListView lvCanciones = findViewById(R.id.lvCanciones);
        TextView tvReproduciendo = findViewById(R.id.tvReproduciendo);

        // Lista de canciones de ejemplo
        ArrayList<String> canciones = new ArrayList<>();
        canciones.add("Moscow Mule");
        canciones.add("Puntería");
        canciones.add("Bzrp Music Session");
        canciones.add("Higher Power");
        canciones.add("Mirada Dorada");
        canciones.add("Calle de Verano");
        canciones.add("Luz Eterna 4");
        canciones.add("Lluvia Infinita");
        canciones.add("Distancia de Verano");
        canciones.add("Melodía de Verano");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                canciones
        );

        lvCanciones.setAdapter(adapter);

        // Al tocar una canción: mostramos un Toast y actualizamos la barra de abajo
        lvCanciones.setOnItemClickListener((parent, view, position, id) -> {
            String cancionSeleccionada = canciones.get(position);

            Toast.makeText(
                    SongListActivity.this,
                    "Reproduciendo: " + cancionSeleccionada,
                    Toast.LENGTH_SHORT
            ).show();

            tvReproduciendo.setText("🎵 Reproduciendo ahora: " + cancionSeleccionada);
        });
    }
}