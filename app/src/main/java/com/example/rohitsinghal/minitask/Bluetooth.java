package com.example.rohitsinghal.minitask;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Bluetooth extends AppCompatActivity {
    Button b1;
    ImageButton i1;
    BluetoothAdapter bm;
    private boolean blue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        b1=(Button)findViewById(R.id.button17);
        i1=(ImageButton)findViewById(R.id.imageButton);
        bm=BluetoothAdapter.getDefaultAdapter();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blue==false){
                    bm.enable();
                    blue=true;
                    i1.setImageResource(R.drawable.g);
                }
                else {
                    bm.disable();
                    blue=false;
                    i1.setImageResource(R.drawable.r);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bluetooth.this,Wifi.class);
                startActivity(i);
                finish();
            }
        });
    }
}
