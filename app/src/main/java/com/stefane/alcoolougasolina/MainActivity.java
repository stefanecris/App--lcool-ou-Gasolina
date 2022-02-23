package com.stefane.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoPrecoAlcool;
    private TextInputEditText campoPrecoGasolina;
    private TextView exibeResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoPrecoAlcool = findViewById(R.id.precoAlcool);
        campoPrecoGasolina = findViewById(R.id.precoGasolina);
        exibeResultado = findViewById(R.id.exibeMelhorOpcao);

    }

    public Boolean validarCampos(String precoAlcool, String precoGasolina){
        if(precoAlcool == null || precoAlcool.equals("")){
            return false;
        }
        if(precoGasolina == null || precoGasolina.equals("")){
            return false;
        }
        return true;
    }

    public int calcularMelhorOpcao(String precoAlcool, String precoGasolina){
        double valorAlcool = Double.parseDouble(precoAlcool);
        double valorGasolina = Double.parseDouble(precoGasolina);
        if(valorAlcool / valorGasolina < 0.7){
            return 0;
        }else{
            return 1;
        }
    }

    public void exibirMelhorOpcao(View view){

        String precoAlcool, precoGasolina;

        // Recuperar valores digitados

        precoAlcool = campoPrecoAlcool.getText().toString();
        precoGasolina = campoPrecoGasolina.getText().toString();

        if(validarCampos(precoAlcool, precoGasolina)){
            int melhorOpcao = calcularMelhorOpcao(precoAlcool, precoGasolina);
            if(melhorOpcao == 0){
                exibeResultado.setText("Álcool é a melhor opção!");
            }else{
                exibeResultado.setText("Gasolina é a melhor opção!");
            }
        }else{
            exibeResultado.setText("Todos os campos devem ser preenchidos!");
        }

    }

}
