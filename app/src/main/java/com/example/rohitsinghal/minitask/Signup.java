package com.example.rohitsinghal.minitask;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e4.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Signup.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if(s1.equals("") || s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(Signup.this, "Please Fill all Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("task",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar, username varchar, email varchar, password varchar)");
                    String s5="select * from student where username= '"+s2+"' ";
                    Cursor c1=sql.rawQuery(s5,null);
                    if(c1.getCount()>0){
                        Toast.makeText(Signup.this, "Username already Exist", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sql.execSQL("insert into student values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                        Toast.makeText(Signup.this, "Registration Done", Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(Signup.this,MainActivity.class);
                        startActivity(k);
                        finish();
                    }
                }

            }
        });

    }
}
