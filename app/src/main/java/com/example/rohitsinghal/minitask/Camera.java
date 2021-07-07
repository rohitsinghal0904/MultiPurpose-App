package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {
    Button b1,b2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1=(Button)findViewById(R.id.button13);
        b2=(Button)findViewById(R.id.button14);
        i1=(ImageView)findViewById(R.id.imageView);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l= new Intent(Camera.this,Vedio.class);
                startActivity(l);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(k,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            i1.setImageBitmap(bp);
        }else{
            Toast.makeText(Camera.this, "No capture Photo", Toast.LENGTH_SHORT).show();
        }
    }
}
