package com.ronicode.tarea3_curso3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MascotasFavoritas extends AppCompatActivity {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager llm;
    private RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.dog_footprint_filled);

        inicializarListaMascotas();
        inicializarAdaptadorMascotas();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 12));
        mascotas.add(new Mascotas(R.drawable.perro_3_dalton, "Dalton", 10));
        mascotas.add(new Mascotas(R.drawable.perro_1_winnie, "Winnie", 8));
        mascotas.add(new Mascotas(R.drawable.perro_4_minnie, "Minnie", 6));
        mascotas.add(new Mascotas(R.drawable.perro_5_truman, "Truman", 4));
        mascotas.add(new Mascotas(R.drawable.perro_2_leto, "Leto", 1));

        Collections.sort(mascotas, new Comparator<Mascotas>() {
            @Override
            public int compare(Mascotas lhs, Mascotas rhs) {
                return lhs.getFavorito() - rhs.getFavorito();
            }
        });

        mascotas.remove(0);
        Collections.reverse(mascotas);

    }

    private void inicializarAdaptadorMascotas(){
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);

        adaptador = new MascotasAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
