package com.filagunas.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.filagunas.mascotas.R.id.favoritos;
import static com.filagunas.mascotas.R.id.rvMascotas;
import static com.filagunas.mascotas.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Button top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top =(Button) findViewById(R.id.favoritos);
        //llamada al RecyclerView
        listaMascotas = (RecyclerView) findViewById(rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();

        inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
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
//Carga de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.menu) {

                Toast.makeText(this,"presiono la opcion 1:", Toast.LENGTH_LONG).show();
                }
        if (id == R.id.menu1) {

            Toast.makeText(this,"presiono la opcion 2:", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.menu2) {

            Toast.makeText(this,"presiono la opcion 3:", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.favoritos) {

            Intent intent=new Intent(this, Top5.class);
            intent.putParcelableArrayListExtra("listatop", mascotas);
            Toast.makeText(MainActivity.this,"presiono la opcion favoritos:", Toast.LENGTH_LONG).show();

            startActivity(intent);
            return true;


            }

         return  super.onOptionsItemSelected(item);


    }
}

