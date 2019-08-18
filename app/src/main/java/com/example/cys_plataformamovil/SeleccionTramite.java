package com.example.cys_plataformamovil;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.TreeMap;

public class SeleccionTramite extends AppCompatActivity {


    public static TreeMap<Bundle, TreeMap<String,Integer>> getTramites(){
        TreeMap<Bundle,TreeMap<String,Integer>> treefinal=new TreeMap<>();
        Bundle bundle=new Bundle();
        TreeMap<String,Integer> tree=new TreeMap<>();

        ArrayList<String> bancos=new ArrayList<>();
        bancos.add("Banco Pichincha");
        bancos.add("Banco Bolivariano");
        bancos.add("Banco de Guayaquil");
        bundle.putStringArrayList("bancos",bancos);
        tree.put("bancos",R.id.buttonBancario);

        ArrayList<String> hospitales=new ArrayList<>();
        hospitales.add("Clinica Kennedy");
        hospitales.add("Hospital Luis Vernaza");
        hospitales.add("Hospital IESS");
        bundle.putStringArrayList("hospitales",hospitales);
        tree.put("hospitales",R.id.buttonMedico);

        ArrayList<String> legales=new ArrayList<>();
        legales.add("Corte Nacional de Justicia");
        legales.add("Fiscalia");
        bundle.putStringArrayList("legales",legales);
        tree.put("legales",R.id.buttonLegal);
        treefinal.put( bundle , tree);
        return treefinal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_institucion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TreeMap<Bundle ,TreeMap<String,Integer>> tree=getTramites();
        final Bundle b1=tree.firstKey();
        TreeMap<String,Integer> tree2=tree.get(b1);



        for(final String s:b1.keySet()){
            Button f=findViewById(tree2.get(s));
            f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<String> sd;
                    sd = (ArrayList<String>) b1.get(s);

                    Bundle b2=new Bundle();

                }
            });
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seleccion_institucion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}