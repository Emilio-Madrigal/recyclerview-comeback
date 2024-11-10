package com.example.listadin;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class inicio extends AppCompatActivity {
EditText user,password;
Button loggin;
SharedPreferences archivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        user=findViewById(R.id.user);
        password=findViewById(R.id.password);
        loggin=findViewById(R.id.loggin);
        archivo=this.getSharedPreferences("sesion", Context.MODE_PRIVATE);

        loggin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {loggin();}
        });
    }


    public void loggin() {

        String url = "192.168.1.110";//hace falta cambiar esto
        url=url+user.getText().toString();
        url=url+"&pass=";
        url=url+password.getText().toString();
        JsonObjectRequest pet = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if (response.getInt("usr") != -1) {
                        Intent i = new Intent(inicio.this, MainActivity.class);
                        SharedPreferences.Editor editor = archivo.edit();
                        editor.putInt("id_usuario", response.getInt("usr"));
                        editor.commit();
                        startActivity(i);
                        finish();
                    } else {
                        user.setText("");
                        password.setText("");

                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(inicio.this, response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("yo",volleyError.getMessage());
            }

    });
    RequestQueue lanzarpet = Volley.newRequestQueue(this);
    lanzarpet.add(pet);

//        if(user.getText().toString().equals("emi")&&password.getText().toString().equals("123456")){
//            Intent in=new Intent(this,MainActivity.class);
//            SharedPreferences.Editor editor = archivo.edit();
//            editor.putString("usuaario","emi");
//            editor.putString("contra","123456");
//            editor.putBoolean("valido",true);
//
//            startActivity(in);
//            finish();
//        }
//        else{
//            user.setText("");
//            password.setText("");
//            Toast.makeText(this,"usuario o contrasena incorrecta",Toast.LENGTH_SHORT).show();
//        }


    }



}