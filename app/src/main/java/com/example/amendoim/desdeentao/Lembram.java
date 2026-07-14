package com.example.amendoim.desdeentao;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;


public class Lembram extends Fragment {

    TextView titulo;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lembram,
                container,
                false);
        titulo = view.findViewById(R.id.txtT);
        Typeface fonte = Typeface.createFromAsset(getActivity().getAssets(), "fonts/dancing.ttf");
        titulo.setTypeface(fonte);
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewPager);

        CarouselAdapter adapter = new CarouselAdapter(getContext());

        pager.setAdapter(adapter);

        return view;
    }

}