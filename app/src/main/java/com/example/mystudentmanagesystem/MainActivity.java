package com.example.mystudentmanagesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView welcome_tv;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        username = intent.getStringExtra("name");
        welcome_tv = (TextView) findViewById(R.id.tv_welcome);
        welcome_tv.setText("欢迎您：" + username);

        Button query_btn = (Button) findViewById(R.id.btn_query);
        query_btn.setOnClickListener(this);
        Button add_btn = (Button) findViewById(R.id.btn_add);
        add_btn.setOnClickListener(this);
        Button update_btn = (Button) findViewById(R.id.btn_update);
        update_btn.setOnClickListener(this);
        Button delete_btn = (Button) findViewById(R.id.btn_delete);
        delete_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_query:
                Intent intent1 = new Intent(this, QueryActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_add:
                Intent intent2 = new Intent(this, AddActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_update:
                Intent intent3 = new Intent(this, UpdateActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_delete:
                Intent intent4 = new Intent(this, DeleteActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}