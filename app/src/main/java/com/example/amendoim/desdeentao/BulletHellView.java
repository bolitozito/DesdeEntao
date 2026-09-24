package com.example.amendoim.desdeentao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BulletHellView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // =========================
    // JOGADOR
    // =========================

    private float playerX;
    private float playerY;

    private float playerRadius = 20;


    // =========================
    // BOSS
    // =========================

    private float enemyX;
    private float enemyY;

    private float enemyRadius = 200;

    private float enemySpeed = 3;

    // 1 = direita
    // -1 = esquerda
    private int enemyDirection = 1;

    private Bitmap enemyImage;


    // =========================
    // PROJÉTEIS
    // =========================

    private ArrayList<Bullet> bullets =
            new ArrayList<>();

    private Random random =
            new Random();


    // =========================
    // IMAGENS DOS PROJÉTEIS
    // =========================

    private Bitmap[] imagensBalas = {

            BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.bala_amarela
            ),

            BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.bala_laranja
            ),

            BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.bala_azul
            )

    };


    // =========================
    // PONTUAÇÃO
    // =========================

    private int score = 0;


    // =========================
    // VIDAS
    // =========================

    private int lives = 5;


    // =========================
    // CONTROLE DO JOGO
    // =========================

    private boolean gameOver = false;


    // =========================
    // TEMPO DOS TIROS
    // =========================

    private long lastShotTime = 0;


    // =========================
    // CONSTRUTOR
    // =========================

    public BulletHellView(Context context) {

        super(context);

        paint.setAntiAlias(true);


        // IMAGEM DA BOSS

        enemyImage = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.eminhadomal
        );
    }


    // =========================
    // DESENHAR
    // =========================

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);


        // =========================
        // JOGADOR
        // =========================

        if (playerX == 0 &&
                playerY == 0) {

            playerX = getWidth() / 2f;

            playerY =
                    getHeight() - 120;
        }


        // =========================
        // POSIÇÃO DA BOSS
        // =========================

        if (enemyX == 0) {

            enemyX =
                    getWidth() / 2f;
        }

        enemyY =
                getHeight() / 2f - 80;


        // =========================
        // MOVIMENTO DA BOSS
        // =========================

        enemyX +=
                enemySpeed * enemyDirection;


        // Impede a boss de sair da tela

        if (enemyX + enemyRadius >
                getWidth()) {

            enemyX =
                    getWidth() - enemyRadius;

            enemyDirection = -1;
        }


        if (enemyX - enemyRadius < 0) {

            enemyX =
                    enemyRadius;

            enemyDirection = 1;
        }


        // =========================
        // DESENHAR BOSS
        // =========================

        if (enemyImage != null) {

            RectF destino =
                    new RectF(
                            enemyX - enemyRadius,
                            enemyY - enemyRadius,
                            enemyX + enemyRadius,
                            enemyY + enemyRadius
                    );

            canvas.drawBitmap(
                    enemyImage,
                    null,
                    destino,
                    paint
            );

        } else {

            paint.setColor(
                    Color.rgb(180, 80, 180)
            );

            canvas.drawCircle(
                    enemyX,
                    enemyY,
                    enemyRadius,
                    paint
            );
        }


        // =========================
        // JOGADOR
        // =========================

        paint.setColor(Color.WHITE);

        canvas.drawCircle(
                playerX,
                playerY,
                playerRadius,
                paint
        );


        // =========================
        // PROJÉTEIS
        // =========================

        Iterator<Bullet> iterator =
                bullets.iterator();

        while (iterator.hasNext()) {

            Bullet bullet =
                    iterator.next();


            // Movimento

            bullet.x +=
                    bullet.speedX;

            bullet.y +=
                    bullet.speedY;


            // =========================
            // DESENHAR IMAGEM DA BALA
            // =========================

            if (bullet.image != null) {

                float tamanho =
                        bullet.radius * 2;

                RectF destino =
                        new RectF(
                                bullet.x - bullet.radius,
                                bullet.y - bullet.radius,
                                bullet.x + bullet.radius,
                                bullet.y + bullet.radius
                        );

                canvas.drawBitmap(
                        bullet.image,
                        null,
                        destino,
                        paint
                );

            } else {

                // Caso não tenha imagem

                paint.setColor(
                        bullet.color
                );

                canvas.drawCircle(
                        bullet.x,
                        bullet.y,
                        bullet.radius,
                        paint
                );
            }


            // =========================
            // COLISÃO
            // =========================

            float distanciaX =
                    bullet.x - playerX;

            float distanciaY =
                    bullet.y - playerY;

            float distancia =
                    (float) Math.sqrt(
                            distanciaX * distanciaX +
                                    distanciaY * distanciaY
                    );


            if (distancia <
                    bullet.radius +
                            playerRadius) {

                lives--;

                iterator.remove();


                if (lives <= 0) {

                    gameOver = true;
                }

                continue;
            }


            // =========================
            // REMOVER BALA
            // =========================

            if (bullet.x < -100 ||
                    bullet.x >
                            getWidth() + 100 ||
                    bullet.y < -100 ||
                    bullet.y >
                            getHeight() + 100) {

                iterator.remove();
            }
        }


        // =========================
        // CRIAR PROJÉTEIS
        // =========================

        long agora =
                System.currentTimeMillis();


        if (!gameOver &&
                agora - lastShotTime > 120) {

            criarProjetil();

            lastShotTime =
                    agora;
        }


        // =========================
        // PONTUAÇÃO
        // =========================

        paint.setColor(Color.WHITE);

        paint.setTextSize(45);

        canvas.drawText(
                "Pontos: " + score,
                30,
                60,
                paint
        );


        // =========================
        // VIDAS
        // =========================

        canvas.drawText(
                "Vidas: " + lives,
                30,
                110,
                paint
        );


        // =========================
        // GAME OVER
        // =========================

        if (gameOver) {

            paint.setColor(Color.WHITE);

            paint.setTextSize(65);

            paint.setTextAlign(
                    Paint.Align.CENTER
            );


            canvas.drawText(
                    "GAME OVER",
                    getWidth() / 2f,
                    getHeight() / 2f,
                    paint
            );


            paint.setTextSize(35);


            canvas.drawText(
                    "Toque para jogar novamente",
                    getWidth() / 2f,
                    getHeight() / 2f + 60,
                    paint
            );


            paint.setTextAlign(
                    Paint.Align.LEFT
            );
        }


        // Continua o jogo

        if (!gameOver) {

            invalidate();
        }
    }


    // =========================
    // CRIAR PROJÉTIL
    // =========================

    private void criarProjetil() {


        // =========================
        // DIREÇÃO ALEATÓRIA
        // =========================

        double angulo =
                random.nextDouble()
                        * Math.PI * 2;


        // Velocidade

        float velocidade =
                4 + random.nextFloat() * 3;


        float velocidadeX =
                (float)
                        Math.cos(angulo)
                        * velocidade;


        float velocidadeY =
                (float)
                        Math.sin(angulo)
                        * velocidade;


        // =========================
        // ESCOLHER IMAGEM
        // =========================

        Bitmap imagem =
                imagensBalas[
                        random.nextInt(
                                imagensBalas.length
                        )
                        ];


        // =========================
        // CRIAR BALA
        // =========================

        Bullet bullet =
                new Bullet(
                        enemyX,
                        enemyY,
                        velocidadeX,
                        velocidadeY,
                        imagem
                );


        bullets.add(bullet);


        score++;
    }


    // =========================
    // CONTROLE DO DEDO
    // =========================

    @Override
    public boolean onTouchEvent(
            MotionEvent event) {


        // Reiniciar

        if (gameOver &&
                event.getAction() ==
                        MotionEvent.ACTION_DOWN) {

            lives = 5;

            score = 0;

            bullets.clear();

            gameOver = false;

            invalidate();

            return true;
        }


        // Movimento

        if (event.getAction() ==
                MotionEvent.ACTION_DOWN ||
                event.getAction() ==
                        MotionEvent.ACTION_MOVE) {


            playerX =
                    event.getX();

            playerY =
                    event.getY();


            invalidate();

            return true;
        }


        return true;
    }


    // =========================
    // CLASSE DA BALA
    // =========================

    private static class Bullet {

        float x;
        float y;

        float speedX;
        float speedY;

        float radius = 18;

        int color;

        Bitmap image;


        Bullet(
                float x,
                float y,
                float speedX,
                float speedY,
                Bitmap image
        ) {

            this.x = x;
            this.y = y;

            this.speedX =
                    speedX;

            this.speedY =
                    speedY;

            this.image =
                    image;


            this.color =
                    Color.YELLOW;
        }
    }
}