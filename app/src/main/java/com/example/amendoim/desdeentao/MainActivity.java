package com.example.amendoim.desdeentao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView txtCont;
    Intent tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCont = (TextView) findViewById(R.id.txtCont);

        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(2026,02,9);

        Calendar hoje = Calendar.getInstance();
        long diferenca = hoje.getTimeInMillis() - dataInicio.getTimeInMillis();

        long dias = diferenca / (1000 * 60 * 60 * 24);

        txtCont.setText("O tchan rolou a " + dias + " dias! \uD83D\uDC9C");
    }

    public void onLembrar(View view) {
        tela = new Intent(getApplicationContext(),lembrodele.class);
        startActivity(tela);
    }

    public void onMomentos(View view) {
        tela = new Intent(getApplicationContext(),momentos.class);
        startActivity(tela);
    }

    public void onCartinhas(View view) {
        tela = new Intent(getApplicationContext(),cartinhas.class);
        startActivity(tela);
    }
}
