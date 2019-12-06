package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;

    String names[] = {"편의점 전체", "GS25(지에스25)", "CU(씨유)", "7-ELEVEN(세븐일레븐)", "EMART24(이마트24)", "MINISTOP(미니스톱)"};
    String names2[] = {"상품 분류 전체", "음료", "과자류", "식품", "아이스크림", "생활용품"};
    String names3[] = {"플러스 전체", "1+1", "2+1", "3+1", "4+1"};

    // define array adapter of string type
    ArrayAdapter <String> adapter;
    ArrayAdapter <String> adapter2;
    ArrayAdapter <String> adapter3;

    // define string variable for record
    public static String record = ""; // cvs
    public static String record2 = ""; // category
    public static String record3 = ""; // plus

    public static EditText productName;
    public static String name; // product_name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        spinner2 = findViewById(R.id.spinner2);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names2);

        spinner3 = findViewById(R.id.spinner3);
        adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names3);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        productName = findViewById(R.id.editText);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // use position value
                switch (position)
                {
                    case 0:
                        record = names[0];
                        break;

                    case 1:
                        record = names[1];
                        break;

                    case 2:
                        record = names[2];
                        break;

                    case 3:
                        record = names[3];
                        break;

                    case 4:
                        record = names[4];
                        break;

                    case 5:
                        record = names[5];
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // use position value
                switch (position)
                {
                    case 0:
                        record2 = names2[0];
                        break;

                    case 1:
                        record2 = names2[1];
                        break;

                    case 2:
                        record2 = names2[2];
                        break;

                    case 3:
                        record2 = names2[3];
                        break;

                    case 4:
                        record2 = names2[4];
                        break;

                    case 5:
                        record2 = names2[5];
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // use position value
                switch (position)
                {
                    case 0:
                        record3 = names3[0];
                        break;

                    case 1:
                        record3 = names3[1];
                        break;

                    case 2:
                        record3 = names3[2];
                        break;

                    case 3:
                        record3 = names3[3];
                        break;

                    case 4:
                        record3 = names3[4];
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

        Button btn_db =  findViewById(R.id.button);
        btn_db.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ListActivity.class);
                        name = productName.getText().toString();
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
