package com.example.arrivalmanage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ArrivalActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST_CODE = 1888;

    ImageButton igmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);

        View decor = this.getWindow().getDecorView();
        UIHelper.hideNavigationBar(decor);

        igmBtn = findViewById(R.id.imageBtn_Label);

        findViewById(R.id.imageBtn_Label).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bitmap imgBitmap = (Bitmap) data.getExtras().get("data");
            igmBtn.setImageBitmap(imgBitmap);
        }
        View decor = this.getWindow().getDecorView();
        UIHelper.hideNavigationBar(decor);
    }
}


