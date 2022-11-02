package com.example.lab04_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MyReceiver objReceiver = new MyReceiver();
    private MyReceiver objReceiver2 = new MyReceiver();

    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter1 = new IntentFilter("com.aplicacion1.message");
        IntentFilter intentFilter2 = new IntentFilter("com.aplicacion2.message");
        registerReceiver(objReceiver, intentFilter1);
        registerReceiver(objReceiver, intentFilter2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mensaje = findViewById(R.id.editTextMensaje);
        Button botonEnviar = findViewById(R.id.buttonEnviar);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sms = mensaje.getText().toString();

                Intent intent = new Intent("com.aplicacion1.message");
                intent.putExtra("app", sms);
                sendBroadcast(intent);

            }
        });
    }
}