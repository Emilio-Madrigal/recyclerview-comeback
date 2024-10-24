package com.example.listadin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import global.info;
import pojo.equipo;

public class Eliminar extends AppCompatActivity {
TextView equipos;
Button eliminar;
EditText NEM ;
Toolbar toolbar;
CheckBox checkBox;
Integer posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eliminar);
        toolbar=findViewById(R.id.toolbar);
        equipos=findViewById(R.id.NomEquipo);
        eliminar=findViewById(R.id.EliminarB);
        checkBox=findViewById(R.id.c1);
        setSupportActionBar(toolbar);

        // o el seton o el public void hacen que no pueda ir a esa view

//        eliminar.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                eliminar();
//            }
//        });

    }
//    public void eliminar() {
//        if(checkBox.isChecked()){
//
//        }
//        else{
//            Toast.makeText(this,"no seleccionaste ninguna casilla",Toast.LENGTH_SHORT).show();
//        }
//    }
    
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
            Intent cambio8 = new Intent(this, ver.class);
            startActivity(cambio8);
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
        if(item.getItemId()==R.id.opc5){
            Intent cambio8 = new Intent(this,Modificar.class);
            startActivity(cambio8);
        }
        if(item.getItemId()==R.id.opc6){
            Intent cambio8 = new Intent(this, Eliminar.class);
            startActivity(cambio8);
        }
        return super.onOptionsItemSelected(item);
    }
}