package com.example.coldorhot_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Codigo de registro aca

        btnregister = findViewById(R.id.btnregister1);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Activity_Dos = new Intent(getApplicationContext(), Activity_Dos.class);
                startActivity(Activity_Dos);

            }
        });

    }
}
