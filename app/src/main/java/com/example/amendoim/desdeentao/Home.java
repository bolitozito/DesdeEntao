package com.example.amendoim.desdeentao;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;


public class Home extends Fragment {

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txtCont;
    TextView txtMensagem;

    public Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt3 = view.findViewById(R.id.txt3);
        txtMensagem = view.findViewById(R.id.txtMensagem);
        txtCont = view.findViewById(R.id.txtCont);

        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(2026, 2, 9);

        Calendar hoje = Calendar.getInstance();
        long diferenca = hoje.getTimeInMillis() - dataInicio.getTimeInMillis();

        long dias = diferenca / (1000 * 60 * 60 * 24);

        txtCont.setText(String.valueOf(dias));

        Typeface fonte = Typeface.createFromAsset(getActivity().getAssets(), "fonts/dancing.ttf");
        Typeface fonte1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/hoollidday.ttf");
        Typeface fonte2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/poppins.regular.ttf");
        txt1.setTypeface(fonte);
        txt2.setTypeface(fonte1);
        txt3.setTypeface(fonte1);
        txtMensagem.setTypeface(fonte2);


        String[] mensagens = {

                "❝ Bom dia! Espero que hoje você sorria bastante.💜 ❞",

                "❝ Se hoje estiver difícil, lembra que alguém torce muito por você. ❞",

                "❝ Você passou pela minha cabeça hoje... como em todos os outros dias. ❞",

                "❝ Espero que hoje você encontre um motivo para rir. ❞",

                "❝ Você merece tudo de bom que esse mundo pode oferecer. ❞",

                "❝ Mesmo longe, estou pensando em você. ❞",

                "❝ Espero que essa mensagem tenha conseguido arrancar um sorrisinho seu. ❞",

                "❝ Você é uma das melhores partes dos meus dias. ❞",

                "❝ Hoje é mais um dia em que gosto de você. ❞",

                "❝ Você consegue tudo o que colocar na cabeça. Eu acredito em você. ❞"

        };

        Calendar calendar = Calendar.getInstance();

        int dia = calendar.get(Calendar.DAY_OF_YEAR);
        int indice = dia % mensagens.length;

        txtMensagem.setText(mensagens[indice]);
        return view;
    }



}

