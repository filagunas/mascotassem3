package com.filagunas.mascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.filagunas.mascotas.adapter.MascotaAdaptador;
import com.filagunas.mascotas.adapter.PageAdapter;
import com.filagunas.mascotas.fragment.PerfilFragment;
import com.filagunas.mascotas.fragment.ReciclerViewFragment;
import com.filagunas.mascotas.pojo.Mascota;

import java.util.ArrayList;

import static com.filagunas.mascotas.R.id.activity_contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    Button top;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ReciclerViewFragment rvfmascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar =(Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        botoncamera();


        top =(Button) findViewById(R.id.favoritos);

        if(toolbar!= null){
            setSupportActionBar(toolbar);
        }
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments =new ArrayList<>();
        this.rvfmascotas= new ReciclerViewFragment();
        fragments.add(this.rvfmascotas);
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.perfildog);

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
                Intent IContacto=new Intent(this, ContactoActivity.class);
                Toast.makeText(this,"presiono la opcion Contactar:", Toast.LENGTH_LONG).show();
                startActivity(IContacto);
                return true;
                }
          if (id == R.id.menu1) {
              Intent IAbout=new Intent(this, About.class);
              Toast.makeText(this,"presiono la opcion Contactar:", Toast.LENGTH_LONG).show();
              startActivity(IAbout);
              return true;


        }
                   if (id == R.id.favoritos) {

            Intent intent=new Intent(this, Top5.class);

            intent.putParcelableArrayListExtra("listatop", this.rvfmascotas.getMascotas());
            Toast.makeText(MainActivity.this,"presiono la opcion favoritos:", Toast.LENGTH_LONG).show();

            startActivity(intent);
            return true;


            }

         return  super.onOptionsItemSelected(item);


    }
    public void botoncamera() {
        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, getResources().getString(R.string.camera), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.camera), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }

}

