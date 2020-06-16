package com.example.atype_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    EditText edt3;
    Button random;
    Button answer;
    ListView gugudanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("101분반 1번");
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.result);
        random = (Button) findViewById(R.id.random);
        answer = (Button) findViewById(R.id.answer);
        gugudanList = (ListView) findViewById(R.id.gugudanList);
        random.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                     final int random1 = new Random().nextInt(8)+2;
                     final int random2 = new Random().nextInt(8)+2;
                     edt1.setText(Integer.toString(random1));
                     edt2.setText(Integer.toString(random2));
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(edt3.getText().toString()) == (Integer.parseInt(edt1.getText().toString()) * Integer.parseInt(edt2.getText().toString()))) {
                    Toast.makeText(MainActivity.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(edt3.getText().toString())!=(Integer.parseInt(edt1.getText().toString()) * Integer.parseInt(edt2.getText().toString()))){
                    Toast.makeText(MainActivity.this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
                    final String[] gugudan = new String[9];
                    for(int i=0; i<9; i++) {
                        gugudan[i]=edt1.getText().toString() + "X" + (i+1) + "=" + (Integer.parseInt(edt1.getText().toString()))*(i+1);
                        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, gugudan);
                        gugudanList.setAdapter(adapter);

                    }
                }
            }
        });

    }
}
