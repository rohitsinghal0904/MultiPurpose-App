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

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(MainActivity.this, "Please Fill All details", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("task",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar, username varchar, email varchar, password varchar)");
                    String s5="select * from student where username= '"+s1+"' and password='"+s2+"' ";
                    Cursor c1=sql.rawQuery(s5,null);
                    if(c1.getCount()>0){
                        Toast.makeText(MainActivity.this, "Login Done", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(MainActivity.this,Media.class);
                        startActivity(j);
                        finish();
                    }else {
                        Toast.makeText(MainActivity.this, "Invalid username or Password ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
