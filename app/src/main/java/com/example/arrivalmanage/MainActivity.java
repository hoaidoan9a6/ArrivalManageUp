package com.example.arrivalmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decor = this.getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LOW_PROFILE);

        //MENU
        findViewById(R.id.btnArrival).setOnClickListener(this);
        findViewById(R.id.btnMaterial).setOnClickListener(this);
        findViewById(R.id.btnPerformance).setOnClickListener(this);
        findViewById(R.id.btnSetting).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnArrival:

                break;
            case R.id.btnMaterial:

                break;
            case R.id.btnPerformance:

                break;
            case R.id.btnSetting:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            default:

                break;
        }
    }
}