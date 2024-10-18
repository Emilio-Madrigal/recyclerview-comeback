package com.example.listadin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import global.info;
import pojo.equipo;

public class MainActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
    EditText NombreE,Puntos,JuegosJ,JuegosG,JuegosE,NocontactoE;
    Button guardar, limpieza;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        NombreE=findViewById(R.id.NEM);
        Puntos=findViewById(R.id.PEM);
        JuegosJ=findViewById(R.id.JJEM);
        JuegosG=findViewById(R.id.JGEM);
        JuegosE=findViewById(R.id.JEEM);
        NocontactoE=findViewById(R.id.NCEM);
        setSupportActionBar(toolbar);

        limpieza.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                limpieza();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                guardardor();
            }
        });

    }

    public void limpieza() {
        NombreE.setText("");
        Puntos.setText("");
        JuegosJ.setText("");
        JuegosG.setText("");
        JuegosE.setText("");
        NocontactoE.setText("");
    }

    public void guardardor(){
        equipo unequipo =new equipo();
        unequipo.setTeam(NombreE.getText().toString());
        unequipo.setPoints(Puntos.getText().toString());
        unequipo.setGames(JuegosJ.getText().toString());
        unequipo.setWins(JuegosG.getText().toString());
        unequipo.setTies(JuegosE.getText().toString());
        unequipo.setContact(NocontactoE.getText().toString());
        info.lista.add(unequipo);
        Toast.makeText(this, "Elementos guardados", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opc1){
            Intent cambio7 = new Intent(this, cardview.class);
            startActivity(cambio7);
        }
        if(item.getItemId()==R.id.opc2){
            Intent cambio8 = new Intent(this, MainActivity.class);
            startActivity(cambio8);
        }
        if(item.getItemId()==R.id.opc3){
            Intent cambio8 = new Intent(this, Autor.class);
            startActivity(cambio8);
        }
        if(item.getItemId()==R.id.opc4){
            Intent cambio8 = new Intent(this, Contacto.class);
            startActivity(cambio8);
        }
        return super.onOptionsItemSelected(item);
    }

}