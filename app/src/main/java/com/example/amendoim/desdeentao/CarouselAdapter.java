package com.example.amendoim.desdeentao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;




public class CarouselAdapter extends PagerAdapter {

    private Typeface fonteT;

    private Context context;

    private MediaPlayer mediaPlayer;


    private int[] imagens = {
            R.drawable.maiddragon,
            R.drawable.badapple,
            R.drawable.venere,
            R.drawable.cycm,
            R.drawable.amorpuro,
            R.drawable.ll,
            R.drawable.partilhar,
            R.drawable.sinaisdefogo,
            R.drawable.umamusume
    };
    private String[] titulos = {
            "Maid Dragon",
            "Bad Apple",
            "Vênere",
            "Catch You, Catch Me!",
            "Amor Puro",
            "Legendary Lovers",
            "Partilhar",
            "Sinais de Fogo",
            "Uma Musume!"
    };

    private int[] audios = {
            0,
            0,
            0,
            R.raw.cycm,
            R.raw.amorpuro,
            R.raw.ll,
            R.raw.partilhar,
            R.raw.sinaisdefogo,
            0,
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

        if (audios[position] != 0) {
            final int audioResId = audios[position];
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abrirDialogMusica(audioResId);
                }
            });
        }

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

    private void abrirDialogMusica(int audioResId) {
        View dialogView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_music, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        builder.setCancelable(true);

        final AlertDialog dialog = builder.create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        dialog.show();

        final Button btnPlayPause = (Button) dialogView.findViewById(R.id.btnPlayPause);
        Button btnParar = (Button) dialogView.findViewById(R.id.btnPararMusica);

        mediaPlayer = MediaPlayer.create(context, audioResId);
        mediaPlayer.start();

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlayPause.setText("▶ Tocar");
                } else {
                    mediaPlayer.start();
                    btnPlayPause.setText("⏸ Pausar");
                }
            }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararMusica();
                dialog.dismiss();
            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                pararMusica();
            }
        });
    }

    private void pararMusica() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}