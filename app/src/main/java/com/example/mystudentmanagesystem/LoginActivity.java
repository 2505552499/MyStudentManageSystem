package com.example.mystudentmanagesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mystudentmanagesystem.SQLite.MyHelper;

public class LoginActivity extends AppCompatActivity {
    MyHelper myHelper;
    EditText et_username;
    EditText et_password;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myHelper = new MyHelper(this);
        myHelper.getReadableDatabase();
        Button loginbtn = (Button) findViewById(R.id.btn_login);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                if(username.equals("admin") && password.equals("123456")){
                    intent.putExtra("name", username);
                    intent.putExtra("pwd", password);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "账号或密码输入错误，请重试！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button register_btn = (Button) findViewById(R.id.btn_register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}