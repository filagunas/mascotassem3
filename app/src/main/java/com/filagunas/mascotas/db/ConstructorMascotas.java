package com.filagunas.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.filagunas.mascotas.R;
import com.filagunas.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by FERNANDOIVAN on 11/11/2016.
 */

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context=context;

    }

    public ArrayList<Mascota> obtenerDatos(){


        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
      /* mascotas.add(new Mascota(R.drawable.p1, "fido", "perro", 5));
        mascotas.add(new Mascota(R.drawable.p2, "puppy", "perro", 6));
        mascotas.add(new Mascota(R.drawable.p3, "shira", "perro", 7));
        mascotas.add(new Mascota(R.drawable.p4, "aquiles", "perro", 8));
        mascotas.add(new Mascota(R.drawable.p5, "duque", "perro", 9));
        mascotas.add(new Mascota(R.drawable.p6, "naila", "perro", 10));
        mascotas.add(new Mascota(R.drawable.p7, "shina", "perro", 2));
        mascotas.add(new Mascota(R.drawable.p8, "hanna", "perro", 1));
        return mascotas;*/

        BaseDatos db= new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLasMascotas();



    }
    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "fido");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.p1);

        db.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "puppy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.p2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "shira");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.p3);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
