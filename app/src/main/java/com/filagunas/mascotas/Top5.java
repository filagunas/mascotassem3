package com.filagunas.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


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
        mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("listatop");
        inicializarAdaptador();


    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        topMascotas.setAdapter(adaptador);
    }

}
