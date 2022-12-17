package com.example.arrivalmanage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decor = this.getWindow().getDecorView();
        UIHelper.hideNavigationBar(decor);
        //MENU
        findViewById(R.id.btnArrival).setOnClickListener(this);
        findViewById(R.id.btnMaterial).setOnClickListener(this);
        findViewById(R.id.btnPerformance).setOnClickListener(this);
        findViewById(R.id.btnSetting).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnArrival) {
            Intent intent = new Intent(this, ArrivalActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnMaterial) {
        } else if (id == R.id.btnPerformance) {
        } else if (id == R.id.btnSetting) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
    }
}