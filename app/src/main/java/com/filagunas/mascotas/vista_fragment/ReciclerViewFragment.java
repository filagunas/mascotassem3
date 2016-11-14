package com.filagunas.mascotas.vista_fragment;

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
import com.filagunas.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.filagunas.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by FERNANDOIVAN on 20/10/2016.
 */

public class ReciclerViewFragment extends Fragment implements IRecylclerViewFragmentView{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container, false);
        //llamada al RecyclerView

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter=new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }





    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
