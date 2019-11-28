package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // define spinner
    Spinner sp;

    TextView display_data;

    // make string Array
    String names[] = {"Red", "Blue", "Green"};

    // define array adapter of string type
    ArrayAdapter <String> adapter;

    // define string variable for record
    String record = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        display_data = (TextView)findViewById(R.id.display_result);

        // set adapter to spinner
        sp.setAdapter(adapter);

        // set spinner method
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // use position value
                switch (position)
                {
                    case 0:
                        record = "Red";
                        break;

                    case 1:
                        record = "Blue";
                        break;

                    case 2:
                        record = "Green";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    // set display button click to show result

    public void displayResult(View view){
        display_data.setTextSize(18);
        display_data.setText(record);
    }
}
