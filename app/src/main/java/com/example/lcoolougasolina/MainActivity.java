package com.example.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView editResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.precoAlcool);
        editPrecoGasolina = findViewById(R.id.precoGasolina);
        editResultado = findViewById(R.id.textResultado);
    }

    // metodo qu pcalcular o preço
    public void calcularPreco (View view){

        //recuperando valor
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        //convertendo os campos para double
        if (camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool.
                    replace(",","."));
            Double valorGasolina = Double.parseDouble(precoGasolina.
                    replace(",","."));

            /*Fazer cálcular de menor preço
             *se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             *  senão é melhor utilizar álcool
             */

            //fazendo calculor
            double resultado = valorAlcool / valorGasolina;

            //mostrando resultado
            if (resultado >= 0.7){
                editResultado.setText("Melhor utilizar Gasolina");
            }else{
                editResultado.setText("Melhor utilizar Álcool");
            }

        }else {
            editResultado.setText("Prencha os preços primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
           camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }
         return camposValidados;
    }
}