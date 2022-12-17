package com.example.arrivalmanage;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ArrivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);

        View decor = this.getWindow().getDecorView();
        UIHelper.hideNavigationBar(decor);
    }
}


