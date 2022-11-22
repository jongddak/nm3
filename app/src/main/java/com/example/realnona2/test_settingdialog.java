package com.example.cap3;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class test_settingdialog extends AppCompatActivity {
    int nCurrentPermission = 0;
    static final int PERMISSIONS_REQUEST=0x0000001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_f_setting_dialog_btn);
        ToggleButton location_btn=findViewById(R.id.location_btn);

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((ToggleButton)v).isChecked();
                if(checked){

                }else{
                    OnCheckPermission();
                }
            }
        });

    }

    private void OnCheckPermission() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) !=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                Toast.makeText(this,"앱 실행을 위해서는 권한을 설정해야합니다",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},PERMISSIONS_REQUEST);
            }else{
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},PERMISSIONS_REQUEST);
            }
        }
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requstCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requstCode, permissions, grantResults);
        switch (requstCode) {
            case PERMISSIONS_REQUEST:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "앱 실행을 위한 권한이 설정 되었습니다.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "앱 실행을 위한 권한이 취소 되었습니다.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }



}