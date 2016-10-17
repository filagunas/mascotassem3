package com.filagunas.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


public class DetalleMascota extends AppCompatActivity {




    private TextView tvMascota;
    private TextView tvRaza;

    private TextView tvLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detalle_mascota);
        Bundle parametros       =getIntent().getExtras();
        String  mascota         =parametros.getString("mascota");
        String  raza            =parametros.getString("raza");
        String  like            =parametros.getString("like");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"likes recibidos: "+like, Toast.LENGTH_SHORT).show();

        tvMascota   =(TextView)findViewById(R.id.tvMascota);
        tvRaza      =(TextView)findViewById(R.id.tvRaza);
        tvLike      =(TextView)findViewById(R.id.tvLike);

        tvMascota.setText(mascota);
        tvRaza.setText(raza);
        tvLike.setText(like);


    }
}
