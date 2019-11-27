package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // main 함수처럼 onCreate() 함수가 시작점의 역할
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setContentView : 화면에 무엇을 보여줄 것인지 설정해주는 역할
        // R.layout.activity_main : 화면의 구성 요소에 대한 정보

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cvs_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.item_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(this, R.array.plus_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button btn_map =  findViewById(R.id.button2);
        btn_map.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // 인텐트가 기존 언어에서는 보기 힘든 기능인 네이버 사이트 접속, 전화 걸기 등을 가능케 한다.
    // 인텐트는 내가 하고자 하는 행위를 의미한다. (안드로이드 플랫폼에게 원하는 것을 말할 때 전달하는 우편물 같은 것)
}
