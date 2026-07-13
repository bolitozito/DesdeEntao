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
        txtCont = view.findViewById(R.id.txtCont);

        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(2026, 2, 9);

        Calendar hoje = Calendar.getInstance();
        long diferenca = hoje.getTimeInMillis() - dataInicio.getTimeInMillis();

        long dias = diferenca / (1000 * 60 * 60 * 24);

        txtCont.setText(String.valueOf(dias));

        Typeface fonte = Typeface.createFromAsset(getActivity().getAssets(), "fonts/dancing.ttf");
        txt1.setTypeface(fonte);
        txt2.setTypeface(fonte);
        txt3.setTypeface(fonte);

        return view;
    }


}

