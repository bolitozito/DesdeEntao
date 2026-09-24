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

    private int posicaoAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout Home = (LinearLayout) findViewById(R.id.navHome);
        LinearLayout lembram = (LinearLayout) findViewById(R.id.navLembram);
        LinearLayout momentos = (LinearLayout) findViewById(R.id.navMomentos);
        LinearLayout jogo = (LinearLayout) findViewById(R.id.navJogo);

        trocarFragment(new Home(), 0);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new Home(), 0);
            }
        });

        lembram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new Lembram(), 1);
            }
        });

        jogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new JogoFragment(), 3);
            }
        });

        // AINDA NÃO EXISTE - descomenta quando criar a classe Momentos (Fragment)
        /*
        momentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarFragment(new Momentos(), 2);
            }
        });
        */

    }

    public void trocarFragment(Fragment fragment, int novaPosicao) {

        if (novaPosicao > posicaoAtual) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                    )
                    .replace(R.id.container, fragment)
                    .commit();

        } else if (novaPosicao < posicaoAtual) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                    )
                    .replace(R.id.container, fragment)
                    .commit();

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }

        posicaoAtual = novaPosicao;
    }
}