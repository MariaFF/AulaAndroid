package com.example.maria.armazenamentointerno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_bloco_notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_bloco_notas = (Button) findViewById(R.id.main_bloco_notas);


    }

    public void abrirBlocoNotas(View view){
        Intent intent = new Intent(getApplicationContext(), BlocoNotas.class);
        startActivity(intent);

    }
}
