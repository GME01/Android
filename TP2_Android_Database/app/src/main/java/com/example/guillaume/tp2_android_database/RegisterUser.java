package com.example.guillaume.tp2_android_database;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Guillaume on 24/11/2017.
 */

public class RegisterUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Button btn_validateUser = findViewById(R.id.btn_validateUser);
        Button btn_cancelUser = findViewById(R.id.btn_cancel);
        if (btn_validateUser != null) {btn_validateUser.setOnClickListener(validate);}
        if (btn_cancelUser != null) {btn_cancelUser.setOnClickListener(cancel);}
    }

    private View.OnClickListener validate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };



}
