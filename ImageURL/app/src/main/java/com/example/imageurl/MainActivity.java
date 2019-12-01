package com.example.imageurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView image1;
    String url = "http://cdn2.bgfretail.com/bgfbrand/files/product/8801046860458.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.imgURL);
        Picasso.get().load(url).into(image1);

    }
}