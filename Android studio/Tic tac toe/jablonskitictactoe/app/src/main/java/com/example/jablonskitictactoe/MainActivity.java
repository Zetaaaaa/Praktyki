package com.example.jablonskitictactoe;

import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button bt1, bt2, bt3;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private LinearLayout.LayoutParams layoutParams;
    private FrameLayout frameLayout, frameLayoutTouch;
    private RelativeLayout relativeLayout;
    private int rozmiar,k,ox,setColor;
    private int[] board = new int[9];
    private Point size;
    private TextView winTxt, txt111;
    private boolean winO,winX,dontTouch;
    private Spinner spin1, spin2;
    private File scoreFiles, scorefile;
    private ArrayList<Point> points = new ArrayList<>(); // lista na punkty ścieżki
    private StringBuilder builder = new StringBuilder();    // utworzenie


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        linearLayout = findViewById(R.id.lin1);
        frameLayout = findViewById(R.id.fl1);
        frameLayoutTouch = findViewById(R.id.fl2);
        relativeLayout = findViewById(R.id.rl1);
        txt111 = findViewById(R.id.txt111);

        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        //robie plasze
        rozmiar = 3;
        makePlansze(rozmiar);
        ox=1;



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rozmiar>=6)rozmiar = 2;
                rozmiar++;
                //Log.d("xxx","rozmiar: "+rozmiar);
                makePlansze(rozmiar);

                winO=false;
                winX=false;
                for (int i=0;i<9;i++){
                    board[i]=0;
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayoutTouch.setVisibility(View.GONE);
                makePlansze(rozmiar);       //nowa gra

                dontTouch=false;
                winO=false;
                winX=false;
                for (int i=0;i<9;i++){
                    board[i]=0;
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dontTouch == false) {
                    if (winO) {
                        //rysunek
                        StringBuilder builder = new StringBuilder();
                        builder.setLength(0);
                        for (int i = 0; i < points.size() - 1; i++) {
                            builder.append("[" + points.get(i).x + "," + points.get(i).y + "];");
                        }
                        // Log.d("xxx", builder.length()+"");
                        builder.toString().substring(0, builder.length());
                        Log.d("xxx", builder.toString());
                        for (int i = points.size() - 1; i < points.size(); i++)
                            builder.append("[" + points.get(i).x + "," + points.get(i).y + "]");
                        Log.d("xxx", builder.toString());

                        //zapis tablicy do pliku txt
                        File docs = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                        //sprawdzenie czy folder dokumenty istnieje
                        if (!docs.exists()) {
                            docs.mkdir();
                        }

                        //utworzenie folderu wyników
                        File folderWynikow = new File(docs, "Pasternak_wyniki");
                        folderWynikow.mkdir();

                        //przekształcenie tablicy do stringa
                        String dataToWrite = Arrays.toString(board);

                        //utworzenie pliku
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = sdf.format(c.getTime());

                        File scorefile = new File(folderWynikow, "ttt-" + date);
                        FileWriter writer = null;
                        try {
                            writer = new FileWriter(scorefile);
                            writer.append(dataToWrite);
                            writer.append(System.lineSeparator());
                            writer.append(builder.toString());
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

//                Log.d("xxx","plik zapisany!!!");
                        Toast.makeText(MainActivity.this, "Wynik Zapisany", Toast.LENGTH_SHORT).show();

                        dontTouch=true;
                    }

                    if (winX) {
                        //rysunek
                        StringBuilder builder = new StringBuilder();
                        builder.setLength(0);
                        for (int i = 0; i < points.size() - 1; i++) {
                            builder.append("[" + points.get(i).x + "," + points.get(i).y + "];");
                        }
                        // Log.d("xxx", builder.length()+"");
                        builder.toString().substring(0, builder.length());
                        Log.d("xxx", builder.toString());
                        for (int i = points.size() - 1; i < points.size(); i++)
                            builder.append("[" + points.get(i).x + "," + points.get(i).y + "]");
                        Log.d("xxx", builder.toString());

                        //zapis tablicy do pliku txt
                        File docs = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                        //sprawdzenie czy folder dokumenty istnieje
                        if (!docs.exists()) {
                            docs.mkdir();
                        }

                        //utworzenie folderu wyników
                        File folderWynikow = new File(docs, "Pasternak_wyniki");
                        folderWynikow.mkdir();

                        //przekształcenie tablicy do stringa
                        String dataToWrite = Arrays.toString(board);

                        //utworzenie pliku
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = sdf.format(c.getTime());

                        File scorefile = new File(folderWynikow, "ttt-" + date);
                        FileWriter writer = null;
                        try {
                            writer = new FileWriter(scorefile);
                            writer.append(dataToWrite);
                            writer.append(System.lineSeparator());
                            writer.append(builder.toString());
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

//                Log.d("xxx","plik zapisany!!!");
                        Toast.makeText(MainActivity.this, "Wynik Zapisany", Toast.LENGTH_SHORT).show();

                        dontTouch = true;
                    }
                }
            }
        });




        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // i tworzy nową planszę
                makePlansze(rozmiar);

                winO=false;
                winX=false;

                for (int i=0;i<9;i++){
                    board[i]=0;
                }

                relativeLayout.setVisibility(View.GONE);//zamyka ekran wygranej
                frameLayoutTouch.setVisibility(View.VISIBLE);//otwiera touch
            }
        });


    }



    private void makePlansze(int rozmiar){

        frameLayout.removeAllViews();

        k=0;
        setColor=0xaa50f0a0;


        layoutParams = new LinearLayout.LayoutParams(size.x/rozmiar-5, size.x/rozmiar-5);

        for (int i = 0; i<rozmiar; i++) {

            for (int j = 0; j < rozmiar; j++) {

                final ImageView imageView = new ImageView(MainActivity.this);
                imageView.setBackgroundColor(setColor);
                imageView.setLayoutParams(layoutParams);
                imageView.setX(5 + (size.x / rozmiar) * i);
                imageView.setY(5 + (size.x / rozmiar) * j);
                imageView.setId(k);
                frameLayout.addView(imageView);

                k++;

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageView ttt = (ImageView)view;
                        //Log.d("xxx", String.valueOf(ttt.getId()));

                        if(view.getTag()!="nieTykaj"){
                            if(ox==1){
                                imageView.setImageResource(R.drawable.o);
                                ox=2;

                                board[imageView.getId()]=1;
                            }
                            else if(ox==2){
                                imageView.setImageResource(R.drawable.x);
                                ox=1;

                                board[imageView.getId()]=2;
                            }
                        }

                        view.setTag("nieTykaj");

                        //for(int a=0;a<9;a++) {
                        //    Log.d("xxx", "miejsce "+a+" tablicy: " + board[a]);
                        //}

                        //pionowo
                        if (board[0] == 1 && board[1] == 1 && board[2] == 1) winO = true;
                        else if (board[3] == 1 && board[4] == 1 && board[5] == 1) winO = true;
                        else if (board[6] == 1 && board[7] == 1 && board[8] == 1) winO = true;
                            //poziomo
                        else if (board[0] == 1 && board[3] == 1 && board[6] == 1) winO = true;
                        else if (board[1] == 1 && board[4] == 1 && board[7] == 1) winO = true;
                        else if (board[2] == 1 && board[5] == 1 && board[8] == 1) winO = true;
                            //skos
                        else if (board[0] == 1 && board[4] == 1 && board[8] == 1) winO = true;
                        else if (board[2] == 1 && board[4] == 1 && board[6] == 1) winO = true;

                        if(winO){
//                            Log.d("xxx","kółka wygrały");
                            relativeLayout.setVisibility(View.VISIBLE);
                            txt111.setBackgroundColor(0xFF00FF00);
                            txt111.setText("Kółka wygrały");

                        }

                        //pionowo
                        if (board[0] == 2 && board[1] == 2 && board[2] == 2) winX = true;
                        else if (board[3] == 2 && board[4] == 2 && board[5] == 2) winX = true;
                        else if (board[6] == 2 && board[7] == 2 && board[8] == 2) winX = true;
                            //poziomo
                        else if (board[0] == 2 && board[3] == 2 && board[6] == 2) winX = true;
                        else if (board[1] == 2 && board[4] == 2 && board[7] == 2) winX = true;
                        else if (board[2] == 2 && board[5] == 2 && board[8] == 2) winX = true;
                            //skos
                        else if (board[0] == 2 && board[4] == 2 && board[8] == 2) winX = true;
                        else if (board[2] == 2 && board[4] == 2 && board[6] == 2) winX = true;

                        if(winX){
//                            Log.d("xxx","krzyżyki wygrały");
                            relativeLayout.setVisibility(View.VISIBLE);
                            txt111.setBackgroundColor(0xFF00FF00);
                            txt111.setText("Krzyżyki wygrały");


                        }

                    }
                });
            }
        }
    }
}