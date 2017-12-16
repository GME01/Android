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

public class RegisterPet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pet);

        Button btn_validatePet = findViewById(R.id.btn_validatePet);
        Button btn_cancelPet = findViewById(R.id.btn_cancelPet);
        if (btn_validatePet != null) {btn_validatePet.setOnClickListener(validate);}
        if (btn_cancelPet != null) {btn_cancelPet.setOnClickListener(cancel);}





    }

    private View.OnClickListener validate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Database myDatabase = new Database(RegisterPet.this);

            EditText editTextPetName = (EditText)findViewById(R.id.editTextPetName);
            EditText editTextPetSpecies = (EditText) findViewById(R.id.editTextPetSpecies);
            EditText editTextPetOwner = (EditText) findViewById(R.id.editTextPetOwnerId);

            int ownerId = 0;
            try {
                ownerId = Integer.parseInt(editTextPetOwner.getText().toString());
            } catch(NumberFormatException nfe){
                System.out.println("Could not parse : "+nfe);
            }
            String petName = editTextPetName.getText().toString();
            String petSpecies = editTextPetSpecies.getText().toString();

            Pet pet = new Pet(petName, petSpecies, ownerId);

            myDatabase.open();

            myDatabase.insertPet(pet);

            Pet petFromBdd = myDatabase.getPetWithName(pet.getName());

            if(petFromBdd != null){
                String petIs = petFromBdd.toString();
                Toast.makeText(RegisterPet.this, petIs, Toast.LENGTH_LONG).show();
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
