package org.techtown.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // main 함수처럼 onCreate() 함수가 시작점의 역할
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setContentView : 화면에 무엇을 보여줄 것인지 설정해주는 역할
        // R.layout.activity_main : 화면의 구성 요소에 대한 정보
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    public void onButton1Clicked(View v) {
        Toast.makeText(this, "확인1 버튼이 눌렸어요.", Toast.LENGTH_LONG).show(); // Toast : 작고 간단한 메시지를 잠깐 보여주는 역할
    }

    public void onButton2Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void onButton3Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(myIntent);
    }

    // 인텐트가 기존 언어에서는 보기 힘든 기능인 네이버 사이트 접속, 전화 걸기 등을 가능케 한다.
    // 인텐트는 내가 하고자 하는 행위를 의미한다. (안드로이드 플랫폼에게 원하는 것을 말할 때 전달하는 우편물 같은 것)
}
