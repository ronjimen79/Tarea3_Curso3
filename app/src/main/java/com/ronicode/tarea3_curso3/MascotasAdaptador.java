package com.ronicode.tarea3_curso3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Roni on 1/05/2017.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder> {
    private ArrayList<Mascotas> mascotaLista;
    Activity activity;

    public MascotasAdaptador(ArrayList<Mascotas> mascotaLista, Activity activity){
        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }


    //Inflar el layout y lo pasaráa al viewholder para que obtenga los wiews
    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        MascotasViewHolder mascota = new MascotasViewHolder(v);
        return mascota;
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(MascotasViewHolder mascotasViewHolder,int position) {
        final Mascotas mascota = mascotaLista.get(position);
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotasViewHolder.tvFavoritoCV.setText(String.valueOf(mascota.getFavorito()));

        mascotasViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        mascotasViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "te gusta " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        }
    //Cantidad de elemntos que contiene mi lista
    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btnLikeCV;
        private TextView tvNombreCV;
        private TextView tvFavoritoCV;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvFavoritoCV = (TextView) itemView.findViewById(R.id.tvFavoritoCV);

        }
    }
}
