package com.ronicode.tarea3_curso3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager llm;
    private RecyclerView.Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        Toolbar  miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setIcon(R.drawable.dog_footprint_filled);


        inicializarListaMascotas();
        inicializarAdaptadorMascotas();

    }

    public void inicializarAdaptadorMascotas(){
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);

        adaptador = new MascotasAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_6_shaggy, "Shaggy", 12));
        mascotas.add(new Mascotas(R.drawable.perro_3_dalton, "Dalton", 10));
        mascotas.add(new Mascotas(R.drawable.perro_1_winnie, "Winnie", 8));
        mascotas.add(new Mascotas(R.drawable.perro_4_minnie, "Minnie", 6));
        mascotas.add(new Mascotas(R.drawable.perro_5_truman, "Truman", 4));
        mascotas.add(new Mascotas(R.drawable.perro_2_leto, "Leto", 1));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icono_favorito, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itSalir:
                finish();
                return true;
            case R.id.itmisfavoritos:
            case R.id.itmenu_favorito:
                Intent intent = new Intent(this, MascotasFavoritas.class);
                startActivityForResult(intent, 0);
                return true;
            default:
                return false;
        }
    }
}
