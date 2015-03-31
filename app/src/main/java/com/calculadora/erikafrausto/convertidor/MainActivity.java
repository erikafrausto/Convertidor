package com.calculadora.erikafrausto.convertidor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private EditText dataConverter;
    private TextView Result;
    private RadioButton Centigrados,Farenheit;
    private RadioGroup radioGroup;
    double convert,aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataConverter = (EditText) findViewById(R.id.dataConverter);
        Result = (TextView) findViewById(R.id.lblResult);
        Centigrados = (RadioButton) findViewById(R.id.rdoCent);
        Farenheit = (RadioButton) findViewById(R.id.rdoFaren);
        radioGroup = (RadioGroup)findViewById(R.id.group);



        Centigrados.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                if((String.valueOf(dataConverter.getText())).equals("")) {
                    Result.setText("Resultado: Esperando Dato");
                }else{
                    aux = Double.parseDouble(String.valueOf(dataConverter.getText()));
                    convert = (aux - 32) / 1.8;
                    Result.setText("Resultado:" + convert + "°C");
                }

            }
        });

        Farenheit.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                if((String.valueOf(dataConverter.getText())).equals("")) {
                    Result.setText("Resultado: Esperando Dato");
                }else{
                    aux = Double.parseDouble(String.valueOf(dataConverter.getText()));
                    convert = (aux * 1.8) + 32;
                    Result.setText("Resultado:" + convert + "°C");
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

