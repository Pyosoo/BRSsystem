package com.example.snstk.psrecord;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity{

    private EditText loginID;
    private EditText loginPW;
    private Button loginBtn;
    private Button Register;
    private Button experience;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        loginID = (EditText)findViewById(R.id.loginID);
        loginPW = (EditText)findViewById(R.id.loginPW);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        Register =  (Button)findViewById(R.id.Register);
        experience = (Button)findViewById(R.id.experience);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });


        //체험 클릭시 버튼없는 기록지화면으로 이동
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TempMainActivity.class);
                startActivity(intent);
            }
        });

        //회원가입 화면 으로 이동
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void userLogin(){
        String email = loginID.getText().toString().trim();
        String password = loginPW.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"please enter your google e-mail",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), ChoiceActivity.class));
                            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);

                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Login Fail, try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



}
