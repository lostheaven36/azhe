package com.example.renji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences sharedPreferences=getSharedPreferences("sp1",MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("Name","");
        editor.putString("Password","");
        editor.commit();

        TextView name=(TextView)findViewById(R.id.name);
        TextView password=(TextView)findViewById(R.id.password);

        final String stringName = sharedPreferences.getString("Name", "");
        final String name_input = name.getText().toString();
        final String stringPassword = sharedPreferences.getString("Password", "");
        final String password_input=password.getText().toString();

        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password_input.equals(stringPassword))
                {
                    Intent it=new Intent();
                    it.setClass(login.this,MainActivity.class);
                    login.this.startActivity(it);
                }
                else
                {
                    Toast toast=Toast.makeText(login.this, "用户名或密码错误", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

}