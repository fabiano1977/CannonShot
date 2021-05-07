package com.fabianosilva.cannonshot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText editVelocidadeBala;
    private EditText editAnguloCanhao;
    private TextView textViewAlturaBala;
    private TextView textViewDistanciaBala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editVelocidadeBala = findViewById(R.id.editTextNumberDecimalVelocidadeBala);
        editAnguloCanhao = findViewById(R.id.editTextNumberDecimalAnguloCanhao);
        textViewAlturaBala = findViewById(R.id.textViewAlturaBala);
        textViewDistanciaBala = findViewById(R.id.textViewDistanciaBala);
    }

    public void calcularTiroCanhao(View view){
        final double aceleracao = 9.81; //Constante em m/s²
        double velocidadeInicial = Double.parseDouble(editVelocidadeBala.getText().toString());
        double angulo = Double.parseDouble(editAnguloCanhao.getText().toString());


        //Converter Graus para Radianos

        angulo = Math.toRadians(angulo);

        //-----------REALIZAÇÃO DE CÁLCULOS ----------------
        double alturaMaxima = velocidadeInicial * Math.sin(angulo) / (2 * aceleracao);
        double distanciaMaxima = 2 * velocidadeInicial * Math.cos(angulo) * Math.sin(angulo) / aceleracao;

        try{
            if (velocidadeInicial > 0 && (angulo > 0 && angulo < 90)) {

                textViewAlturaBala.setText("ALTURA DE " + String.format("%4f", alturaMaxima) + " KM");
                textViewDistanciaBala.setText("DISTNÂCIA DE "+ String.format("%4f", distanciaMaxima) + " KM");

            }else{

                textViewAlturaBala.setText("DIGITE A VELOCIDADE DA BALA > 0");
                textViewDistanciaBala.setText("DIGITE O ÂNGULO DO CANHÃO > 0 < 90");

            }
        }catch (Exception e){

            textViewAlturaBala.setText(e + "NÃO DIGITE VELOCIDADE COM(,), DIGITE COM (.)");
            textViewDistanciaBala.setText(e + "NÃO DIGITE ÂNGULO COM (,), DIGITE COM (.)");

        }



    }
}