package com.example.temparature_app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
         Button ansBtn,againBtn;
         TextView showAns;
         EditText getVal;
         RadioButton Celsiustofahrenheit;
         Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        showAns = (TextView) findViewById(R.id.showAns);
        getVal = (EditText) findViewById(R.id.getVal);
        Celsiustofahrenheit = (RadioButton) findViewById(R.id.CelsiustoFahrenheit);
        againBtn = (Button) findViewById(R.id.againBtn);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getVal.getText().toString().isEmpty())
                {
                    showAns.setText("Please enter the value of temperature");
                }
                else{
                    x = Double.parseDouble(String.valueOf(getVal.getText()));
                   if(Celsiustofahrenheit.isChecked()){
                       x = (x*9)/5+32;
                       x =Double.parseDouble(new DecimalFormat("##.###").format(x));
                       showAns.setText(String.valueOf(x)+"Degree F");
                   }
                   else{
                       showAns.setText("Please Select an Option !");
                   }
                }
            }
        });
againBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        showAns.setText("0.0");
        getVal.setText("");
        Celsiustofahrenheit.setChecked(false);
    }
});

    }
}