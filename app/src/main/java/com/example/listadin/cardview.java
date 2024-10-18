package com.example.listadin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import global.info;

public class cardview extends AppCompatActivity {

    Button llamar;
    TextView NombreE,Puntos,JuegosJ,JuegosG,JuegosE,NocontactoE;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cardview);

        llamar = findViewById(R.id.llamar);

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamada = new Intent(Intent.ACTION_CALL);
                llamada.setData(Uri.parse("tel: "+ NocontactoE.getText().toString()));
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]    {
                            Manifest.permission.CALL
                    });
                }
            }
        });
        int posicion;
        posicion=getIntent().getIntExtra("posicion", -1);
        NombreE.setText(info.lista.get(posicion).getTeam());
        Puntos.setText(info.lista.get(posicion).getPoints());
        JuegosJ.setText(info.lista.get(posicion).getWins());
        JuegosG.setText(info.lista.get(posicion).getGames());
        JuegosE.setText(info.lista.get(posicion).getTies());
        NocontactoE.setText(info.lista.get(posicion).getContact());

    }
}