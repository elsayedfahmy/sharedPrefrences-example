package com.example.elsayedfahmy.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtname;
    EditText edtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname=(EditText)findViewById(R.id.edtName);
        edtid=(EditText)findViewById(R.id.edtid);

        final  SharedPreferences shared =getSharedPreferences("data",MODE_PRIVATE);
      Button btnsave=(Button)findViewById(R.id.btnsave);




        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtname.getText().toString();
                String id=edtid.getText().toString();
                sharedPreferencesclass yourPrefrence = new  sharedPreferencesclass(MainActivity.this);
                // yourPrefrence.saveData(name,id);

                   // if you want write  by key value
                yourPrefrence.saveData_by_key("name",name);
                yourPrefrence.saveData_by_key("id",id);
                Toast.makeText(MainActivity.this,"thanks....",Toast.LENGTH_LONG).show();
            }
        });
        Button btnread=(Button)findViewById(R.id.btnread);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferencesclass yourPrefrence = new  sharedPreferencesclass(MainActivity.this);
                // String value = yourPrefrence.getData();
               // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();

                // if you want  read by key value
                String name_value = yourPrefrence.getData_by_key("name");
                String id_value = yourPrefrence.getData_by_key("id");
                Toast.makeText(MainActivity.this,"name = "+name_value +" , "+"id = "+id_value,Toast.LENGTH_LONG).show();
            }
        });

    }

}
