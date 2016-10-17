package com.filagunas.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by FERNANDOIVAN on 13/10/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
     ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota>mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvMascotaCV.setText(mascota.getMascota());
        mascotaViewHolder.tvRazaCV.setText(mascota.getRaza());
        mascotaViewHolder.tvLikesCV.setText(" "+mascota.getLike()+" ");

       //Boton del Click
        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mascota.incremetarlikes();
                //Toast.makeText(activity,"likes= " +mascota.incremetarlikes(), Toast.LENGTH_SHORT).show();
                 mascotaViewHolder.tvLikesCV.setText(" "+mascota.getLike()+" ");




            }
        });
       // mascotaViewHolder.tvLikesCV.setText(mascota.getLike());

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity,"likes: "+mascota.getLike(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(activity, DetalleMascota.class);
                intent.putExtra("mascota", mascota.getMascota());
                intent.putExtra("raza", mascota.getRaza());
               intent.putExtra("like", String.valueOf(mascota.getLike()));
              activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvMascotaCV;
        private TextView tvRazaCV;
        private TextView tvLikesCV;
        private ImageButton btnLikeCV;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto         =(ImageView)itemView.findViewById(R.id.imgfoto);
            tvMascotaCV     =(TextView)itemView.findViewById(R.id.tvmascotaCV);
            tvRazaCV        =(TextView)itemView.findViewById((R.id.tvRazaCV));
            btnLikeCV       =(ImageButton) itemView.findViewById(R.id.btnlikeCV);
            this.tvLikesCV  =(TextView) itemView.findViewById(R.id.tvLikesCV);

        }
    }

}
