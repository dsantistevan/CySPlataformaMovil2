package com.example.cys_plataformamovil;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SeleccionTramiteEspecifico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_tramite_especifico);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final Button b1=findViewById(R.id.tra1);
        final Button b2=findViewById(R.id.tra2);
        final Button b3=findViewById(R.id.tra3);
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(b1);buttons.add(b2);buttons.add(b3);
        TextView tv=findViewById(R.id.descripcion);
        if(bundle!=null&&!bundle.isEmpty()) {
            b1.setText(bundle.getString("tra1"));
            b2.setText(bundle.getString("tra2"));
            b3.setText(bundle.getString("tra3"));
            tv.setText("Seleccione el trámite que desee realizar en "+((String)bundle.get("insti")).toUpperCase());
        }

    }
}
