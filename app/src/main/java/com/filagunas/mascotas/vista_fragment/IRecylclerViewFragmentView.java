package com.filagunas.mascotas.vista_fragment;

import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by FERNANDOIVAN on 11/11/2016.
 */

public interface IRecylclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
