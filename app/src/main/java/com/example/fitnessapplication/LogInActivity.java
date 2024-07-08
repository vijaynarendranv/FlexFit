package com.example.fitnessapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogInActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText loginemail,loginpassword;
    private TextView signupRed;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        auth =FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LogInActivity.this, MainActivity.class));
            finish();
        }

        loginemail=findViewById(R.id.login_mail);
        loginpassword=findViewById(R.id.login_password);
        signupRed=findViewById(R.id.sigupRed);
        loginButton=findViewById(R.id.lbtn);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=loginemail.getText().toString();
                String pass= loginpassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    if(!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LogInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener(){
                            @Override
                            public void onFailure(@NonNull Exception e){
                                Toast.makeText(LogInActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                            }
                                });
                    }else{
                        loginpassword.setError("Password cannot be  empty");
                    }
                }else if(email.isEmpty()){
                    loginemail.setError("Email. cannot be empty");
                }else{
                    loginemail.setError("Please Enter valid Email");
                }
            }
        });
                signupRed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
                    }
                });



    }
}