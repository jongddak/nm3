package com.example.realnona2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView Userinfoid,Userinfoname,Userinfopw;
    private Button getUserinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Userinfoid = findViewById(R.id.Userinfoid);
        Userinfoname = findViewById(R.id.Userinfoname);
        Userinfopw = findViewById(R.id.Userinfopw);
        getUserinfo = findViewById(R.id.getUserinfo);


        Intent intent = getIntent();
        final String data1 = intent.getStringExtra("UserEmail");
        final String data2 = intent.getStringExtra("UserPwd");
        final String data3 = intent.getStringExtra("UserName");


        getUserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Userinfoid.setText(data1);
                Userinfoname.setText(data2);
                Userinfopw.setText(data3);
            }
        });



    }
}