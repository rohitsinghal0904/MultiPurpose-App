package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Torch extends AppCompatActivity {
    Button b1,b2,b3;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        b1=(Button)findViewById(R.id.button19);
        b2=(Button)findViewById(R.id.button20);
        b3=(Button)findViewById(R.id.button21);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(Torch.this,Logout.class);
                startActivity(k);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String s1=cm.getCameraIdList()[0];
                    cm.setTorchMode(s1,false);
                }catch (CameraAccessException e){

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String s2=cm.getCameraIdList()[0];
                    cm.setTorchMode(s2,true);
                }catch (CameraAccessException e){

                }
            }
        });
    }
}
