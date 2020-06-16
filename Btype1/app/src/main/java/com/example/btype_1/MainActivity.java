package com.example.btype_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        final EditText edt2 = (EditText) findViewById(R.id.edt2);
        final EditText edt3 = (EditText) findViewById(R.id.edt3);
        final TextView text1 = (TextView) findViewById(R.id.text1);
        final RadioButton add = (RadioButton) findViewById(R.id.add);
        final RadioButton sub = (RadioButton) findViewById(R.id.sub);
        final RadioButton mul = (RadioButton) findViewById(R.id.mul);
        final RadioButton div = (RadioButton) findViewById(R.id.div);
        Button calBtn = (Button) findViewById(R.id.calBtn);

        calBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edt1.getText().toString());
                double num2 = Double.parseDouble(edt2.getText().toString());
                if(add.isChecked()){
                    text1.setText("+");
                    edt3.setText(Double.toString(num1+num2));
                }
                if(sub.isChecked()){
                    text1.setText("-");
                    edt3.setText(Double.toString(num1-num2));
                }
                if(mul.isChecked()){
                    text1.setText("*");
                    edt3.setText(Double.toString(num1*num2));
                }
                if(div.isChecked()){
                    text1.setText("/");
                    edt3.setText(Double.toString(num1/num2));
                }
            }
        });


    }
}
