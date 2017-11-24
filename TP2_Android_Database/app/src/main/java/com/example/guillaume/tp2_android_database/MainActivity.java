package com.example.guillaume.tp2_android_database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_registerUser = findViewById(R.id.btn_registerUser);
        if (btn_registerUser != null) {
            btn_registerUser.setOnClickListener(registerUserLayout);
        }

    }


    private View.OnClickListener registerUserLayout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentRegisterUser = new Intent (MainActivity.this, RegisterUser.class);
            startActivity(intentRegisterUser);
        }

    };
}
