package com.example.amendoim.desdeentao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class momentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momentos);
    }


    public void onVoltar(View view) {
        finish();
    }
}
