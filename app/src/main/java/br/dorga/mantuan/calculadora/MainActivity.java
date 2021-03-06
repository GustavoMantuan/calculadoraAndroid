package br.dorga.mantuan.calculadora;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Logger;


public class MainActivity extends Activity {
    private String operacao = "";
    private String n1 = "";

    private Integer num1 = 0;
    private Integer num2 = 0;
    private EditText etScreen;
    private TextView tvCalculadora;


    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etScreen = (EditText) findViewById(R.id.etScreen);
        tvCalculadora = (TextView) findViewById(R.id.tvCalculadora);
    }

    public void pegaBotao(View v){
            n1 = (String) ((Button) v).getText();
            etScreen.append(n1);
            tvCalculadora.append(n1);
    };
    public Integer numero(){
        if ((etScreen.getText().length() > 0) || !etScreen.getText().toString().contains("")) {
            return Integer.parseInt(String.valueOf(etScreen.getText()));
        }
        else {
            return 0;
        }
    };

    public Integer soma(Integer a, Integer b){ return (a+b);}
    public Integer sub(Integer a, Integer b){
        return (a-b);
    }
    public Integer divide(Integer a, Integer b){
        return (a / b);
    }
    public Integer multiplica(Integer a, Integer b){
        return (a * b);
    }


    public void fazOperacao(View v) {

        if (((String) ((Button) v).getText().toString()).equals("CE") ){
            num1 = 0;
            num2 = 0;
            etScreen.setText("");
            tvCalculadora.setText("");
        } else {
            tvCalculadora.append((String) ((Button) v).getText().toString());
            if (num1 == 0) {
                num1 = numero();
                etScreen.setText("");
                operacao = (String) ((Button) v).getText().toString();
            } else {
                switch (operacao) {
                    case "+":
                        if (num1 == 0) {
                            num1 = numero();
                        } else {
                            num1 = soma(num1, numero());
                        }
                        etScreen.setText("");
                        operacao = (String) ((Button) v).getText().toString();
                        break;
                    case "-":
                        if (num1 == 0) {
                            num1 = numero();
                        } else {
                            num1 = sub(num1, numero());
                        }
                        etScreen.setText("");
                        operacao = (String) ((Button) v).getText().toString();
                        break;
                    case "/":
                        if (num1 == 0) {
                            num1 = numero();
                        } else {
                            num1 = divide(num1, numero());
                        }
                        etScreen.setText("");
                         operacao = (String) ((Button) v).getText().toString();
                        break;
                    case "X":
                        if (num1 == 0) {
                            num1 = numero();
                        } else {
                            num1 = multiplica(num1, numero());
                        }
                        etScreen.setText("");
                        operacao = (String) ((Button) v).getText().toString();
                        break;
                }
            }
        }
    }
    public void fazBinario(View v){
        num1 = numero();
        StringBuffer resultado = new StringBuffer();
        int sobra = 0;
        do {
            sobra = num1%2;
            num1 = num1/2;
            resultado.append(sobra);
        }while (num1 != 0);
        etScreen.setText(resultado.reverse());
    }

    public void resultado(View v){
        num2 = numero();
        tvCalculadora.append("=");
        etScreen.setText("");
        switch(operacao){
            case "+":
                tvCalculadora.append(soma(num1,num2).toString());
                num1 = soma(num1,num2);
            break;
            case "-":

                tvCalculadora.append(sub(num1, num2).toString());
                num1 = sub(num1,num2);
                break;
            case "X":

                tvCalculadora.append(multiplica(num1, num2).toString());
                num1 = multiplica(num1,num2);
                break;
            case "/":

                tvCalculadora.append(divide(num1, num2).toString());
                num1 = divide(num1,num2);
                break;
        }


    }

}
