package com.example.amendoim.desdeentao;

import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class CarouselAdapter extends PagerAdapter {

    private Typeface fonteT;

    private Context context;



    private int[] imagens = {
            R.drawable.maiddragon,
            R.drawable.badapple,
            R.drawable.venere,
    };
    private String[] titulos = {
            "Maid Dragon",
            "Bad Apple",
            "Vênere"
    };

    private String[] descricoes = {
            "A Tohru e a Kobayashi me lembram que todo romance é possivel, inclusive o nosso!",
            "Me lembra o quanto vc ama touhou, e também pq é minha música favorita (por enquanto hihi)!",
            "Porque toda vez que escuto, lembro de você."
    };

    public CarouselAdapter(Context context){
        this.context = context;

        fonteT = Typeface.createFromAsset(context.getAssets(), "fonts/dancing.ttf");
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.carrousel, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.imgCarousel);

        img.setImageResource(imagens[position]);

        container.addView(view);

        TextView titulo = (TextView) view.findViewById(R.id.txtTitulo);

        titulo.setTypeface(fonteT);

        titulo.setText(titulos[position]);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }
}