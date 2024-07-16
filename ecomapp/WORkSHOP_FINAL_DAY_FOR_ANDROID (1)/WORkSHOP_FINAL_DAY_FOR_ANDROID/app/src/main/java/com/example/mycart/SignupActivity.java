package com.example.mycart;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mycart.databinding.ActivitySignupBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySignupBinding binding;

    String email ;
    String password ;

    // Step 1 Variable Initialise
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // Second Step
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        binding.loginBtn.setOnClickListener(view -> {
            openActivity(LoginActivity.class);
        });


        binding.signupBtn.setOnClickListener(view -> {
            email = binding.emailEdtText.getText().toString();
            password = binding.passEdtText.getText().toString();


            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please Enter All Fields",Toast.LENGTH_SHORT).show();
            }else {
                registerUser();

            }


        });

    }

    private void registerUser(){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            openActivity(MainActivity.class);

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


    private void openActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
