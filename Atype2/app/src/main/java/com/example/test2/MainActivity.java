package com.example.test2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String blood = "";
    String gender = "";
    String height = "";
    String weight = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("101분반 2번");

        //성별 체크
        final RadioGroup genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.female){
                     gender = "여자";
                }
                else if(checkedId == R.id.male){
                     gender = "남자";
                }
            }

        });
        //혈액형 스피너
        final String[] bloodArray = {"A형","B형","O형","AB형"};
        final Spinner spinner = (Spinner)findViewById(R.id.bloodType);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, bloodArray);
        spinner.setAdapter(adapter);
        //혈액형 선택
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            blood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //체크박스
        final CheckBox chDrinking = (CheckBox) findViewById(R.id.chDrinking);
        final CheckBox chSmoking = (CheckBox) findViewById(R.id.chSmoking);
        final CheckBox chWorkout = (CheckBox) findViewById(R.id.chWorkout);
//  검사하기 버튼

        Button check = (Button) findViewById(R.id.check);

        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //키 입력값
                final EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
                height = edtHeight.getText().toString();
                //무게 입력값
                final EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
                weight = edtWeight.getText().toString();
                //체크박스 흡연 운동 음주 입력값
                ArrayList<Integer>habit = new ArrayList<>();
                if(edtHeight.getText().toString().equals("")||edtWeight.getText().toString().equals("")){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("키와 체중");
                    dlg.setMessage("키와 체중을 넣어주세요!");
                    dlg.setIcon(R.drawable.weight);
                    dlg.show();
                }else {
                    text1.setText("1."+ blood +" "+ gender + "입니다!");
                    text2.setText("2. 신체질량 지수는 " + Float.parseFloat(weight)/(((Float.parseFloat(height))/100)*2)+ " 입니다.");
                }
                if(chDrinking.isChecked()){
                    //ArrayList 배열에 클릭한 이미지 넣기
                    habit.add(R.drawable.drinking);
                }
                if(chSmoking.isChecked()){
                    habit.add(R.drawable.ciga);
                }
                if(!chWorkout.isChecked()){
                    habit.add(R.drawable.running);
                }
                Gallery gallery = (Gallery) findViewById(R.id.img);
                if(chDrinking.isChecked() || chSmoking.isChecked()||!chWorkout.isChecked())
                {
                    gallery.setAdapter(new ImageAdapter(MainActivity.this, habit));
                }
                else
                    {
                        gallery.removeAllViewsInLayout();
                    }
            }
        });





    }
}
