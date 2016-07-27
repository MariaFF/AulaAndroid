package com.example.maria.armazenamentointerno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BlocoNotas extends AppCompatActivity{

    private Button btSalvar;
    private Button btAbrir;
    private EditText edBlocoNotas;

    private static final String NOME_ARQUIVO = "bn.txt";
    private static final String COMPRAS = "compras.txt";
    private static final String TRABALHO = "trabalho.txt";
    private static final String CASA = "casa.txt";
    private static final int BLOCO_LEITURA = 100;
    //Indica o nome da classe
    private static final String TAG = "BlocoNotas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloco_notas);

        //btAbrir = (Button) findViewById(R.id.bloco_notas_abrir);
        //btSalvar = (Button) findViewById(R.id.bloco_notas_salvar);
        edBlocoNotas = (EditText) findViewById(R.id.bloco_notas_edit);
    }

    @Override
    protected void onPause() {
        super.onPause();
        salvarArquivo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        abrir();
    }

    public void abrir(){

        try {
            //Abrir o arquivo
            FileInputStream fileInputStream = openFileInput(NOME_ARQUIVO);
            //Efetuar leitura do arquivo
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            char[] inputBuffer = new char[BLOCO_LEITURA];
            StringBuilder stringBuilder = new StringBuilder();
            int qtdeLido;
            while((qtdeLido = inputStreamReader.read(inputBuffer)) > 0){
                stringBuilder.append(String.copyValueOf(inputBuffer, 0, qtdeLido));
                inputBuffer = new char[BLOCO_LEITURA];
            }

            edBlocoNotas.setText(stringBuilder.toString());

        }catch (FileNotFoundException e){
            Log.e(TAG, "Arquivo não encontrado");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void salvarArquivo(){


        try {
            //Abrir um arquivo, quando não existe ele cria
            FileOutputStream fileOutputStream = openFileOutput(NOME_ARQUIVO, MODE_PRIVATE);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(edBlocoNotas.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();

            Toast.makeText(BlocoNotas.this, "Arquivo Salvo", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Log.e(TAG, "erro ao salvar arquivo");
        }

    }
}
