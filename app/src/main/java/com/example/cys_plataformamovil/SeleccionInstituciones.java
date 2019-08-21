package com.example.cys_plataformamovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SeleccionInstituciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_instituciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final Button b1=findViewById(R.id.inst1);
        final Button b2=findViewById(R.id.inst2);
        final Button b3=findViewById(R.id.inst3);
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(b1);buttons.add(b2);buttons.add(b3);
        TextView tv=findViewById(R.id.descripcion);
        if(bundle!=null&&!bundle.isEmpty()) {
            b1.setText(bundle.getString("inst1"));
            b2.setText(bundle.getString("inst2"));
            b3.setText(bundle.getString("inst3"));
            tv.setText("Seleccione la institución de tipo "+((String)bundle.get("tipo")).toUpperCase()+" donde desea realizar su trámite");
        }

        for(final Button button:buttons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<String> sd;
                    sd = SeleccionTramite.getTramitesInstitucion().get((String)button.getText());
                    Bundle b2=new Bundle();
                    int t=1;
                    for(String s2:sd){
                        b2.putString("tra"+t,s2);
                        t++;
                    }
                    b2.putString("insti",(String)button.getText());
                    Intent intent=new Intent(SeleccionInstituciones.this,SeleccionTramiteEspecifico.class);
                    intent.putExtras(b2);
                    startActivity(intent);

                }
            });
        }

    }
}
