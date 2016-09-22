package com.kimhyojung.android.activitybasic02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener (){       //new View.O후 엔터치면 자동 완성됨
            @Override
            public void onClick(View v) {
                //------------------------
                Intent intent = new Intent(MainActivity.this, Subactivity.class);

                String str = et.getText().toString();

                intent.putExtra("key1", str);
                intent.putExtra("key2","홍길동");
                intent.putExtra("key3",10000);
                startActivityForResult(intent, 0);
                //-------------------------
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Send 버튼이 호출 했었던거에요
        if(requestCode == 0)
            if(resultCode == 1){
                Bundle bundle = data.getExtras();
                String result = bundle.getString("return1");
                et.setText(result);
            }
    }
}
