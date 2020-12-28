package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login1 extends AppCompatActivity {
    EditText emaillogin;
    EditText passworedlogin;
    Button login;
    FirebaseAuth mAuth ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        mAuth = FirebaseAuth.getInstance();


        emaillogin = findViewById(R.id.editTextTextEmailAddress2);
        passworedlogin = findViewById(R.id.editTextTextPassword2);
        login = findViewById(R.id.button2);


}

    public void doSignIn(View view) {



        mAuth.signInWithEmailAndPassword(emaillogin, passworedlogin)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            Intent intent = new Intent(login1.this, listtodo.class);
                            startActivity(intent);
//
                        } else {
                            Toast.makeText(login1.this, "not login",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login1.this, MainActivity2.class);
                            startActivity(intent);
                        }

                    }
                });
    }
    }