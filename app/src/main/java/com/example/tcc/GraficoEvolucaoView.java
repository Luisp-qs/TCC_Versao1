package com.example.tcc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class GraficoEvolucaoView extends View {

    private Paint paintLinha;
    private Paint paintGrade;
    private Paint paintTexto;
    private Paint paintPonto;

    private float[] valores = {
            400,
            1800,
            1500,
            1500,
            800,
            1100,
            1400,
            1700,
            1650,
            2200,
            1500,
            2400,
            2100,
            2900
    };

    private String[] dias = {
            "S", "S", "T", "Q", "Q", "S", "S",
            "D", "S", "T", "Q", "Q", "S", "D"
    };

    public GraficoEvolucaoView(Context context) {
        super(context);
        inicializar();
    }

    public GraficoEvolucaoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }

    public GraficoEvolucaoView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        inicializar();
    }

    private void inicializar() {

        // =========================
        // LINHA DO GRÁFICO
        // =========================

        paintLinha = new Paint();
        paintLinha.setColor(Color.rgb(39, 170, 100));
        paintLinha.setStrokeWidth(6);
        paintLinha.setStyle(Paint.Style.STROKE);
        paintLinha.setAntiAlias(true);


        // =========================
        // GRADE
        // =========================

        paintGrade = new Paint();
        paintGrade.setColor(Color.rgb(235, 235, 235));
        paintGrade.setStrokeWidth(2);


        // =========================
        // TEXTOS
        // =========================

        paintTexto = new Paint();
        paintTexto.setColor(Color.rgb(150, 150, 150));
        paintTexto.setTextSize(28);
        paintTexto.setAntiAlias(true);


        // =========================
        // PONTOS
        // =========================

        paintPonto = new Paint();
        paintPonto.setColor(Color.rgb(39, 170, 100));
        paintPonto.setStyle(Paint.Style.FILL);
        paintPonto.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        float largura = getWidth();
        float altura = getHeight();

        float margemEsquerda = 75;
        float margemDireita = 30;
        float margemSuperior = 50;
        float margemInferior = 70;

        float larguraGrafico =
                largura - margemEsquerda - margemDireita;

        float alturaGrafico =
                altura - margemSuperior - margemInferior;


        // =========================
        // LINHAS HORIZONTAIS
        // =========================

        int[] niveis = {
                3000,
                2500,
                2000,
                1500,
                1000,
                500
        };

        for (int i = 0; i < niveis.length; i++) {

            float porcentagem =
                    (float) i / (niveis.length - 1);

            float y =
                    margemSuperior +
                            porcentagem * alturaGrafico;

            canvas.drawLine(
                    margemEsquerda,
                    y,
                    largura - margemDireita,
                    y,
                    paintGrade
            );

            canvas.drawText(
                    niveis[i] + " Kcal",
                    10,
                    y + 10,
                    paintTexto
            );
        }


        // =========================
        // LINHA DO GRÁFICO
        // =========================

        Path caminho = new Path();

        float espacamento =
                larguraGrafico / (valores.length - 1);

        for (int i = 0; i < valores.length; i++) {

            float x =
                    margemEsquerda +
                            i * espacamento;

            float porcentagem =
                    valores[i] / 3000f;

            float y =
                    margemSuperior +
                            alturaGrafico -
                            (porcentagem * alturaGrafico);

            if (i == 0) {

                caminho.moveTo(x, y);

            } else {

                caminho.lineTo(x, y);
            }


            // PONTO FINAL

            if (i == valores.length - 1) {

                canvas.drawCircle(
                        x,
                        y,
                        10,
                        paintPonto
                );
            }
        }

        canvas.drawPath(
                caminho,
                paintLinha
        );


        // =========================
        // DIAS
        // =========================

        for (int i = 0; i < dias.length; i++) {

            float x =
                    margemEsquerda +
                            i * espacamento;

            canvas.drawText(
                    dias[i],
                    x - 8,
                    altura - 25,
                    paintTexto
            );
        }
    }


    // =========================
    // ATUALIZAR DADOS
    // =========================

    public void atualizarDados(float[] novosValores) {

        if (novosValores != null &&
                novosValores.length > 1) {

            valores = novosValores;

            invalidate();
        }
    }
}