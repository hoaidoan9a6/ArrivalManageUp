package com.example.arrivalmanage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences data;

    //KEY
    private String PREFERENCES_BLUETOOTH_ADDRESS = "";
    private String PREFERENCES_URL = "";
    private String PREFERENCES_USERNAME = "";
    private String PREFERENCES_PASSWORD = "";
    //VALUE
    private String DEFAULT_BLUETOOTH_ADDRESS = "";
    private String DEFAULT_URL = "";
    private String DEFAULT_USERNAME = "";
    private String DEFAULT_PASSWORD = "";

    private void getInitKeyValue() {
        //KEY
        PREFERENCES_BLUETOOTH_ADDRESS = getResources().getString(R.string.BTAddress_Key);
        PREFERENCES_URL = getResources().getString(R.string.URL_key);
        PREFERENCES_USERNAME = getResources().getString(R.string.Username_key);
        PREFERENCES_PASSWORD = getResources().getString(R.string.Password_key);
        //VALUE
        DEFAULT_BLUETOOTH_ADDRESS = getResources().getString(R.string.BTAddress_value);
        DEFAULT_URL = getResources().getString(R.string.URL_value);
        DEFAULT_USERNAME = getResources().getString(R.string.Username_value);
        DEFAULT_PASSWORD = getResources().getString(R.string.Password_value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        View decor = this.getWindow().getDecorView();
        UIHelper.hideNavigationBar(decor);

        //SETTING
        findViewById(R.id.btnSettingBack).setOnClickListener(this);
        findViewById(R.id.btnSettingSave).setOnClickListener(this);

        getInitKeyValue();

        data = getSharedPreferences("Data", MODE_PRIVATE);
        loadSetting();
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        int id = view.getId();
        if (id == R.id.btnSettingBack) {
            startActivity(intent);
        } else if (id == R.id.btnSettingSave) {
            saveSetting();
            Snackbar.make(view, "????????????????????????????????????", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //DELAY
            new Handler().postDelayed(() -> {
                //BACK MENU
                startActivity(intent);
            }, 1000);
        }
    }

    private void saveSetting() {
        // ??????
        data = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();

        TextInputEditText txtBTAddress = findViewById(R.id.txtBTAddress);
        TextInputEditText txtURL = findViewById(R.id.txtURL);
        TextInputEditText txtUsername = findViewById(R.id.txtUsername);
        TextInputEditText txtPassword = findViewById(R.id.txtPassword);

        editor.putString(PREFERENCES_BLUETOOTH_ADDRESS, String.valueOf(txtBTAddress.getText()));
        editor.putString(PREFERENCES_URL, String.valueOf(txtURL.getText()));
        editor.putString(PREFERENCES_USERNAME, String.valueOf(txtUsername.getText()));
        editor.putString(PREFERENCES_PASSWORD, String.valueOf(txtPassword.getText()));

//        editor.commit();
        editor.apply();
    }

    private void loadSetting() {

        TextInputEditText txtBTAddress = findViewById(R.id.txtBTAddress);
        txtBTAddress.setText(data.getString(PREFERENCES_BLUETOOTH_ADDRESS, DEFAULT_BLUETOOTH_ADDRESS));

        TextInputEditText txtURL = findViewById(R.id.txtURL);
        txtURL.setText(data.getString(PREFERENCES_URL, DEFAULT_URL));

        TextInputEditText txtUsername = findViewById(R.id.txtUsername);
        txtUsername.setText(data.getString(PREFERENCES_USERNAME, DEFAULT_USERNAME));

        TextInputEditText txtPassword = findViewById(R.id.txtPassword);
        txtPassword.setText(data.getString(PREFERENCES_PASSWORD, DEFAULT_PASSWORD));

    }

}