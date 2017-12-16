package com.example.guillaume.tp2_android_database;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Guillaume on 24/11/2017.
 */

public class RegisterUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Button btn_validateUser = findViewById(R.id.btn_validateUser);
        Button btn_cancelUser = findViewById(R.id.btn_cancelUser);
        if (btn_validateUser != null) {btn_validateUser.setOnClickListener(validate);}
        if (btn_cancelUser != null) {btn_cancelUser.setOnClickListener(cancel);}





    }

    private View.OnClickListener validate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Database myDatabase = new Database(RegisterUser.this);

            EditText editTextUserId = (EditText)findViewById(R.id.editTextUserId);
            EditText editTextUserName = (EditText) findViewById(R.id.editTextUserName);
            EditText editTextUserPhone = (EditText) findViewById(R.id.editTextUserPhone);

            int userId = 0;
            try {
                userId = Integer.parseInt(editTextUserId.getText().toString());
            } catch(NumberFormatException nfe){
                System.out.println("Could not parse : "+nfe);
            }
            String userName = editTextUserName.getText().toString();
            String userPhone = editTextUserPhone.getText().toString();
            User user = new User(userId, userName, userPhone);

            myDatabase.open();

            myDatabase.insertUser(user);

            User userFromBdd = myDatabase.getUserWithId(user.getId());

            if(userFromBdd != null){
                String userIs = userFromBdd.toString();
                Toast.makeText(RegisterUser.this, userIs, Toast.LENGTH_LONG).show();
            }

            myDatabase.close();
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
