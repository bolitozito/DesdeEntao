package com.example.amendoim.desdeentao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;
import android.view.View;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout Home = (LinearLayout) findViewById(R.id.navHome);
        LinearLayout lembram = (LinearLayout) findViewById(R.id.navLembram);
        LinearLayout momentos = (LinearLayout) findViewById(R.id.navMomentos);
        LinearLayout cartinhas = (LinearLayout) findViewById(R.id.navCartas);

        trocarFragment(new Home());

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new Home());
            }
        });

        lembram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new Lembram());
            }
        });

    } // ← O onCreate termina AQUI

    public void trocarFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }
}