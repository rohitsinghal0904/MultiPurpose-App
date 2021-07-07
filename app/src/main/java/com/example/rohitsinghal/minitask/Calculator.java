package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    EditText e1,e2;
    TextView t1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button9);
        b3=(Button)findViewById(R.id.button10);
        b4=(Button)findViewById(R.id.button11);
        b5=(Button)findViewById(R.id.button12);
        e1=(EditText)findViewById(R.id.editText7);
        e2=(EditText)findViewById(R.id.editText8);
        t1=(TextView)findViewById(R.id.textView);
        ts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setSpeechRate(0.5f);
                ts.setLanguage(Locale.ENGLISH);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Calculator.this,Camera.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    ts.speak("Please Enter the values",TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "Please Enter the values", Toast.LENGTH_SHORT).show();

                }else{
                    Float f1=Float.parseFloat(s1);
                    Float f2=Float.parseFloat(s2);
                    Float f3=f1+f2;
                    String s3=Float.toString(f3);
                    t1.setText(s3);
                    ts.speak("The Result is"+ s3,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "The Result is "+s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    ts.speak("Please Enter the values",TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "Please Enter the values", Toast.LENGTH_SHORT).show();

                }else{
                    Float f1=Float.parseFloat(s1);
                    Float f2=Float.parseFloat(s2);
                    Float f3=f1-f2;
                    String s3=Float.toString(f3);
                    t1.setText(s3);
                    ts.speak("The Result is"+ s3,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "The Result is "+s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    ts.speak("Please Enter the values",TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "Please Enter the values", Toast.LENGTH_SHORT).show();

                }else{
                    Float f1=Float.parseFloat(s1);
                    Float f2=Float.parseFloat(s2);
                    Float f3=f1/f2;
                    String s3=Float.toString(f3);
                    t1.setText(s3);
                    ts.speak("The Result is"+ s3,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "The Result is "+s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    ts.speak("Please Enter the values",TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "Please Enter the values", Toast.LENGTH_SHORT).show();

                }else{
                    Float f1=Float.parseFloat(s1);
                    Float f2=Float.parseFloat(s2);
                    Float f3=f1*f2;
                    String s3=Float.toString(f3);
                    t1.setText(s3);
                    ts.speak("The Result is "+ s3,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(Calculator.this, "The Result is "+s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
