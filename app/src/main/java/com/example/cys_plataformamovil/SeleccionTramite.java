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
import java.util.HashMap;
import java.util.TreeMap;

public class SeleccionTramite extends AppCompatActivity {


    public static HashMap<Bundle, TreeMap<String,Integer>> getTramites(){
        HashMap<Bundle,TreeMap<String,Integer>> treefinal=new HashMap<>();
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

    public static TreeMap<String, ArrayList<String>> getTramitesInstitucion() {
        TreeMap<String, ArrayList<String>> tree = new TreeMap<>();
        HashMap<Bundle, TreeMap<String, Integer>> tr = getTramites();

        for (Bundle b : tr.keySet()) {
            ArrayList<String> b1 = (ArrayList<String>) b.get("bancos");
            ArrayList<String> tramitesBancos = new ArrayList<>();
            tramitesBancos.add("Crear cuenta");
            tramitesBancos.add("Generar clave");
            tramitesBancos.add("Solicitar préstamo");
            for (String s : b1) {
                tree.put(s, tramitesBancos);
            }

            ArrayList<String> b2 = (ArrayList<String>) b.get("hospitales");
            ArrayList<String> tramitesMedicos = new ArrayList<>();
            tramitesMedicos.add("Separar consulta");
            tramitesMedicos.add("Separar cita");
            tramitesMedicos.add("Revisión examen");
            for (String s : b2) {
                tree.put(s, tramitesMedicos);
            }
            ArrayList<String> b3 = (ArrayList<String>) b.get("legales");
            ArrayList<String> tramitesLegales = new ArrayList<>();
            tramitesLegales.add("Generación de testamento");
            tramitesLegales.add("Contratos");
            tramitesLegales.add("Documentos notarizados");
        for (String s : b3) {
            tree.put(s, tramitesLegales);
            }
        }
        return tree;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_institucion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        HashMap<Bundle ,TreeMap<String,Integer>> tree=getTramites();
        Bundle b1 = null;
        for(Bundle bundle:tree.keySet()){
            b1=bundle;
        }
        TreeMap<String,Integer> tree2=tree.get(b1);



        for(final String s:b1.keySet()){
            Button f=findViewById(tree2.get(s));
            final Bundle finalB = b1;
            f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<String> sd;
                    sd = (ArrayList<String>) finalB.get(s);
                    Bundle b2=new Bundle();
                    int t=1;
                    for(String s2:sd){
                        b2.putString("inst"+t,s2);
                        t++;
                    }
                    b2.putString("tipo",s);
                    Intent intent=new Intent(SeleccionTramite.this,SeleccionInstituciones.class);
                    intent.putExtras(b2);
                    startActivity(intent);

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