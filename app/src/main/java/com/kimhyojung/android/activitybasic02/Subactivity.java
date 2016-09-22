package com.kimhyojung.android.activitybasic02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Subactivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        et = (EditText) findViewById(R.id.editText3);
        btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener (){       //new View.O후 엔터치면 자동 완성됨
            @Override
            public void onClick(View v) {
                //에디트텍스트에서 값을 가져온다
                String result = et.getText().toString();
                //인텐트를 생성하고 돌려줄 값을 세팅한다.
                Intent intent = new Intent(Subactivity.this, MainActivity.class);
                intent.putExtra("return1", result);
                intent.putExtra("return2", "결과값2");
                //3. setResult에 결과코드와 데이터를 넘겨준다
                setResult(1, intent);
                //현재 액티비티 종료
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String str = bundle.getString("key1");
        et.setText("key1 = " + str);
    }

}