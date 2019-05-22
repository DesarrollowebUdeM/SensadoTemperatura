package com.example.coldorhot_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coldorhot_2.io.ApiAdapter;
import com.example.coldorhot_2.io.ApiService;
import com.example.coldorhot_2.Model.Login;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Dos extends AppCompatActivity {

   Button btnobtener1, btnsalir1;
   String temperstring;
   float temperaturas;
   int tempermas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        btnobtener1 = findViewById(R.id.btnobtener);
        btnsalir1 = findViewById(R.id.btnsalir);


//        btnobtener1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                TextView temperatura = findViewById(R.id.temp);
//                temperatura.setText("Soy puto");
//
//            }
//        });
//------------------------------------------------------------------------------------------------
       btnobtener1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Call<Float> call = ApiAdapter.getApiService().getTemperaturas();
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                         */
                        if(response.isSuccessful()){
                            temperaturas = (float) response.body();
                            Log.d("onResponse temperatura","La temperatura es: " + temperaturas);

                        }else{
                            Log.e("respuesta","Respuesta Incorrecta");
                        }
                    }
                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.e("onFailure","rip: " + t);
                    }
                });

                tempermas = (int)(Math.round(temperaturas));
                temperstring = Integer.toString(tempermas);
                //temperstring = Float.toString(temperaturas);
                TextView temperatura = findViewById(R.id.temp);
                temperatura.setText(temperstring+"°C");


            }
        });//Finalizo btnObtener

        btnsalir1.setOnClickListener(new View.OnClickListener() { //Accion btnSalir
            @Override
            public void onClick(View view) {
//                int p = android.os.Process.myPid(); //Lleva a variable P el PID de la app
//                android.os.Process.killProcess(p); //Mata el proceso de la app dado p
//                TextView process = findViewById(R.id.proceso);
//                process.setText("p");
                finish();
            }
        }); //finaliza btnsalir
        }


}
