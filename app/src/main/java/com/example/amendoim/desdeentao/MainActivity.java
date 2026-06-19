package com.example.amendoim.desdeentao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtCont;
    Intent tela;
    int cliqueSec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCont = (TextView) findViewById(R.id.txtCont);

        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(2026, 2, 9);

        Calendar hoje = Calendar.getInstance();
        long diferenca = hoje.getTimeInMillis() - dataInicio.getTimeInMillis();

        long dias = diferenca / (1000 * 60 * 60 * 24);

        txtCont.setText("O tchan rolou a " + dias + " dias! \uD83D\uDC9C");

        TextView cantoSec = (TextView) findViewById(R.id.cantoSecreto);

        cantoSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cliqueSec++;

                if (cliqueSec == 10) {
                    Toast.makeText(MainActivity.this,
                            "Você achou um segredinho ♥",
                            Toast.LENGTH_SHORT).show();

                    cliqueSec = 0;
                }
            }
        });
    }

    public void onLembrar(View view) {
        tela = new Intent(getApplicationContext(), lembrodele.class);
        startActivity(tela);
    }

    public void onMomentos(View view) {
        tela = new Intent(getApplicationContext(), momentos.class);
        startActivity(tela);
    }

    public void onCartinhas(View view) {
        tela = new Intent(getApplicationContext(), cartinhas.class);
        startActivity(tela);
    }
}