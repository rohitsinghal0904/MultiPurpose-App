package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Vedio extends AppCompatActivity {
    Button b1,b2;
    VideoView v1;
    MediaController m1;
    Uri u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        b1=(Button)findViewById(R.id.button15);
        b2=(Button)findViewById(R.id.button16);
        v1=(VideoView)findViewById(R.id.videoView);
        m1=new MediaController(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Vedio.this,Bluetooth.class);
                startActivity(l);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(p,20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==20){
            u1=data.getData();
            v1.setVideoURI(u1);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();

        }
        else {
            Toast.makeText(Vedio.this, "Vedio Can't be Capture", Toast.LENGTH_SHORT).show();
        }
    }
}
