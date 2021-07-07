package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class Wifi extends AppCompatActivity {
    Button b1;
    ToggleButton tb;
    WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        b1=(Button)findViewById(R.id.button18);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Wifi.this,Torch.class);
                startActivity(l);
                finish();
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                   wm.setWifiEnabled(true);
                }else{
                        wm.setWifiEnabled(false);
                }
            }
        });


    }
}
