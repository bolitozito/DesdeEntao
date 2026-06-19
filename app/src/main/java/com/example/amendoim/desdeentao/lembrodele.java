package com.example.amendoim.desdeentao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class lembrodele extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrodele);

        ImageView imgMaid = (ImageView) findViewById(R.id.imgMaid);

        imgMaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMaid(v);
            }
        });

        ImageView imgApple = (ImageView) findViewById(R.id.imgApple);

        imgApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onApple(v);
            }
        });

        ImageView imgVenere = (ImageView) findViewById(R.id.imgVenere);

        imgVenere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVenere(v);
            }
        });
    }

    public void onMaid(View view) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Maid Dragon!");
        dialog.setMessage("Você me lembra muito maid dragon, não só pelo fato de você gostar, mas pelo fato de que você me lembra a kobayashi... Engraçadinha e divertida quando quer, mas geralmente séria. Posso estar errado" +
                " ao pensar isso, mas você me fez lembrar de um dos animes que eu mais amei assistir...");

        dialog.setPositiveButton("Fechar textinho!", null);

        dialog.show();
    }

    public void onApple(View view) {

        AlertDialog.Builder apple = new AlertDialog.Builder(this);

        apple.setTitle("Touhou! (Incrivelmente representado por bad apple!!");
        apple.setMessage("Eu sempre soube o que era Touhou, sempre joguei, mas tive reclusão do jogo e de jogos bullet hell minha vida inteira" +
                " mas você me fez lembrar de algo que eu nao percebia a muito tempo. O quanto eu me excluo das coisas pra deixar os outros felizes..." +
                " Se eu pudesse, escutaria você falar de Touhou o dia inteiro, sem te julgar.");

        apple.setPositiveButton("Fechar textinho", null);

        apple.show();
    }

    public void onVenere(View view) {

        AlertDialog.Builder venere = new AlertDialog.Builder(this);

        venere.setTitle("A banda Venere vai Venus | Especificamente a música anjos!");
        venere.setMessage("Essa banda tem um valor sentimental tão grande pra mim! Toda vez que escuto uma música deles, penso em você. Penso" +
                " se você gostaria, penso se você sente o mesmo escutando aquela música...");

        venere.setPositiveButton("Fechar textinho!", null);
        venere.show();
    }

    public void onVoltar(View view) {
        finish();
    }
}
