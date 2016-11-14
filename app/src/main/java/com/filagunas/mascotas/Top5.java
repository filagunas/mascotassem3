package com.filagunas.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.db.BaseDatos;
import com.filagunas.mascotas.pojo.Mascota;



import java.util.ArrayList;
import java.util.Collections;


import static com.filagunas.mascotas.R.id.top5Mascotas;


public class Top5 extends AppCompatActivity {

    private RecyclerView topMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);


        topMascotas = (RecyclerView) findViewById(top5Mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        topMascotas.setLayoutManager(llm);

        mascotas = getIntent().getParcelableArrayListExtra("listatop");

        BaseDatos db= new BaseDatos(this);
        this.mascotas=db.top5Mascota();

        //GenerarTop();
                inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(this.mascotas, this);
        topMascotas.setAdapter(adaptador);
    }


    /*private void GenerarTop() {

        ArrayList<Mascota> tempArray;

        tempArray= (ArrayList<Mascota>) mascotas.clone();


        Collections.sort(tempArray);

        for(Mascota product:tempArray){
            System.out.println(product);     }
        int i;
        for (i=0; i<5; i++){

        }

    }*/
    }
