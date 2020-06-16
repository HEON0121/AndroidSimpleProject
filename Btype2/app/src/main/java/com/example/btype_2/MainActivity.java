package com.example.btype_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String eng = "";
    String read = "";
    String workout = "";
    String coding = "";
    String sleeping = "";
    String idealtype = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //먼저 영어~
        final EditText edtEng = (EditText) findViewById(R.id.englishTime);
        // 자는 시간~
        final EditText edtSleep = (EditText) findViewById(R.id.sleepTime);
        // 운동~
        final EditText edtWorkout = (EditText) findViewById(R.id.workoutTime);
        // 코딩~
        final EditText edtCoding = (EditText) findViewById(R.id.codingTime);
        //독서~
        final EditText edtReading = (EditText) findViewById(R.id.readingTime);
        //체크박스
        final CheckBox chEnglish = (CheckBox) findViewById(R.id.chEnglish);
        final CheckBox chCoding = (CheckBox) findViewById(R.id.chCoding);
        final CheckBox chWorkout = (CheckBox) findViewById(R.id.chWorkout);
        final CheckBox chReading = (CheckBox) findViewById(R.id.chReading);
        // 아래 결과 텍스트 3줄
        final TextView text1 = (TextView)findViewById(R.id.text1);
        final TextView text2 = (TextView)findViewById(R.id.text2);
        final TextView text3 = (TextView)findViewById(R.id.text3);
        final Button btnResult = (Button)findViewById(R.id.btnResult);
        //스피너 만들기
        // 배열 먼저 만들고
        // 스피너 객체 만들고
        // 어레이 어댑터 객체 만들고 둘 쓰까
        // 다시 스피너에 어댑터 셋
        final String [] idealArray = {"Appearance(외모)","Ability(능력)","Personality(성격)","Lineage(가문)","Faith(신앙)"};
        final Spinner spinner = (Spinner) findViewById(R.id.idealType);
        ArrayAdapter<String>adpater;
        adpater = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, idealArray);
        spinner.setAdapter(adpater);
        // 이상형 선택
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idealtype = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지 아이디 목록
                ArrayList<Integer>imgID = new ArrayList<>();

                int aSleep = 0; //잠자기
                int aCoding = 0; //코딩
                int aReading = 0; //독서
                int aEnglish = 0; // 영어
                int aWorkout = 0; // 운동
                int sum = 0;

                if(edtSleep.getText().toString().equals("")) {
                    text1.setText("1.나는 ? 시간 잠을 잡니다.");
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("수면 시간")
                            .setView(getLayoutInflater().inflate(R.layout.imageview, null))
                            .show();


                }else{
                    String sSleep = edtSleep.getText().toString();
                    aSleep = Integer.parseInt(sSleep);
                    text1.setText("1.나는"+aSleep+"시간 잠을 잡니다.");
                }if(chCoding.isChecked()){
                    String sCoding = edtCoding.getText().toString();
                    aCoding = Integer.parseInt(sCoding);
                    imgID.add(R.drawable.programming);
                }if(chReading.isChecked()){
                    String sReading = edtReading.getText().toString();
                    aReading = Integer.parseInt(sReading);
                    imgID.add(R.drawable.book_reading);
                }if(chEnglish.isChecked()){
                    String sEnglish = edtEng.getText().toString();
                    aEnglish = Integer.parseInt(sEnglish);
                    imgID.add(R.drawable.engligh_study);
                }if(chWorkout.isChecked()){
                    String sWorkout = edtWorkout.getText().toString();
                    aWorkout = Integer.parseInt(sWorkout);
                    imgID.add(R.drawable.work_out);
                }
                sum = aCoding + aEnglish + aReading + aWorkout;
                text2.setText("나는 꿈을 위해 " + sum + "시간을 투자합니다.");
                text3.setText("3.나의 이상형은"+idealtype+"입니다!");



                GridView gridView = (GridView) findViewById(R.id.gridView);
                gridView.setAdapter(new ImageAdapter(MainActivity.this, imgID));


            }
        });
    }
}
