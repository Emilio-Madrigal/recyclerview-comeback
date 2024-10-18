package com.example.listadin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import pojo.equipo;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
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

    }

    public void limpieza(View view) {
        NombreE.setText("");
        Puntos.setText("");
        JuegosJ.setText("");
        JuegosG.setText("");
        JuegosE.setText("");
        NocontactoE.setText("");
    }

    private void onClick_guardar(){
        equipo unequipo =new equipo();
        unequipo.setTeam(NombreE.getText().toString());

        equipo unpuntos =new equipo();
        unequipo.setPoints(Puntos.getText().toString());

        equipo unjuegos =new equipo();
        unequipo.setGames(JuegosJ.getText().toString());

        equipo unganados =new equipo();
        unequipo.setWins(JuegosG.getText().toString());

        equipo unempatados =new equipo();
        unequipo.setTies(JuegosE.getText().toString());

        equipo uncontacto =new equipo();
        unequipo.setContact(NocontactoE.getText().toString());

        Toast.makeText(this, "Elementos guardados", Toast.LENGTH_SHORT).show();
    }

}