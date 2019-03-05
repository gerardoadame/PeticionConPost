package com.example.peticionconpost;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String URL="http://nuevo.rnrsiilge-org.mx/nombre";
    TextView texto;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto=findViewById(R.id.texto);
        btn=findViewById(R.id.boton);

//        findViewById(R.id.boton).setOnClickListener(this);

        btn.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        JSONObject peticion = new JSONObject();
        try {
            peticion.put("Nombre","gera");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                "http://nuevo.rnrsiilge-org.mx/nombre",peticion,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        texto.setText(response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        VolleyS.getVolley(this).getRequestQueue().add(jsonObjectRequest);

    }
}
