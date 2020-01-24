package com.example.snstk.psrecord;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    TextView IDtextView;
    TextView PWtextView;
    EditText IDeditText;
    EditText PWeditText;
    Button loginCheck;
    Button RegisterCancel;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        IDtextView = (TextView)findViewById(R.id.IDtextView);
        PWtextView = (TextView)findViewById(R.id.PWtextView);
        IDeditText = (EditText)findViewById(R.id.IDeditText);
        PWeditText = (EditText)findViewById(R.id.PWeditText);
        loginCheck = (Button)findViewById(R.id.loginCheck);
        RegisterCancel = (Button)findViewById(R.id.RegisterCancel);



        RegisterCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다시 로그인 화면으로 이동
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        loginCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser(){
        String email = IDeditText.getText().toString().trim();
        String password = PWeditText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"please enter e-mail",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //user is successfully registered and logged in
                            //we will start the profile activity here
                            finish();
                            Toast.makeText(RegisterActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"Register Fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
