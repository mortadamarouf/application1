package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    EditText name
    EditText password;
    EditText email;
    TextView save;
    FirebaseAuth mAuth;
   // Object view;
    // private Object String;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        mAuth= FirebaseAuth.getInstance();

        name = findViewById(R.id.TextView2a2);
        password = findViewById(R.id.TextView3a2);
        email = findViewById(R.id.TextView4a3);
        save = findViewById(R.id.TextView5a4);



    }


    public void doSignUp(View view) {


        String email1 = email.getText().toString();
        String password1 = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            String uid = user.getUid();

                            Map<String,Object> data = new HashMap<>();
                            data.put("uid",uid);
                            FirebaseDatabase.getInstance().getReference("Users").child(uid).setValue(data)
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity2.this,"save", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Intent intent = new Intent(MainActivity2.this, login1.class);
                                            startActivity(intent);
                                        }
                                    });
                        }

                    }
                });




    }
}



