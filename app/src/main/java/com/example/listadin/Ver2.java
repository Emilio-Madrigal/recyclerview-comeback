package com.example.listadin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adaptador.adaptadorver;

public class Ver2 extends AppCompatActivity {

    RecyclerView rv2;
    Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver2);

        rv2=findViewById(R.id.recyclerviewE);
        adaptadorver av = new adaptadorver();
        av.context=this;
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(llm);
        rv2.setAdapter(av);

    }


}