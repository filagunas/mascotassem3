package com.filagunas.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


import static com.filagunas.mascotas.R.id.top5Mascotas;


public class Top5 extends AppCompatActivity {

    private RecyclerView topMascotas;
    ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> Top5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);
        Top5=new ArrayList<Mascota>();

        topMascotas = (RecyclerView) findViewById(top5Mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        topMascotas.setLayoutManager(llm);
        mascotas = getIntent().getParcelableArrayListExtra("listatop");

        GenerarTop();
        inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(Top5, this);
        topMascotas.setAdapter(adaptador);
    }


    private void GenerarTop() {

        ArrayList<Mascota> tempArray;

        tempArray= (ArrayList<Mascota>) mascotas.clone();

        for(Mascota product:tempArray){
            System.out.println(product);     }
        Collections.sort(tempArray);
        for(Mascota product:tempArray){
            System.out.println(product);
            }

        int i;
        for (i=0; i<5; i++){
            Top5.add((Mascota) tempArray.get(i));


        }

    }
    }
