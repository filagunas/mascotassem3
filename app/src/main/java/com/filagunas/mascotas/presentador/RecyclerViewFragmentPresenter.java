package com.filagunas.mascotas.presentador;

import android.content.Context;

import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.db.ConstructorMascotas;
import com.filagunas.mascotas.pojo.Mascota;
import com.filagunas.mascotas.vista_fragment.IRecylclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by FERNANDOIVAN on 11/11/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecylclerViewFragmentView iRecylclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecylclerViewFragmentView iRecylclerViewFragmentView, Context context) {
    this.iRecylclerViewFragmentView= iRecylclerViewFragmentView;
    this.context=context;
        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarmascotasRV();



    }

    @Override
    public void mostrarmascotasRV() {
        iRecylclerViewFragmentView.inicializarAdaptadorRV(iRecylclerViewFragmentView.crearAdaptador(mascotas));
        iRecylclerViewFragmentView.generarLinearLayoutVertical();
    }
}
