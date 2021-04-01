package com.example.gorisfiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void clickrumahsakit(View view){
        //gambar RS di click
        Intent r = new Intent(this,Rs.class);
        startActivity(r);
    }
}