package com.example.amendoim.desdeentao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BulletHellView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // ==========================================
    // JOGADOR
    // ==========================================

    private float playerX;
    private float playerY;

    private float playerRadius = 20;


    // ==========================================
    // BOSS
    // ==========================================

    private float enemyX;
    private float enemyY;

    private float enemyRadius = 200;

    private float enemySpeed = 3;
    private int enemyDirection = 1;

    private Bitmap enemyImage;


    // ==========================================
    // PROJÉTEIS
    // ==========================================

    private ArrayList<Bullet> bullets = new ArrayList<>();

    private Random random = new Random();

    // Imagens das balas
    private Bitmap[] imagensBalas;


    // ==========================================
    // PONTUAÇÃO
    // ==========================================

    private int score = 0;


    // ==========================================
    // VIDAS
    // ==========================================

    private int lives = 5;


    // ==========================================
    // CONTROLE DO JOGO
    // ==========================================

    private boolean gameOver = false;

    private long lastShotTime = 0;

    private long tempoInicio = 0;

    private int nivel = 1;


    // ==========================================
    // CONSTRUTOR
    // ==========================================

    public BulletHellView(Context context) {
        super(context);

        paint.setAntiAlias(true);

        // Imagem do boss
        enemyImage = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.eminhadomal
        );

        // Imagens das balas
        imagensBalas = new Bitmap[] {

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

        // Começa a contar o tempo do jogo
        tempoInicio = System.currentTimeMillis();

        // Deixa a View transparente
        setBackgroundColor(Color.TRANSPARENT);
    }


    // ==========================================
    // DESENHAR O JOGO
    // ==========================================

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        // Não pinta o fundo de preto
        canvas.drawColor(Color.TRANSPARENT);


        // ==========================================
        // POSIÇÃO INICIAL DO JOGADOR
        // ==========================================

        if (playerX == 0 && playerY == 0) {

            playerX = getWidth() / 2f;

            playerY = getHeight() - 120;
        }


        // ==========================================
        // POSIÇÃO INICIAL DO BOSS
        // ==========================================

        if (enemyX == 0) {

            enemyX = getWidth() / 2f;

            enemyY = getHeight() / 2f - 50;
        }


        // ==========================================
        // SE O JOGO ACABOU
        // ==========================================

        if (gameOver) {

            desenharGameOver(canvas);

            return;
        }


        // ==========================================
        // CALCULAR NÍVEL
        // ==========================================

        long tempoAtual = System.currentTimeMillis();

        long tempoPassado =
                tempoAtual - tempoInicio;


        // A cada 10 segundos aumenta 1 nível
        nivel = 1 + (int) (tempoPassado / 10000);


        // ==========================================
        // MOVIMENTO DO BOSS
        // ==========================================

        enemyX += enemySpeed * enemyDirection;


        // Limite esquerdo
        if (enemyX - enemyRadius < 0) {

            enemyX = enemyRadius;

            enemyDirection = 1;
        }


        // Limite direito
        if (enemyX + enemyRadius > getWidth()) {

            enemyX = getWidth() - enemyRadius;

            enemyDirection = -1;
        }


        // ==========================================
        // DESENHAR BOSS
        // ==========================================

        if (enemyImage != null) {

            float tamanho = enemyRadius * 2;

            android.graphics.RectF destino =
                    new android.graphics.RectF(
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
        }


        // ==========================================
        // DESENHAR JOGADOR
        // ==========================================

        paint.setColor(Color.WHITE);

        canvas.drawCircle(
                playerX,
                playerY,
                playerRadius,
                paint
        );


        // ==========================================
        // CRIAR PROJÉTEIS
        // ==========================================

        // Quanto maior o nível,
        // menor o intervalo entre as balas.

        long intervalo = Math.max(
                50,
                180 - (nivel * 15)
        );


        if (System.currentTimeMillis() - lastShotTime
                > intervalo) {

            criarProjetil();

            lastShotTime =
                    System.currentTimeMillis();
        }


        // ==========================================
        // ATUALIZAR PROJÉTEIS
        // ==========================================

        Iterator<Bullet> iterator =
                bullets.iterator();


        while (iterator.hasNext()) {

            Bullet bullet = iterator.next();


            // Movimento da bala
            bullet.x += bullet.speedX;

            bullet.y += bullet.speedY;


            // ======================================
            // DESENHAR BALA
            // ======================================

            if (bullet.image != null) {

                float tamanho =
                        bullet.radius * 2;


                android.graphics.RectF destino =
                        new android.graphics.RectF(
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

                // Caso a imagem não exista,
                // desenha uma bolinha.

                paint.setColor(bullet.color);

                canvas.drawCircle(
                        bullet.x,
                        bullet.y,
                        bullet.radius,
                        paint
                );
            }


            // ======================================
            // COLISÃO COM O JOGADOR
            // ======================================

            float dx =
                    bullet.x - playerX;

            float dy =
                    bullet.y - playerY;


            float distancia =
                    (float) Math.sqrt(
                            dx * dx + dy * dy
                    );


            if (distancia <
                    bullet.radius + playerRadius) {

                lives--;

                iterator.remove();


                // Se acabou as vidas
                if (lives <= 0) {

                    gameOver = true;
                }
            }


            // ======================================
            // REMOVER BALA FORA DA TELA
            // ======================================

            if (bullet.x < -100 ||
                    bullet.x > getWidth() + 100 ||
                    bullet.y < -100 ||
                    bullet.y > getHeight() + 100) {

                iterator.remove();
            }
        }


        // ==========================================
        // HUD
        // ==========================================

        desenharHUD(canvas);


        // ==========================================
        // CONTINUAR ANIMANDO
        // ==========================================

        invalidate();
    }


    // ==========================================
    // CRIAR PROJÉTIL
    // ==========================================

    private void criarProjetil() {


        // ==========================================
        // DIREÇÃO ALEATÓRIA
        // ==========================================

        double angulo =
                random.nextDouble()
                        * Math.PI
                        * 2;


        // ==========================================
        // VELOCIDADE
        // ==========================================

        float velocidade =
                4
                        + random.nextFloat() * 3
                        + (nivel * 0.5f);


        float velocidadeX =
                (float) Math.cos(angulo)
                        * velocidade;


        float velocidadeY =
                (float) Math.sin(angulo)
                        * velocidade;


        // ==========================================
        // ESCOLHER IMAGEM ALEATÓRIA
        // ==========================================

        Bitmap imagem = null;


        if (imagensBalas != null &&
                imagensBalas.length > 0) {

            imagem =
                    imagensBalas[
                            random.nextInt(
                                    imagensBalas.length
                            )
                            ];
        }


        // ==========================================
        // CORES
        // ==========================================

        int[] cores = {

                Color.YELLOW,

                Color.rgb(
                        255,
                        140,
                        0
                ),

                Color.CYAN,

                Color.BLUE,

                Color.MAGENTA
        };


        int cor =
                cores[
                        random.nextInt(
                                cores.length
                        )
                        ];


        // ==========================================
        // TAMANHO DA BALA
        // ==========================================

        // Começa grande e fica ainda maior
        // conforme o nível aumenta.

        float tamanho =
                28 + (nivel * 0.5f);


        // ==========================================
        // CRIAR BALA
        // ==========================================

        Bullet bullet =
                new Bullet(
                        enemyX,
                        enemyY,
                        velocidadeX,
                        velocidadeY,
                        tamanho,
                        cor,
                        imagem
                );


        bullets.add(bullet);


        // Pontuação
        score++;
    }


    // ==========================================
    // DESENHAR HUD
    // ==========================================

    private void desenharHUD(Canvas canvas) {


        paint.setColor(Color.WHITE);

        paint.setTextSize(32);

        paint.setTypeface(
                android.graphics.Typeface.DEFAULT_BOLD
        );


        // Vidas
        canvas.drawText(
                "❤ " + lives,
                25,
                45,
                paint
        );


        // Pontuação
        canvas.drawText(
                "Pontos: " + score,
                25,
                85,
                paint
        );


        // Nível
        canvas.drawText(
                "Nível: " + nivel,
                25,
                125,
                paint
        );
    }


    // ==========================================
    // GAME OVER
    // ==========================================

    private void desenharGameOver(Canvas canvas) {


        // Fundo escuro transparente
        paint.setColor(
                Color.argb(
                        180,
                        0,
                        0,
                        0
                )
        );


        canvas.drawRect(
                0,
                0,
                getWidth(),
                getHeight(),
                paint
        );


        // Texto principal
        paint.setColor(Color.WHITE);

        paint.setTextSize(60);

        paint.setTypeface(
                android.graphics.Typeface.DEFAULT_BOLD
        );


        String texto =
                "GAME OVER";


        float largura =
                paint.measureText(texto);


        canvas.drawText(
                texto,
                (getWidth() - largura) / 2,
                getHeight() / 2f,
                paint
        );


        // Pontuação
        paint.setTextSize(30);


        String pontos =
                "Pontos: " + score;


        float larguraPontos =
                paint.measureText(pontos);


        canvas.drawText(
                pontos,
                (getWidth() - larguraPontos) / 2,
                getHeight() / 2f + 55,
                paint
        );


        // Mensagem
        paint.setTextSize(25);


        String mensagem =
                "Toque para tentar novamente";


        float larguraMensagem =
                paint.measureText(mensagem);


        canvas.drawText(
                mensagem,
                (getWidth() - larguraMensagem) / 2,
                getHeight() / 2f + 105,
                paint
        );
    }


    // ==========================================
    // TOQUE NA TELA
    // ==========================================

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        // ==========================================
        // GAME OVER
        // ==========================================

        if (gameOver) {

            if (event.getAction() ==
                    MotionEvent.ACTION_DOWN) {

                reiniciarJogo();

                return true;
            }

            return true;
        }


        // ==========================================
        // MOVIMENTO DO JOGADOR
        // ==========================================

        if (event.getAction() ==
                MotionEvent.ACTION_DOWN ||
                event.getAction() ==
                        MotionEvent.ACTION_MOVE) {


            playerX =
                    event.getX();


            playerY =
                    event.getY();


            // Impedir jogador de sair da tela

            if (playerX < playerRadius) {

                playerX =
                        playerRadius;
            }


            if (playerX >
                    getWidth() - playerRadius) {

                playerX =
                        getWidth() - playerRadius;
            }


            if (playerY < playerRadius) {

                playerY =
                        playerRadius;
            }


            if (playerY >
                    getHeight() - playerRadius) {

                playerY =
                        getHeight() - playerRadius;
            }


            return true;
        }


        return true;
    }


    // ==========================================
    // REINICIAR
    // ==========================================

    private void reiniciarJogo() {


        bullets.clear();


        score = 0;


        lives = 5;


        nivel = 1;


        gameOver = false;


        tempoInicio =
                System.currentTimeMillis();


        lastShotTime = 0;


        playerX =
                getWidth() / 2f;


        playerY =
                getHeight() - 120;


        enemyX =
                getWidth() / 2f;


        enemyDirection = 1;


        invalidate();
    }


    // ==========================================
    // CLASSE DA BALA
    // ==========================================

    private static class Bullet {


        float x;

        float y;


        float speedX;

        float speedY;


        float radius = 1000;


        int color;


        Bitmap image;


        Bullet(
                float x,
                float y,
                float speedX,
                float speedY,
                float radius,
                int color,
                Bitmap image
        ) {


            this.x = x;

            this.y = y;

            this.speedX = speedX;

            this.speedY = speedY;

            this.radius = radius;

            this.color = color;

            this.image = image;
        }
    }
}