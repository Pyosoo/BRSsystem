package com.example.snstk.psrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChoiceActivity extends AppCompatActivity {

    TextView choice1; //기록지
    TextView choice2; //검색창
    TextView choice3; //랭킹
    Button logout;
    Button choice_before_button;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user= firebaseAuth.getCurrentUser();


        choice1 = (TextView)findViewById(R.id.choice1);
        choice2 = (TextView)findViewById(R.id.choice2);
        choice3 = (TextView)findViewById(R.id.choice3);
        logout = (Button)findViewById(R.id.logout);
        choice_before_button = (Button)findViewById(R.id.choice_before_button);


        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //기록지
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {//검색창
            @Override
            public void onClick(View v) {
           //     Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchPrac.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //로그아웃
                firebaseAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });

        choice_before_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });


    }

}
