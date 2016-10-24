package com.filagunas.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filagunas.mascotas.R;
import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by FERNANDOIVAN on 20/10/2016.
 */

public class ReciclerViewFragment extends Fragment{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container, false);
        //llamada al RecyclerView

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }
    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.p1, "fido", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p2, "puppy", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p3, "shira", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p4, "aquiles", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p5, "duque", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p6, "naila", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p7, "shina", "perro", 0));
        mascotas.add(new Mascota(R.drawable.p8, "hanna", "perro", 0));


    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
}
