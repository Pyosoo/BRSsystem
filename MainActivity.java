package com.example.snstk.psrecord;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity { //implements View~ 는 새로추가한것 팝업창 띄우려고

    private int scoreboardNum = 0;

    VideoView videoview;
    TextView Quarter_Text;
    EditText home_name;
    EditText away_name;
    TextView home_score;
    TextView away_score;
    TextView quarter;
    TextView home_team_foul;
    TextView away_team_foul;
    Button home_up;
    Button home_down;
    Button away_up;
    Button away_down;
    Button main_back_button;

    TextView teamfoul1;
    TextView teamfoul2;
    TextView playerscore;
    TextView playerrebound;
    TextView playerassist;
    TextView playerfoul;
    TextView playeredit;
    TextView playtime;
    Button reset;
    Button upload;
    EditText gamedate;
  //  EditText game_year;
   // EditText game_month;
   // EditText game_day;

    int homecount = 0;
    int awaycount = 0;
    int quartercount = 0;
    int home_team_foul_count = 0;
    int away_team_foul_count = 0;

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    LinearLayout layout6;
    LinearLayout layout7;
    LinearLayout layout8;
    LinearLayout layout9;
    LinearLayout layout10;
    LinearLayout layout11;
    LinearLayout layout12;

    //선수 관련 id들 ↓↓

    TextView playername;

    EditText home_player1;
    TextView player1_score;
    TextView player1_rebound;
    TextView player1_assist;
    TextView player1_foul;
    Button home_player1_edit;
    TextView player1_playtime;

    EditText home_player2;
    TextView player2_score;
    TextView player2_rebound;
    TextView player2_assist;
    TextView player2_foul;
    Button home_player2_edit;
    TextView player2_playtime;

    EditText home_player3;
    TextView player3_score;
    TextView player3_rebound;
    TextView player3_assist;
    TextView player3_foul;
    Button home_player3_edit;
    TextView player3_playtime;

    EditText home_player4;
    TextView player4_score;
    TextView player4_rebound;
    TextView player4_assist;
    TextView player4_foul;
    Button home_player4_edit;
    TextView player4_playtime;

    EditText home_player5;
    TextView player5_score;
    TextView player5_rebound;
    TextView player5_assist;
    TextView player5_foul;
    Button home_player5_edit;
    TextView player5_playtime;

    EditText home_player6;
    TextView player6_score;
    TextView player6_rebound;
    TextView player6_assist;
    TextView player6_foul;
    Button home_player6_edit;
    TextView player6_playtime;

    EditText home_player7;
    TextView player7_score;
    TextView player7_rebound;
    TextView player7_assist;
    TextView player7_foul;
    Button home_player7_edit;
    TextView player7_playtime;

    EditText home_player8;
    TextView player8_score;
    TextView player8_rebound;
    TextView player8_assist;
    TextView player8_foul;
    Button home_player8_edit;
    TextView player8_playtime;

    EditText home_player9;
    TextView player9_score;
    TextView player9_rebound;
    TextView player9_assist;
    TextView player9_foul;
    Button home_player9_edit;
    TextView player9_playtime;

    EditText home_player10;
    TextView player10_score;
    TextView player10_rebound;
    TextView player10_assist;
    TextView player10_foul;
    Button home_player10_edit;
    TextView player10_playtime;

    EditText home_player11;
    TextView player11_score;
    TextView player11_rebound;
    TextView player11_assist;
    TextView player11_foul;
    Button home_player11_edit;
    TextView player11_playtime;

    //선수 개인 기록 관련 변수들 ↓↓
    int home_player1_score = 0;
    int home_player1_rebound = 0;
    int home_player1_assist = 0;
    int home_player1_foul = 0;

    int home_player2_score = 0;
    int home_player2_rebound = 0;
    int home_player2_assist = 0;
    int home_player2_foul = 0;

    int home_player3_score = 0;
    int home_player3_rebound = 0;
    int home_player3_assist = 0;
    int home_player3_foul = 0;

    int home_player4_score = 0;
    int home_player4_rebound = 0;
    int home_player4_assist = 0;
    int home_player4_foul = 0;

    int home_player5_score = 0;
    int home_player5_rebound = 0;
    int home_player5_assist = 0;
    int home_player5_foul = 0;

    int home_player6_score = 0;
    int home_player6_rebound = 0;
    int home_player6_assist = 0;
    int home_player6_foul = 0;

    int home_player7_score = 0;
    int home_player7_rebound = 0;
    int home_player7_assist = 0;
    int home_player7_foul = 0;

    int home_player8_score = 0;
    int home_player8_rebound = 0;
    int home_player8_assist = 0;
    int home_player8_foul = 0;

    int home_player9_score = 0;
    int home_player9_rebound = 0;
    int home_player9_assist = 0;
    int home_player9_foul = 0;

    int home_player10_score = 0;
    int home_player10_rebound = 0;
    int home_player10_assist = 0;
    int home_player10_foul = 0;

    int home_player11_score = 0;
    int home_player11_rebound = 0;
    int home_player11_assist = 0;
    int home_player11_foul = 0;



    //player time 함수 선언들

    int currentstate1 = 0; //0은 멈춤, 1은 실행
    int player1_playtime_value1 = 0; // 10분 단위
    int player1_playtime_value2 = 0; // 1분 단위
    int player1_playtime_value3 = 0; // 10초 단위
    int player1_playtime_value4 = 0; // 1초 단위

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            player1_playtime_value4++;
            if(player1_playtime_value4 >= 10){
                player1_playtime_value3 += 1;
                player1_playtime_value4 = 0;
            }
            if(player1_playtime_value3 >= 6){
                player1_playtime_value2 += 1;
                player1_playtime_value3 = 0;
            }
            if(player1_playtime_value2 >= 10){
                player1_playtime_value1 += 1;
                player1_playtime_value2 = 0;
            }
            player1_playtime.setText(""+player1_playtime_value1 + player1_playtime_value2 + ":" + player1_playtime_value3 +player1_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate2 = 0; //0은 멈춤, 1은 실행
    int player2_playtime_value1 = 0; // 10분 단위
    int player2_playtime_value2 = 0; // 1분 단위
    int player2_playtime_value3 = 0; // 10초 단위
    int player2_playtime_value4 = 0; // 1초 단위

    Handler mHandler2 = new Handler() {
        public void handleMessage(Message msg) {
            player2_playtime_value4++;
            if(player2_playtime_value4 >= 10){
                player2_playtime_value3 += 1;
                player2_playtime_value4 = 0;
            }
            if(player2_playtime_value3 >= 6){
                player2_playtime_value2 += 1;
                player2_playtime_value3 = 0;
            }
            if(player2_playtime_value2 >= 10){
                player2_playtime_value1 += 1;
                player2_playtime_value2 = 0;
            }
            player2_playtime.setText(""+player2_playtime_value1 + player2_playtime_value2 + ":" + player2_playtime_value3 +player2_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler2.sendEmptyMessageDelayed(0,1000);
        }
    };


    int currentstate3 = 0; //0은 멈춤, 1은 실행
    int player3_playtime_value1 = 0; // 10분 단위
    int player3_playtime_value2 = 0; // 1분 단위
    int player3_playtime_value3 = 0; // 10초 단위
    int player3_playtime_value4 = 0; // 1초 단위

    Handler mHandler3 = new Handler() {
        public void handleMessage(Message msg) {
            player3_playtime_value4++;
            if(player3_playtime_value4 >= 10){
                player3_playtime_value3 += 1;
                player3_playtime_value4 = 0;
            }
            if(player3_playtime_value3 >= 6){
                player3_playtime_value2 += 1;
                player3_playtime_value3 = 0;
            }
            if(player3_playtime_value2 >= 10){
                player3_playtime_value1 += 1;
                player3_playtime_value2 = 0;
            }
            player3_playtime.setText(""+player3_playtime_value1 + player3_playtime_value2 + ":" + player3_playtime_value3 +player3_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler3.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate4 = 0; //0은 멈춤, 1은 실행
    int player4_playtime_value1 = 0; // 10분 단위
    int player4_playtime_value2 = 0; // 1분 단위
    int player4_playtime_value3 = 0; // 10초 단위
    int player4_playtime_value4 = 0; // 1초 단위

    Handler mHandler4 = new Handler() {
        public void handleMessage(Message msg) {
            player4_playtime_value4++;
            if(player4_playtime_value4 >= 10){
                player4_playtime_value3 += 1;
                player4_playtime_value4 = 0;
            }
            if(player4_playtime_value3 >= 6){
                player4_playtime_value2 += 1;
                player4_playtime_value3 = 0;
            }
            if(player4_playtime_value2 >= 10){
                player4_playtime_value1 += 1;
                player4_playtime_value2 = 0;
            }
            player4_playtime.setText(""+player4_playtime_value1 + player4_playtime_value2 + ":" + player4_playtime_value3 +player4_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler4.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate5 = 0; //0은 멈춤, 1은 실행
    int player5_playtime_value1 = 0; // 10분 단위
    int player5_playtime_value2 = 0; // 1분 단위
    int player5_playtime_value3 = 0; // 10초 단위
    int player5_playtime_value4 = 0; // 1초 단위

    Handler mHandler5 = new Handler() {
        public void handleMessage(Message msg) {
            player5_playtime_value4++;
            if(player5_playtime_value4 >= 10){
                player5_playtime_value3 += 1;
                player5_playtime_value4 = 0;
            }
            if(player5_playtime_value3 >= 6){
                player5_playtime_value2 += 1;
                player5_playtime_value3 = 0;
            }
            if(player5_playtime_value2 >= 10){
                player5_playtime_value1 += 1;
                player5_playtime_value2 = 0;
            }
            player5_playtime.setText(""+player5_playtime_value1 + player5_playtime_value2 + ":" + player5_playtime_value3 +player5_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler5.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate6 = 0; //0은 멈춤, 1은 실행
    int player6_playtime_value1 = 0; // 10분 단위
    int player6_playtime_value2 = 0; // 1분 단위
    int player6_playtime_value3 = 0; // 10초 단위
    int player6_playtime_value4 = 0; // 1초 단위

    Handler mHandler6 = new Handler() {
        public void handleMessage(Message msg) {
            player6_playtime_value4++;
            if(player6_playtime_value4 >= 10){
                player6_playtime_value3 += 1;
                player6_playtime_value4 = 0;
            }
            if(player6_playtime_value3 >= 6){
                player6_playtime_value2 += 1;
                player6_playtime_value3 = 0;
            }
            if(player6_playtime_value2 >= 10){
                player6_playtime_value1 += 1;
                player6_playtime_value2 = 0;
            }
            player6_playtime.setText(""+player6_playtime_value1 + player6_playtime_value2 + ":" + player6_playtime_value3 +player6_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler6.sendEmptyMessageDelayed(0,1000);
        }
    };


    int currentstate7 = 0; //0은 멈춤, 1은 실행
    int player7_playtime_value1 = 0; // 10분 단위
    int player7_playtime_value2 = 0; // 1분 단위
    int player7_playtime_value3 = 0; // 10초 단위
    int player7_playtime_value4 = 0; // 1초 단위

    Handler mHandler7 = new Handler() {
        public void handleMessage(Message msg) {
            player7_playtime_value4++;
            if(player7_playtime_value4 >= 10){
                player7_playtime_value3 += 1;
                player7_playtime_value4 = 0;
            }
            if(player7_playtime_value3 >= 6){
                player7_playtime_value2 += 1;
                player7_playtime_value3 = 0;
            }
            if(player7_playtime_value2 >= 10){
                player7_playtime_value1 += 1;
                player7_playtime_value2 = 0;
            }
            player7_playtime.setText(""+player7_playtime_value1 + player7_playtime_value2 + ":" + player7_playtime_value3 +player7_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler7.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate8 = 0; //0은 멈춤, 1은 실행
    int player8_playtime_value1 = 0; // 10분 단위
    int player8_playtime_value2 = 0; // 1분 단위
    int player8_playtime_value3 = 0; // 10초 단위
    int player8_playtime_value4 = 0; // 1초 단위

    Handler mHandler8 = new Handler() {
        public void handleMessage(Message msg) {
            player8_playtime_value4++;
            if(player8_playtime_value4 >= 10){
                player8_playtime_value3 += 1;
                player8_playtime_value4 = 0;
            }
            if(player8_playtime_value3 >= 6){
                player8_playtime_value2 += 1;
                player8_playtime_value3 = 0;
            }
            if(player8_playtime_value2 >= 10){
                player8_playtime_value1 += 1;
                player8_playtime_value2 = 0;
            }
            player8_playtime.setText(""+player8_playtime_value1 + player8_playtime_value2 + ":" + player8_playtime_value3 +player8_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler8.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate9 = 0; //0은 멈춤, 1은 실행
    int player9_playtime_value1 = 0; // 10분 단위
    int player9_playtime_value2 = 0; // 1분 단위
    int player9_playtime_value3 = 0; // 10초 단위
    int player9_playtime_value4 = 0; // 1초 단위

    Handler mHandler9 = new Handler() {
        public void handleMessage(Message msg) {
            player9_playtime_value4++;
            if(player9_playtime_value4 >= 10){
                player9_playtime_value3 += 1;
                player9_playtime_value4 = 0;
            }
            if(player9_playtime_value3 >= 6){
                player9_playtime_value2 += 1;
                player9_playtime_value3 = 0;
            }
            if(player9_playtime_value2 >= 10){
                player9_playtime_value1 += 1;
                player9_playtime_value2 = 0;
            }
            player9_playtime.setText(""+player9_playtime_value1 + player9_playtime_value2 + ":" + player9_playtime_value3 +player9_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler9.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate10 = 0; //0은 멈춤, 1은 실행
    int player10_playtime_value1 = 0; // 10분 단위
    int player10_playtime_value2 = 0; // 1분 단위
    int player10_playtime_value3 = 0; // 10초 단위
    int player10_playtime_value4 = 0; // 1초 단위

    Handler mHandler10 = new Handler() {
        public void handleMessage(Message msg) {
            player10_playtime_value4++;
            if(player10_playtime_value4 >= 10){
                player10_playtime_value3 += 1;
                player10_playtime_value4 = 0;
            }
            if(player10_playtime_value3 >= 6){
                player10_playtime_value2 += 1;
                player10_playtime_value3 = 0;
            }
            if(player10_playtime_value2 >= 10){
                player10_playtime_value1 += 1;
                player10_playtime_value2 = 0;
            }
            player10_playtime.setText(""+player10_playtime_value1 + player10_playtime_value2 + ":" + player10_playtime_value3 +player10_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler10.sendEmptyMessageDelayed(0,1000);
        }
    };

    int currentstate11 = 0; //0은 멈춤, 1은 실행
    int player11_playtime_value1 = 0; // 10분 단위
    int player11_playtime_value2 = 0; // 1분 단위
    int player11_playtime_value3 = 0; // 10초 단위
    int player11_playtime_value4 = 0; // 1초 단위

    Handler mHandler11 = new Handler() {
        public void handleMessage(Message msg) {
            player11_playtime_value4++;
            if(player11_playtime_value4 >= 10){
                player11_playtime_value3 += 1;
                player11_playtime_value4 = 0;
            }
            if(player11_playtime_value3 >= 6){
                player11_playtime_value2 += 1;
                player11_playtime_value3 = 0;
            }
            if(player11_playtime_value2 >= 10){
                player11_playtime_value1 += 1;
                player11_playtime_value2 = 0;
            }
            player11_playtime.setText(""+player11_playtime_value1 + player11_playtime_value2 + ":" + player11_playtime_value3 +player11_playtime_value4);
            //   player1_playtime.setText(player1_playtime_value1+ player1_playtime_value2+":" + player1_playtime_value3 + player1_playtime_value4);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler11.sendEmptyMessageDelayed(0,1000);
        }
    };


    String shared = "file";
    //======================

    DatabaseReference databaseReference; //팀 기록 저장을 위한 Reference
    DatabaseReference databaseReference2; //선수 기록 저장을 위한 Reference
    DatabaseReference databaseReference3; // player2를 넣긴위한것
    DatabaseReference databaseReference4; // 3을 넣기 위함
    DatabaseReference databaseReference5; // 4를 넣기 위함
    DatabaseReference databaseReference6; // 5를 넣기 위함
    DatabaseReference databaseReference7; // 6을 넣기 위함
    DatabaseReference databaseReference8; // 7을 넣기 위함
    DatabaseReference databaseReference9; // 8을 넣기 위함
    DatabaseReference databaseReference10; // 9를 넣기 위함
    DatabaseReference databaseReference11; // 10을 넣기 위함
    DatabaseReference databaseReference12; // 12를 넣기 위함

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ==============================================================================================================            onCreate 시작
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SharedPreferences sp = getSharedPreferences(shared,0);
        int gamecount = sp.getInt("jeon",0);
        scoreboardNum = gamecount;

        databaseReference = FirebaseDatabase.getInstance().getReference("Scoreboard" ); // "Scoreboard"+scoreboardNum이었음
        databaseReference2 = FirebaseDatabase.getInstance().getReference();
        databaseReference3 = FirebaseDatabase.getInstance().getReference();

        videoview = (VideoView)findViewById(R.id.videoview);

        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ballflip));
        videoview.start();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout)findViewById(R.id.layout3);
        layout4 = (LinearLayout)findViewById(R.id.layout4);
        layout5 = (LinearLayout)findViewById(R.id.layout5);
        layout6 = (LinearLayout)findViewById(R.id.layout6);
        layout7 = (LinearLayout)findViewById(R.id.layout7);
        layout8 = (LinearLayout)findViewById(R.id.layout8);
        layout9 = (LinearLayout)findViewById(R.id.layout9);
        layout10 = (LinearLayout)findViewById(R.id.layout10);
        layout11 = (LinearLayout)findViewById(R.id.layout11);
        layout12 = (LinearLayout)findViewById(R.id.layout12);

        teamfoul1 = (TextView) findViewById(R.id.teamfoul1);
        teamfoul2 = (TextView) findViewById(R.id.teamfoul2);
        playerscore = (TextView) findViewById(R.id.playerscore);
        playerrebound = (TextView) findViewById(R.id.playerrebound);
        playerassist = (TextView) findViewById(R.id.playerassist);
        playerfoul = (TextView) findViewById(R.id.playerfoul);
        playeredit = (TextView)findViewById(R.id.playeredit);
        playtime = (TextView)findViewById(R.id.playtime);
        reset = (Button)findViewById(R.id.reset);
        upload = (Button)findViewById(R.id.upload);
        gamedate = (EditText)findViewById(R.id.gamedate);



        playername = (TextView) findViewById(R.id.playername);
        Quarter_Text = (TextView) findViewById(R.id.Quarter_Text);
        home_name = (EditText) findViewById(R.id.home_name);
        away_name = (EditText) findViewById(R.id.away_name);
        home_score = (TextView) findViewById(R.id.home_score);
        away_score = (TextView) findViewById(R.id.away_score);
        home_up = (Button) findViewById(R.id.home_up);
        home_down = (Button) findViewById(R.id.home_down);
        away_up = (Button) findViewById(R.id.away_up);
        away_down = (Button) findViewById(R.id.away_down);
        quarter = (TextView) findViewById(R.id.quarter);
        home_team_foul = (TextView) findViewById(R.id.home_team_foul);
        away_team_foul = (TextView) findViewById(R.id.away_team_foul);
        main_back_button = (Button)findViewById(R.id.main_back_button);

        //선수관련 id
        home_player1 = (EditText) findViewById(R.id.home_player1);
        player1_score = (TextView) findViewById(R.id.player1_score);
        player1_rebound = (TextView) findViewById(R.id.player1_rebound);
        player1_assist = (TextView) findViewById(R.id.player1_assist);
        player1_foul = (TextView) findViewById(R.id.player1_foul);
        home_player1_edit = (Button) findViewById(R.id.home_player1_edit);
        player1_playtime = (TextView)findViewById(R.id.player1_playtime);

        home_player2 = (EditText) findViewById(R.id.home_player2);
        player2_score = (TextView) findViewById(R.id.player2_score);
        player2_rebound = (TextView) findViewById(R.id.player2_rebound);
        player2_assist = (TextView) findViewById(R.id.player2_assist);
        player2_foul = (TextView) findViewById(R.id.player2_foul);
        home_player2_edit = (Button) findViewById(R.id.home_player2_edit);
        player2_playtime = (TextView)findViewById(R.id.player2_playtime);

        home_player3 = (EditText) findViewById(R.id.home_player3);
        player3_score = (TextView) findViewById(R.id.player3_score);
        player3_rebound = (TextView) findViewById(R.id.player3_rebound);
        player3_assist = (TextView) findViewById(R.id.player3_assist);
        player3_foul = (TextView) findViewById(R.id.player3_foul);
        home_player3_edit = (Button) findViewById(R.id.home_player3_edit);
        player3_playtime = (TextView)findViewById(R.id.player3_playtime);

        home_player4 = (EditText) findViewById(R.id.home_player4);
        player4_score = (TextView) findViewById(R.id.player4_score);
        player4_rebound = (TextView) findViewById(R.id.player4_rebound);
        player4_assist = (TextView) findViewById(R.id.player4_assist);
        player4_foul = (TextView) findViewById(R.id.player4_foul);
        home_player4_edit = (Button) findViewById(R.id.home_player4_edit);
        player4_playtime = (TextView)findViewById(R.id.player4_playtime);

        home_player5 = (EditText) findViewById(R.id.home_player5);
        player5_score = (TextView) findViewById(R.id.player5_score);
        player5_rebound = (TextView) findViewById(R.id.player5_rebound);
        player5_assist = (TextView) findViewById(R.id.player5_assist);
        player5_foul = (TextView) findViewById(R.id.player5_foul);
        home_player5_edit = (Button) findViewById(R.id.home_player5_edit);
        player5_playtime = (TextView)findViewById(R.id.player5_playtime);

        home_player6 = (EditText) findViewById(R.id.home_player6);
        player6_score = (TextView) findViewById(R.id.player6_score);
        player6_rebound = (TextView) findViewById(R.id.player6_rebound);
        player6_assist = (TextView) findViewById(R.id.player6_assist);
        player6_foul = (TextView) findViewById(R.id.player6_foul);
        home_player6_edit = (Button) findViewById(R.id.home_player6_edit);
        player6_playtime = (TextView)findViewById(R.id.player6_playtime);

        home_player7 = (EditText) findViewById(R.id.home_player7);
        player7_score = (TextView) findViewById(R.id.player7_score);
        player7_rebound = (TextView) findViewById(R.id.player7_rebound);
        player7_assist = (TextView) findViewById(R.id.player7_assist);
        player7_foul = (TextView) findViewById(R.id.player7_foul);
        home_player7_edit = (Button) findViewById(R.id.home_player7_edit);
        player7_playtime = (TextView)findViewById(R.id.player7_playtime);

        home_player8 = (EditText) findViewById(R.id.home_player8);
        player8_score = (TextView) findViewById(R.id.player8_score);
        player8_rebound = (TextView) findViewById(R.id.player8_rebound);
        player8_assist = (TextView) findViewById(R.id.player8_assist);
        player8_foul = (TextView) findViewById(R.id.player8_foul);
        home_player8_edit = (Button) findViewById(R.id.home_player8_edit);
        player8_playtime = (TextView)findViewById(R.id.player8_playtime);

        home_player9 = (EditText) findViewById(R.id.home_player9);
        player9_score = (TextView) findViewById(R.id.player9_score);
        player9_rebound = (TextView) findViewById(R.id.player9_rebound);
        player9_assist = (TextView) findViewById(R.id.player9_assist);
        player9_foul = (TextView) findViewById(R.id.player9_foul);
        home_player9_edit = (Button) findViewById(R.id.home_player9_edit);
        player9_playtime = (TextView)findViewById(R.id.player9_playtime);

        home_player10 = (EditText) findViewById(R.id.home_player10);
        player10_score = (TextView) findViewById(R.id.player10_score);
        player10_rebound = (TextView) findViewById(R.id.player10_rebound);
        player10_assist = (TextView) findViewById(R.id.player10_assist);
        player10_foul = (TextView) findViewById(R.id.player10_foul);
        home_player10_edit = (Button) findViewById(R.id.home_player10_edit);
        player10_playtime = (TextView)findViewById(R.id.player10_playtime);

        home_player11 = (EditText) findViewById(R.id.home_player11);
        player11_score = (TextView) findViewById(R.id.player11_score);
        player11_rebound = (TextView) findViewById(R.id.player11_rebound);
        player11_assist = (TextView) findViewById(R.id.player11_assist);
        player11_foul = (TextView) findViewById(R.id.player11_foul);
        home_player11_edit = (Button) findViewById(R.id.home_player11_edit);
        player11_playtime = (TextView)findViewById(R.id.player11_playtime);




        main_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);
                finish();
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_in);
            }
        });

        //==========================초기화 버튼===================================                           리셋

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 모든 변수 초기화 시키기?
            }
        });

        //======================================================================


        //===플레이어1 플레이타임=====================================================                       플레이타임
        player1_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate1 ==0) {
                    mHandler.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate1 = 1;
                }
                else if(currentstate1 == 1){
                    currentstate1 = 0;
                    mHandler.removeMessages(0);
                }
            }
        });
        player1_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler.removeMessages(0);
                player1_playtime_value1 = 0;
                player1_playtime_value2 = 0;
                player1_playtime_value3 = 0;
                player1_playtime_value4 = 0;
                currentstate1 = 0;
                player1_playtime.setText(""+player1_playtime_value1 + player1_playtime_value2 + ":" + player1_playtime_value3 +player1_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어2 플레이타임=====================================================
        player2_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate2 ==0) {
                    mHandler2.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate2 = 1;
                }
                else if(currentstate2 == 1){
                    currentstate2 = 0;
                    mHandler2.removeMessages(0);
                }
            }
        });
        player2_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler2.removeMessages(0);
                player2_playtime_value1 = 0;
                player2_playtime_value2 = 0;
                player2_playtime_value3 = 0;
                player2_playtime_value4 = 0;
                currentstate2 = 0;
                player2_playtime.setText(""+player2_playtime_value1 + player2_playtime_value2 + ":" + player2_playtime_value3 +player2_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어3 플레이타임=====================================================
        player3_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate3 ==0) {
                    mHandler3.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate3 = 1;
                }
                else if(currentstate3 == 1){
                    currentstate3 = 0;
                    mHandler3.removeMessages(0);
                }
            }
        });
        player3_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler3.removeMessages(0);
                player3_playtime_value1 = 0;
                player3_playtime_value2 = 0;
                player3_playtime_value3 = 0;
                player3_playtime_value4 = 0;
                currentstate3 = 0;
                player3_playtime.setText(""+player3_playtime_value1 + player3_playtime_value2 + ":" + player3_playtime_value3 +player3_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어4 플레이타임=====================================================
        player4_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate4 ==0) {
                    mHandler4.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate4 = 1;
                }
                else if(currentstate4 == 1){
                    currentstate4 = 0;
                    mHandler4.removeMessages(0);
                }
            }
        });
        player4_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler4.removeMessages(0);
                player4_playtime_value1 = 0;
                player4_playtime_value2 = 0;
                player4_playtime_value3 = 0;
                player4_playtime_value4 = 0;
                currentstate4 = 0;
                player4_playtime.setText(""+player4_playtime_value1 + player4_playtime_value2 + ":" + player4_playtime_value3 +player4_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어5 플레이타임=====================================================
        player5_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate5 ==0) {
                    mHandler5.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate5 = 1;
                }
                else if(currentstate5 == 1){
                    currentstate5 = 0;
                    mHandler5.removeMessages(0);
                }
            }
        });
        player5_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler5.removeMessages(0);
                player5_playtime_value1 = 0;
                player5_playtime_value2 = 0;
                player5_playtime_value3 = 0;
                player5_playtime_value4 = 0;
                currentstate5 = 0;
                player5_playtime.setText(""+player5_playtime_value1 + player5_playtime_value2 + ":" + player5_playtime_value3 +player5_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어6 플레이타임=====================================================
        player6_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate6 ==0) {
                    mHandler6.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate6 = 1;
                }
                else if(currentstate6 == 1){
                    currentstate6 = 0;
                    mHandler6.removeMessages(0);
                }
            }
        });
        player6_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler6.removeMessages(0);
                player6_playtime_value1 = 0;
                player6_playtime_value2 = 0;
                player6_playtime_value3 = 0;
                player6_playtime_value4 = 0;
                currentstate6 = 0;
                player6_playtime.setText(""+player6_playtime_value1 + player6_playtime_value2 + ":" + player6_playtime_value3 +player6_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어7 플레이타임=====================================================
        player7_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate7 ==0) {
                    mHandler7.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate7 = 1;
                }
                else if(currentstate7 == 1){
                    currentstate7 = 0;
                    mHandler7.removeMessages(0);
                }
            }
        });
        player7_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler7.removeMessages(0);
                player7_playtime_value1 = 0;
                player7_playtime_value2 = 0;
                player7_playtime_value3 = 0;
                player7_playtime_value4 = 0;
                currentstate7 = 0;
                player7_playtime.setText(""+player7_playtime_value1 + player7_playtime_value2 + ":" + player7_playtime_value3 +player7_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어8 플레이타임=====================================================
        player8_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate8 ==0) {
                    mHandler8.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate8 = 1;
                }
                else if(currentstate8 == 1){
                    currentstate8 = 0;
                    mHandler8.removeMessages(0);
                }
            }
        });
        player8_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler8.removeMessages(0);
                player8_playtime_value1 = 0;
                player8_playtime_value2 = 0;
                player8_playtime_value3 = 0;
                player8_playtime_value4 = 0;
                currentstate8 = 0;
                player8_playtime.setText(""+player8_playtime_value1 + player8_playtime_value2 + ":" + player8_playtime_value3 +player8_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어9 플레이타임=====================================================
        player9_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate9 ==0) {
                    mHandler9.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate9 = 1;
                }
                else if(currentstate9 == 1){
                    currentstate9 = 0;
                    mHandler9.removeMessages(0);
                }
            }
        });
        player9_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler9.removeMessages(0);
                player9_playtime_value1 = 0;
                player9_playtime_value2 = 0;
                player9_playtime_value3 = 0;
                player9_playtime_value4 = 0;
                currentstate9 = 0;
                player9_playtime.setText(""+player9_playtime_value1 + player9_playtime_value2 + ":" + player9_playtime_value3 +player9_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어10 플레이타임=====================================================
        player10_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate10 ==0) {
                    mHandler10.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate10 = 1;
                }
                else if(currentstate10 == 1){
                    currentstate10 = 0;
                    mHandler10.removeMessages(0);
                }
            }
        });
        player10_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler10.removeMessages(0);
                player10_playtime_value1 = 0;
                player10_playtime_value2 = 0;
                player10_playtime_value3 = 0;
                player10_playtime_value4 = 0;
                currentstate10 = 0;
                player10_playtime.setText(""+player10_playtime_value1 + player10_playtime_value2 + ":" + player10_playtime_value3 +player10_playtime_value4);
                return true;
            }
        });
        //==========================================================================

        //===플레이어11 플레이타임=====================================================
        player11_playtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentstate11 ==0) {
                    mHandler11.sendEmptyMessage(0); //클릭시 핸들러에 메세지 전달
                    currentstate11 = 1;
                }
                else if(currentstate11 == 1){
                    currentstate11 = 0;
                    mHandler11.removeMessages(0);
                }
            }
        });
        player11_playtime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mHandler11.removeMessages(0);
                player11_playtime_value1 = 0;
                player11_playtime_value2 = 0;
                player11_playtime_value3 = 0;
                player11_playtime_value4 = 0;
                currentstate11 = 0;
                player11_playtime.setText(""+player11_playtime_value1 + player11_playtime_value2 + ":" + player11_playtime_value3 +player11_playtime_value4);
                return true;
            }
        });
        //==========================================================================




        //=======================================================================
        //점수판에 대한 버튼 ======================================================                                        점수판
        home_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   String str = sf.getString("0", "");
                // homecount = Integer.parseInt(str);
                homecount++;
                home_score.setText(String.format("%d", homecount));
            }
        });

        home_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homecount <= 0) {
                    homecount = 0;
                } else {
                    homecount--;
                }
                home_score.setText(String.format("%d", homecount));
            }
        });

        away_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awaycount++;
                away_score.setText(String.format("%d", awaycount));
            }
        });

        away_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awaycount <= 0) {
                    awaycount = 0;
                } else {
                    awaycount--;
                }
                away_score.setText(String.format("%d", awaycount));
            }
        });

        quarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quartercount++;
                if (quartercount > 4) {
                    quartercount = 1;
                }
                quarter.setText(String.format("%d", quartercount));
            }
        });

        home_team_foul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_team_foul_count++;
                if (home_team_foul_count > 5) {
                    home_team_foul_count = 0;
                }
                home_team_foul.setText(String.format("%d", home_team_foul_count));
            }
        });

        away_team_foul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                away_team_foul_count++;
                if (away_team_foul_count > 5) {
                    away_team_foul_count = 0;
                }
                away_team_foul.setText(String.format("%d", away_team_foul_count));
            }
        });

        //==========================================================================================
        //=====================================PLAYER 1 EDIT========================================                    player1 Edit
        //==========================================================================================
        home_player1_edit = (Button) findViewById(R.id.home_player1_edit);
        home_player1_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player1.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player1_score++;
                                    player1_score.setText(String.format("%d", home_player1_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player1_score += 2;
                                    player1_score.setText(String.format("%d", home_player1_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player1_score += 3;
                                    player1_score.setText(String.format("%d", home_player1_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player1_rebound++;
                                    player1_rebound.setText(String.format("%d", home_player1_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player1_assist++;
                                    player1_assist.setText(String.format("%d", home_player1_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player1_foul++;
                                    player1_foul.setText(String.format("%d", home_player1_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player1_score--;
                                    player1_score.setText(String.format("%d", home_player1_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player1_rebound--;
                                    player1_rebound.setText(String.format("%d", home_player1_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player1_assist--;
                                    player1_assist.setText(String.format("%d", home_player1_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player1_foul--;
                                    player1_foul.setText(String.format("%d", home_player1_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        //==========================================================================================
        //=================================PLAYER 2 EDIT============================================
        //==========================================================================================
        home_player2_edit = (Button) findViewById(R.id.home_player2_edit);
        home_player2_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player2.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player2_score++;
                                    player2_score.setText(String.format("%d", home_player2_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player2_score += 2;
                                    player2_score.setText(String.format("%d", home_player2_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player2_score += 3;
                                    player2_score.setText(String.format("%d", home_player2_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player2_rebound++;
                                    player2_rebound.setText(String.format("%d", home_player2_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player2_assist++;
                                    player2_assist.setText(String.format("%d", home_player2_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player2_foul++;
                                    player2_foul.setText(String.format("%d", home_player2_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player2_score--;
                                    player2_score.setText(String.format("%d", home_player2_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player2_rebound--;
                                    player2_rebound.setText(String.format("%d", home_player2_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player2_assist--;
                                    player2_assist.setText(String.format("%d", home_player2_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player2_foul--;
                                    player2_foul.setText(String.format("%d", home_player2_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });


        //==========================================================================================
        //=================================PLAYER 3 EDIT============================================
        //==========================================================================================
        home_player3_edit = (Button) findViewById(R.id.home_player3_edit);
        home_player3_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player3.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player3_score++;
                                    player3_score.setText(String.format("%d", home_player3_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player3_score += 2;
                                    player3_score.setText(String.format("%d", home_player3_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player3_score += 3;
                                    player3_score.setText(String.format("%d", home_player3_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player3_rebound++;
                                    player3_rebound.setText(String.format("%d", home_player3_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player3_assist++;
                                    player3_assist.setText(String.format("%d", home_player3_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player3_foul++;
                                    player3_foul.setText(String.format("%d", home_player3_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player3_score--;
                                    player3_score.setText(String.format("%d", home_player3_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player3_rebound--;
                                    player3_rebound.setText(String.format("%d", home_player3_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player3_assist--;
                                    player3_assist.setText(String.format("%d", home_player3_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player3_foul--;
                                    player3_foul.setText(String.format("%d", home_player3_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        //==========================================================================================
        //=================================PLAYER 4 EDIT============================================
        //==========================================================================================
        home_player4_edit = (Button) findViewById(R.id.home_player4_edit);
        home_player4_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player4.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player4_score++;
                                    player4_score.setText(String.format("%d", home_player4_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player4_score += 2;
                                    player4_score.setText(String.format("%d", home_player4_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player4_score += 3;
                                    player4_score.setText(String.format("%d", home_player4_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player4_rebound++;
                                    player4_rebound.setText(String.format("%d", home_player4_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player4_assist++;
                                    player4_assist.setText(String.format("%d", home_player4_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player4_foul++;
                                    player4_foul.setText(String.format("%d", home_player4_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player4_score--;
                                    player4_score.setText(String.format("%d", home_player4_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player4_rebound--;
                                    player4_rebound.setText(String.format("%d", home_player4_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player4_assist--;
                                    player4_assist.setText(String.format("%d", home_player4_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player4_foul--;
                                    player4_foul.setText(String.format("%d", home_player4_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        //==========================================================================================
        //=================================PLAYER 5 EDIT============================================
        //==========================================================================================
        home_player5_edit = (Button) findViewById(R.id.home_player5_edit);
        home_player5_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player5.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player5_score++;
                                    player5_score.setText(String.format("%d", home_player5_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player5_score += 2;
                                    player5_score.setText(String.format("%d", home_player5_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player5_score += 3;
                                    player5_score.setText(String.format("%d", home_player5_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player5_rebound++;
                                    player5_rebound.setText(String.format("%d", home_player5_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player5_assist++;
                                    player5_assist.setText(String.format("%d", home_player5_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player5_foul++;
                                    player5_foul.setText(String.format("%d", home_player5_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player5_score--;
                                    player5_score.setText(String.format("%d", home_player5_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player5_rebound--;
                                    player5_rebound.setText(String.format("%d", home_player5_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player5_assist--;
                                    player5_assist.setText(String.format("%d", home_player5_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player5_foul--;
                                    player5_foul.setText(String.format("%d", home_player5_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });

        //==========================================================================================
        //=================================PLAYER 6 EDIT============================================
        //==========================================================================================
        home_player6_edit = (Button) findViewById(R.id.home_player6_edit);
        home_player6_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점","리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player6.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player6_score++;
                                    player6_score.setText(String.format("%d", home_player6_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player6_score += 2;
                                    player6_score.setText(String.format("%d", home_player6_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player6_score += 3;
                                    player6_score.setText(String.format("%d", home_player6_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player6_rebound++;
                                    player6_rebound.setText(String.format("%d", home_player6_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player6_assist++;
                                    player6_assist.setText(String.format("%d", home_player6_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player6_foul++;
                                    player6_foul.setText(String.format("%d", home_player6_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player6_score--;
                                    player6_score.setText(String.format("%d", home_player6_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player6_rebound--;
                                    player6_rebound.setText(String.format("%d", home_player6_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player6_assist--;
                                    player6_assist.setText(String.format("%d", home_player6_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player6_foul--;
                                    player6_foul.setText(String.format("%d", home_player6_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });
        //==========================================================================================
        //=================================PLAYER 7 EDIT============================================
        //==========================================================================================
        home_player7_edit = (Button) findViewById(R.id.home_player7_edit);
        home_player7_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어이스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player7.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player7_score++;
                                    player7_score.setText(String.format("%d", home_player7_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player7_score += 2;
                                    player7_score.setText(String.format("%d", home_player7_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player7_score += 3;
                                    player7_score.setText(String.format("%d", home_player7_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player7_rebound++;
                                    player7_rebound.setText(String.format("%d", home_player7_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player7_assist++;
                                    player7_assist.setText(String.format("%d", home_player7_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player7_foul++;
                                    player7_foul.setText(String.format("%d", home_player7_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player7_score--;
                                    player7_score.setText(String.format("%d", home_player7_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player7_rebound--;
                                    player7_rebound.setText(String.format("%d", home_player7_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player7_assist--;
                                    player7_assist.setText(String.format("%d", home_player7_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player7_foul--;
                                    player7_foul.setText(String.format("%d", home_player7_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });
        //==========================================================================================
        //=================================PLAYER 8 EDIT============================================
        //==========================================================================================
        home_player8_edit = (Button) findViewById(R.id.home_player8_edit);
        home_player8_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player8.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player8_score++;
                                    player8_score.setText(String.format("%d", home_player8_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player8_score += 2;
                                    player8_score.setText(String.format("%d", home_player8_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player8_score += 3;
                                    player8_score.setText(String.format("%d", home_player8_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player8_rebound++;
                                    player8_rebound.setText(String.format("%d", home_player8_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player8_assist++;
                                    player8_assist.setText(String.format("%d", home_player8_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player8_foul++;
                                    player8_foul.setText(String.format("%d", home_player8_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player8_score--;
                                    player8_score.setText(String.format("%d", home_player8_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player8_rebound--;
                                    player8_rebound.setText(String.format("%d", home_player8_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player8_assist--;
                                    player8_assist.setText(String.format("%d", home_player8_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player8_foul--;
                                    player8_foul.setText(String.format("%d", home_player8_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });
        //==========================================================================================
        //=================================PLAYER 9 EDIT============================================
        //==========================================================================================
        home_player9_edit = (Button) findViewById(R.id.home_player9_edit);
        home_player9_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점","리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player9.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player9_score++;
                                    player9_score.setText(String.format("%d", home_player9_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player9_score += 2;
                                    player9_score.setText(String.format("%d", home_player9_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player9_score += 3;
                                    player9_score.setText(String.format("%d", home_player9_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player9_rebound++;
                                    player9_rebound.setText(String.format("%d", home_player9_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player9_assist++;
                                    player9_assist.setText(String.format("%d", home_player9_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player9_foul++;
                                    player9_foul.setText(String.format("%d", home_player9_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player9_score--;
                                    player9_score.setText(String.format("%d", home_player9_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player9_rebound--;
                                    player9_rebound.setText(String.format("%d", home_player9_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player9_assist--;
                                    player9_assist.setText(String.format("%d", home_player9_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player9_foul--;
                                    player9_foul.setText(String.format("%d", home_player9_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });
        //==========================================================================================
        //=================================PLAYER 10 EDIT============================================
        //==========================================================================================
        home_player10_edit = (Button) findViewById(R.id.home_player10_edit);
        home_player10_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player10.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player10_score++;
                                    player10_score.setText(String.format("%d", home_player10_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player10_score += 2;
                                    player10_score.setText(String.format("%d", home_player10_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player10_score += 3;
                                    player10_score.setText(String.format("%d", home_player10_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player10_rebound++;
                                    player10_rebound.setText(String.format("%d", home_player10_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player10_assist++;
                                    player10_assist.setText(String.format("%d", home_player10_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player10_foul++;
                                    player10_foul.setText(String.format("%d", home_player10_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player10_score--;
                                    player10_score.setText(String.format("%d", home_player10_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player10_rebound--;
                                    player10_rebound.setText(String.format("%d", home_player10_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player10_assist--;
                                    player10_assist.setText(String.format("%d", home_player10_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player10_foul--;
                                    player10_foul.setText(String.format("%d", home_player10_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });
        //==========================================================================================
        //=================================PLAYER 11 EDIT============================================
        //==========================================================================================
        home_player11_edit = (Button) findViewById(R.id.home_player11_edit);
        home_player11_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점", "리바운드 취소", "어시스트 취소", "파울 취소"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String name = home_player11.getText().toString();
                dialog.setTitle(name + "님의 기록편집")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                                if (selectedIndex[0] == 0) { // 1득점
                                    home_player11_score++;
                                    player11_score.setText(String.format("%d", home_player11_score));
                                    homecount++;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 1) { // 2득점
                                    home_player11_score += 2;
                                    player11_score.setText(String.format("%d", home_player11_score));
                                    homecount += 2;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 2) { //3 득점
                                    home_player11_score += 3;
                                    player11_score.setText(String.format("%d", home_player11_score));
                                    homecount += 3;
                                    home_score.setText(String.format("%d", homecount));
                                } else if (selectedIndex[0] == 3) { // 리바운드
                                    home_player11_rebound++;
                                    player11_rebound.setText(String.format("%d", home_player11_rebound));
                                } else if (selectedIndex[0] == 4) {  // 어시스트
                                    home_player11_assist++;
                                    player11_assist.setText(String.format("%d", home_player11_assist));
                                } else if (selectedIndex[0] == 5) {  // 파울
                                    home_player11_foul++;
                                    player10_foul.setText(String.format("%d", home_player11_foul));
                                } else if (selectedIndex[0] == 6){   // 감점
                                    home_player11_score--;
                                    player11_score.setText(String.format("%d", home_player11_score));
                                    homecount--;
                                    home_score.setText(String.format("%d", homecount));
                                } else if(selectedIndex[0] == 7){ //리바운드 취소
                                    home_player11_rebound--;
                                    player11_rebound.setText(String.format("%d", home_player11_rebound));
                                } else if(selectedIndex[0] ==8){ //어시스트 취소
                                    home_player11_assist--;
                                    player11_assist.setText(String.format("%d", home_player11_assist));
                                } else if(selectedIndex[0] == 9){ //파울 취소
                                    home_player11_foul--;
                                    player11_foul.setText(String.format("%d", home_player11_foul));
                                }
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //기본 점수판에 대한 reset실행부분
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("초기화 하겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                homecount = 0;
                                awaycount = 0;
                                home_score.setText(String.format("%d",homecount));
                                away_score.setText(String.format("%d",awaycount));
                                home_team_foul_count = 0;
                                home_team_foul.setText(String.format("%d",home_team_foul_count));
                                away_team_foul_count = 0;
                                away_team_foul.setText(String.format("%d",away_team_foul_count));

                                //선수 기록부분 reset실행 부분
                                home_player1_score = 0;
                                home_player1_rebound = 0;
                                home_player1_assist = 0;
                                home_player1_foul = 0;
                                player1_score.setText(String.format("%d", home_player1_score));
                                player1_rebound.setText(String.format("%d", home_player1_rebound));
                                player1_assist.setText(String.format("%d", home_player1_assist));
                                player1_foul.setText(String.format("%d", home_player1_foul));
                                player1_playtime_value1 = 0;
                                player1_playtime_value2 = 0;
                                player1_playtime_value3 = 0;
                                player1_playtime_value4 = 0;
                                currentstate1 = 0;
                                player1_playtime.setText(""+player1_playtime_value1 + player1_playtime_value2 + ":" + player1_playtime_value3 +player1_playtime_value4);
                                mHandler.removeMessages(0);

                                home_player2_score = 0;
                                home_player2_rebound = 0;
                                home_player2_assist = 0;
                                home_player2_foul = 0;
                                player2_score.setText(String.format("%d", home_player2_score));
                                player2_rebound.setText(String.format("%d", home_player2_rebound));
                                player2_assist.setText(String.format("%d", home_player2_assist));
                                player2_foul.setText(String.format("%d", home_player2_foul));
                                player2_playtime_value1 = 0;
                                player2_playtime_value2 = 0;
                                player2_playtime_value3 = 0;
                                player2_playtime_value4 = 0;
                                currentstate2 = 0;
                                player2_playtime.setText(""+player2_playtime_value1 + player2_playtime_value2 + ":" + player2_playtime_value3 +player2_playtime_value4);
                                mHandler2.removeMessages(0);

                                home_player3_score = 0;
                                home_player3_rebound = 0;
                                home_player3_assist = 0;
                                home_player3_foul = 0;
                                player3_score.setText(String.format("%d", home_player3_score));
                                player3_rebound.setText(String.format("%d", home_player3_rebound));
                                player3_assist.setText(String.format("%d", home_player3_assist));
                                player3_foul.setText(String.format("%d", home_player3_foul));
                                player3_playtime_value1 = 0;
                                player3_playtime_value2 = 0;
                                player3_playtime_value3 = 0;
                                player3_playtime_value4 = 0;
                                currentstate3 = 0;
                                player3_playtime.setText(""+player3_playtime_value1 + player3_playtime_value2 + ":" + player3_playtime_value3 +player3_playtime_value4);
                                mHandler3.removeMessages(0);

                                home_player4_score = 0;
                                home_player4_rebound = 0;
                                home_player4_assist = 0;
                                home_player4_foul = 0;
                                player4_score.setText(String.format("%d", home_player4_score));
                                player4_rebound.setText(String.format("%d", home_player4_rebound));
                                player4_assist.setText(String.format("%d", home_player4_assist));
                                player4_foul.setText(String.format("%d", home_player4_foul));
                                player4_playtime_value1 = 0;
                                player4_playtime_value2 = 0;
                                player4_playtime_value3 = 0;
                                player4_playtime_value4 = 0;
                                currentstate4 = 0;
                                player4_playtime.setText(""+player4_playtime_value1 + player4_playtime_value2 + ":" + player4_playtime_value3 +player4_playtime_value4);
                                mHandler4.removeMessages(0);

                                home_player5_score = 0;
                                home_player5_rebound = 0;
                                home_player5_assist = 0;
                                home_player5_foul = 0;
                                player5_score.setText(String.format("%d", home_player5_score));
                                player5_rebound.setText(String.format("%d", home_player5_rebound));
                                player5_assist.setText(String.format("%d", home_player5_assist));
                                player5_foul.setText(String.format("%d", home_player5_foul));
                                player5_playtime_value1 = 0;
                                player5_playtime_value2 = 0;
                                player5_playtime_value3 = 0;
                                player5_playtime_value4 = 0;
                                currentstate5 = 0;
                                player5_playtime.setText(""+player5_playtime_value1 + player5_playtime_value2 + ":" + player5_playtime_value3 +player5_playtime_value4);
                                mHandler5.removeMessages(0);

                                home_player6_score = 0;
                                home_player6_rebound = 0;
                                home_player6_assist = 0;
                                home_player6_foul = 0;
                                player6_score.setText(String.format("%d", home_player6_score));
                                player6_rebound.setText(String.format("%d", home_player6_rebound));
                                player6_assist.setText(String.format("%d", home_player6_assist));
                                player6_foul.setText(String.format("%d", home_player6_foul));
                                player6_playtime_value1 = 0;
                                player6_playtime_value2 = 0;
                                player6_playtime_value3 = 0;
                                player6_playtime_value4 = 0;
                                currentstate6 = 0;
                                player6_playtime.setText(""+player6_playtime_value1 + player6_playtime_value2 + ":" + player6_playtime_value3 +player6_playtime_value4);
                                mHandler6.removeMessages(0);

                                home_player7_score = 0;
                                home_player7_rebound = 0;
                                home_player7_assist = 0;
                                home_player7_foul = 0;
                                player7_score.setText(String.format("%d", home_player7_score));
                                player7_rebound.setText(String.format("%d", home_player7_rebound));
                                player7_assist.setText(String.format("%d", home_player7_assist));
                                player7_foul.setText(String.format("%d", home_player7_foul));
                                player7_playtime_value1 = 0;
                                player7_playtime_value2 = 0;
                                player7_playtime_value3 = 0;
                                player7_playtime_value4 = 0;
                                currentstate7 = 0;
                                player7_playtime.setText(""+player7_playtime_value1 + player7_playtime_value2 + ":" + player7_playtime_value3 +player7_playtime_value4);
                                mHandler7.removeMessages(0);

                                home_player8_score = 0;
                                home_player8_rebound = 0;
                                home_player8_assist = 0;
                                home_player8_foul = 0;
                                player8_score.setText(String.format("%d", home_player8_score));
                                player8_rebound.setText(String.format("%d", home_player8_rebound));
                                player8_assist.setText(String.format("%d", home_player8_assist));
                                player8_foul.setText(String.format("%d", home_player8_foul));
                                player8_playtime_value1 = 0;
                                player8_playtime_value2 = 0;
                                player8_playtime_value3 = 0;
                                player8_playtime_value4 = 0;
                                currentstate8 = 0;
                                player8_playtime.setText(""+player8_playtime_value1 + player8_playtime_value2 + ":" + player8_playtime_value3 +player8_playtime_value4);
                                mHandler8.removeMessages(0);

                                home_player9_score = 0;
                                home_player9_rebound = 0;
                                home_player9_assist = 0;
                                home_player9_foul = 0;
                                player9_score.setText(String.format("%d", home_player9_score));
                                player9_rebound.setText(String.format("%d", home_player9_rebound));
                                player9_assist.setText(String.format("%d", home_player9_assist));
                                player9_foul.setText(String.format("%d", home_player9_foul));
                                player9_playtime_value1 = 0;
                                player9_playtime_value2 = 0;
                                player9_playtime_value3 = 0;
                                player9_playtime_value4 = 0;
                                currentstate9 = 0;
                                player9_playtime.setText(""+player9_playtime_value1 + player9_playtime_value2 + ":" + player9_playtime_value3 +player9_playtime_value4);
                                mHandler9.removeMessages(0);

                                home_player10_score = 0;
                                home_player10_rebound = 0;
                                home_player10_assist = 0;
                                home_player10_foul = 0;
                                player10_score.setText(String.format("%d", home_player10_score));
                                player10_rebound.setText(String.format("%d", home_player10_rebound));
                                player10_assist.setText(String.format("%d", home_player10_assist));
                                player10_foul.setText(String.format("%d", home_player10_foul));
                                player10_playtime_value1 = 0;
                                player10_playtime_value2 = 0;
                                player10_playtime_value3 = 0;
                                player10_playtime_value4 = 0;
                                currentstate10 = 0;
                                player10_playtime.setText(""+player10_playtime_value1 + player10_playtime_value2 + ":" + player10_playtime_value3 +player10_playtime_value4);
                                mHandler10.removeMessages(0);

                                home_player11_score = 0;
                                home_player11_rebound = 0;
                                home_player11_assist = 0;
                                home_player11_foul = 0;
                                player11_score.setText(String.format("%d", home_player11_score));
                                player11_rebound.setText(String.format("%d", home_player11_rebound));
                                player11_assist.setText(String.format("%d", home_player11_assist));
                                player11_foul.setText(String.format("%d", home_player11_foul));
                                player11_playtime_value1 = 0;
                                player11_playtime_value2 = 0;
                                player11_playtime_value3 = 0;
                                player11_playtime_value4 = 0;
                                currentstate11 = 0;
                                player11_playtime.setText(""+player11_playtime_value1 + player11_playtime_value2 + ":" + player11_playtime_value3 +player11_playtime_value4);
                                mHandler11.removeMessages(0);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(home_name.length() != 0 && away_name.length() != 0 && gamedate.length() !=0) {
                    DataSave();
                }
                else if(home_name.length() == 0){
                    Toast.makeText(MainActivity.this, "홈팀명을 입력하여주세요!", Toast.LENGTH_SHORT).show();
                }
                else if(away_name.length() == 0){
                    Toast.makeText(MainActivity.this, "어웨이팀명을 입력하여주세요!", Toast.LENGTH_SHORT).show();
                }
                else if(gamedate.length() == 0){
                    Toast.makeText(MainActivity.this, "게임 일시를 입력하여주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // ===============================================================================================================               onCreate 끝

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sp = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sp.edit();
        int value = scoreboardNum;
        editor.putInt("jeon",value);
        editor.commit();
    }

    public void DataSave(){

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("기록을 등록하시겠습니까?")
                .setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mHandler.removeMessages(0);
                        mHandler2.removeMessages(0);
                        mHandler3.removeMessages(0);
                        mHandler4.removeMessages(0);
                        mHandler5.removeMessages(0);
                        mHandler6.removeMessages(0);
                        mHandler7.removeMessages(0);
                        mHandler8.removeMessages(0);
                        mHandler9.removeMessages(0);
                        mHandler10.removeMessages(0);
                        mHandler11.removeMessages(0);

                        final String Home = home_name.getText().toString().trim();
                        final String Away = away_name.getText().toString().trim();
                        final String name = home_player1.getText().toString().trim();
                        final String point = player1_score.getText().toString().trim();
                        final String rebo = player1_rebound.getText().toString().trim();
                        final String assi = player1_assist.getText().toString().trim();
                        final String fou = player1_foul.getText().toString().trim();
                        final String time = player1_playtime_value1 + player1_playtime_value2 + ":" +player1_playtime_value3 + player1_playtime_value4;
                        final String gameD = gamedate.getText().toString().trim();
                        final Scoreboard sb = new Scoreboard(name, point, rebo, assi, fou, time, Home, Away, gameD);

                        databaseReference = FirebaseDatabase.getInstance().getReference(Home + "vs" +Away); //Home + Away
                        String Key = databaseReference.push().getKey();
                        databaseReference.child(name).setValue(sb);

                    //=======================================================================================================
                       //====================================선수 랭킹을 위한 코드 ===============================================
                       //=======================================================================================================
                                //===여기서부터
                                  //점수 누적시키기 위한 장치들
                        databaseReference2 = FirebaseDatabase.getInstance().getReference("Players").child(name);
                        databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Scoreboard test = dataSnapshot.getValue(Scoreboard.class);

                                if (test == null) {
                                    databaseReference2.setValue(sb);
                                } else {
                                    int ptp = Integer.parseInt(test.getpoint()) + Integer.parseInt(point);
                                    int rtr = Integer.parseInt(test.getRebo()) + Integer.parseInt(rebo);
                                    int ata = Integer.parseInt(test.getAssi()) + Integer.parseInt(assi);
                                    int ftf = Integer.parseInt(test.getFoul()) + Integer.parseInt(fou);
                                    int gc = test.getGamecount()+1;

                                    test.setname(name);
                                    test.setpoint(String.valueOf(ptp));
                                    test.setrebo(String.valueOf(rtr));
                                    test.setassi(String.valueOf(ata));
                                    test.setfoul(String.valueOf(ftf));
                                    test.setGamecount(gc);
                                    databaseReference2.setValue(test);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                          //===============여기까지========================================================================================
                            //===============================================================================================================


                        final String Home2 = home_name.getText().toString().trim();
                        final String Away2 = away_name.getText().toString().trim();
                        final String name2 = home_player2.getText().toString().trim();
                        final String point2 = player2_score.getText().toString().trim();
                        final String rebo2 = player2_rebound.getText().toString().trim();
                        final String assi2 = player2_assist.getText().toString().trim();
                        final String fou2 = player2_foul.getText().toString().trim();
                        final String time2 = player2_playtime_value1 + player2_playtime_value2 + ":" +player2_playtime_value3 + player2_playtime_value4;
                        final Scoreboard sb2 = new Scoreboard(name2, point2, rebo2, assi2, fou2, time2, Home, Away, gameD);
                        if(name2 !=null && name2.length()!=0) {
                            databaseReference.child(name2).setValue(sb2);
                            databaseReference3 = FirebaseDatabase.getInstance().getReference("Players").child(name2);
                            databaseReference3.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test2 = dataSnapshot.getValue(Scoreboard.class);
                                    if(name2 == null){
                                        Toast.makeText(MainActivity.this, "이름을 입력하세요 (2번쨰 명단)", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (test2 == null) {
                                        databaseReference3.setValue(sb2);
                                    } else {
                                        int ptp = Integer.parseInt(test2.getpoint()) + Integer.parseInt(point2);
                                        int rtr = Integer.parseInt(test2.getRebo()) + Integer.parseInt(rebo2);
                                        int ata = Integer.parseInt(test2.getAssi()) + Integer.parseInt(assi2);
                                        int ftf = Integer.parseInt(test2.getFoul()) + Integer.parseInt(fou2);
                                        int gc = test2.getGamecount()+1;


                                        test2.setpoint(String.valueOf(ptp));
                                        test2.setrebo(String.valueOf(rtr));
                                        test2.setassi(String.valueOf(ata));
                                        test2.setfoul(String.valueOf(ftf));
                                        test2.setGamecount(gc);
                                        databaseReference3.setValue(test2);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }





                        final String Home3 = home_name.getText().toString().trim();
                        final String Away3 = away_name.getText().toString().trim();
                        final String name3 = home_player3.getText().toString().trim();
                        final String point3 = player3_score.getText().toString().trim();
                        final String rebo3 = player3_rebound.getText().toString().trim();
                        final String assi3 = player3_assist.getText().toString().trim();
                        final String fou3 = player3_foul.getText().toString().trim();
                        final String time3 = player3_playtime_value1 + player3_playtime_value2 + ":" +player3_playtime_value3 + player3_playtime_value4;
                        final Scoreboard sb3 = new Scoreboard(name3, point3, rebo3, assi3, fou3, time3, Home3, Away3, gameD);
                        if(name3 != null && name3.length()!=0) {
                            databaseReference.child(name3).setValue(sb3);
                            databaseReference4 = FirebaseDatabase.getInstance().getReference("Players").child(name3);
                            databaseReference4.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test3 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test3 == null) {
                                        databaseReference4.setValue(sb3);
                                    } else {
                                        int ptp = Integer.parseInt(test3.getpoint()) + Integer.parseInt(point3);
                                        int rtr = Integer.parseInt(test3.getRebo()) + Integer.parseInt(rebo3);
                                        int ata = Integer.parseInt(test3.getAssi()) + Integer.parseInt(assi3);
                                        int ftf = Integer.parseInt(test3.getFoul()) + Integer.parseInt(fou3);
                                        int gc = test3.getGamecount()+1;


                                        test3.setpoint(String.valueOf(ptp));
                                        test3.setrebo(String.valueOf(rtr));
                                        test3.setassi(String.valueOf(ata));
                                        test3.setfoul(String.valueOf(ftf));
                                        test3.setGamecount(gc);
                                        databaseReference4.setValue(test3);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                        }





                        final String Home4 = home_name.getText().toString().trim();
                        final String Away4 = away_name.getText().toString().trim();
                        final String name4 = home_player4.getText().toString().trim();
                        final String point4 = player4_score.getText().toString().trim();
                        final String rebo4 = player4_rebound.getText().toString().trim();
                        final String assi4 = player4_assist.getText().toString().trim();
                        final String fou4 = player4_foul.getText().toString().trim();
                        final String time4 = player4_playtime_value1 + player4_playtime_value2 + ":" +player4_playtime_value3 + player4_playtime_value4;
                        final Scoreboard sb4 = new Scoreboard(name4, point4, rebo4, assi4, fou4, time4, Home4, Away4, gameD);

                        if(name4 != null && name4.length()!=0) {
                            databaseReference.child(name4).setValue(sb4);
                            databaseReference5 = FirebaseDatabase.getInstance().getReference("Players").child(name4);
                            databaseReference5.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test4 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test4 == null) {
                                        databaseReference5.setValue(sb4);
                                    } else {
                                        int ptp = Integer.parseInt(test4.getpoint()) + Integer.parseInt(point4);
                                        int rtr = Integer.parseInt(test4.getRebo()) + Integer.parseInt(rebo4);
                                        int ata = Integer.parseInt(test4.getAssi()) + Integer.parseInt(assi4);
                                        int ftf = Integer.parseInt(test4.getFoul()) + Integer.parseInt(fou4);
                                        int gc = test4.getGamecount()+1;


                                        test4.setpoint(String.valueOf(ptp));
                                        test4.setrebo(String.valueOf(rtr));
                                        test4.setassi(String.valueOf(ata));
                                        test4.setfoul(String.valueOf(ftf));
                                        test4.setGamecount(gc);
                                        databaseReference5.setValue(test4);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }





                        final String Home5 = home_name.getText().toString().trim();
                        final String Away5 = away_name.getText().toString().trim();
                        final String name5 = home_player5.getText().toString().trim();
                        final String point5 = player5_score.getText().toString().trim();
                        final String rebo5 = player5_rebound.getText().toString().trim();
                        final String assi5 = player5_assist.getText().toString().trim();
                        final String fou5 = player5_foul.getText().toString().trim();
                        final String time5 = player5_playtime_value1 + player5_playtime_value2 + ":" +player5_playtime_value3 + player5_playtime_value4;
                        final Scoreboard sb5 = new Scoreboard(name5, point5, rebo5, assi5, fou5, time5, Home5, Away5, gameD);

                        if(name5 != null && name5.length()!=0) {
                            databaseReference.child(name5).setValue(sb5);
                            databaseReference6 = FirebaseDatabase.getInstance().getReference("Players").child(name5);
                            databaseReference6.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test5 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test5 == null) {
                                        databaseReference6.setValue(sb5);
                                    } else {
                                        int ptp = Integer.parseInt(test5.getpoint()) + Integer.parseInt(point5);
                                        int rtr = Integer.parseInt(test5.getRebo()) + Integer.parseInt(rebo5);
                                        int ata = Integer.parseInt(test5.getAssi()) + Integer.parseInt(assi5);
                                        int ftf = Integer.parseInt(test5.getFoul()) + Integer.parseInt(fou5);
                                        int gc = test5.getGamecount()+1;


                                        test5.setpoint(String.valueOf(ptp));
                                        test5.setrebo(String.valueOf(rtr));
                                        test5.setassi(String.valueOf(ata));
                                        test5.setfoul(String.valueOf(ftf));
                                        test5.setGamecount(gc);
                                        databaseReference6.setValue(test5);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }






                        final String Home6 = home_name.getText().toString().trim();
                        final String Away6 = away_name.getText().toString().trim();
                        final String name6 = home_player6.getText().toString().trim();
                        final String point6 = player6_score.getText().toString().trim();
                        final String rebo6 = player6_rebound.getText().toString().trim();
                        final String assi6 = player6_assist.getText().toString().trim();
                        final String fou6 = player6_foul.getText().toString().trim();
                        final String time6 = player6_playtime_value1 + player6_playtime_value2 + ":" +player6_playtime_value3 + player6_playtime_value4;
                        final Scoreboard sb6 = new Scoreboard(name6, point6, rebo6, assi6, fou6, time6, Home6, Away6, gameD);

                        if(name6 != null && name6.length()!=0) {
                            databaseReference.child(name6).setValue(sb6);
                            databaseReference7 = FirebaseDatabase.getInstance().getReference("Players").child(name6);
                            databaseReference7.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test6 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test6 == null) {
                                        databaseReference7.setValue(sb6);
                                    } else {
                                        int ptp = Integer.parseInt(test6.getpoint()) + Integer.parseInt(point6);
                                        int rtr = Integer.parseInt(test6.getRebo()) + Integer.parseInt(rebo6);
                                        int ata = Integer.parseInt(test6.getAssi()) + Integer.parseInt(assi6);
                                        int ftf = Integer.parseInt(test6.getFoul()) + Integer.parseInt(fou6);
                                        int gc = test6.getGamecount()+1;


                                        test6.setpoint(String.valueOf(ptp));
                                        test6.setrebo(String.valueOf(rtr));
                                        test6.setassi(String.valueOf(ata));
                                        test6.setfoul(String.valueOf(ftf));
                                        test6.setGamecount(gc);
                                        databaseReference7.setValue(test6);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }













                        final String Home7 = home_name.getText().toString().trim();
                        final String Away7 = away_name.getText().toString().trim();
                        final String name7 = home_player7.getText().toString().trim();
                        final String point7 = player7_score.getText().toString().trim();
                        final String rebo7 = player7_rebound.getText().toString().trim();
                        final String assi7 = player7_assist.getText().toString().trim();
                        final String fou7 = player7_foul.getText().toString().trim();
                        final String time7 = player7_playtime_value1 + player7_playtime_value2 + ":" +player7_playtime_value3 + player7_playtime_value4;
                        final Scoreboard sb7 = new Scoreboard(name7, point7, rebo7, assi7, fou7, time7, Home7, Away7, gameD);

                        if(name7 != null && name7.length()!=0) {
                            databaseReference.child(name7).setValue(sb7);
                            databaseReference8 = FirebaseDatabase.getInstance().getReference("Players").child(name7);
                            databaseReference8.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test7 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test7 == null) {
                                        databaseReference8.setValue(sb6);
                                    } else {
                                        int ptp = Integer.parseInt(test7.getpoint()) + Integer.parseInt(point7);
                                        int rtr = Integer.parseInt(test7.getRebo()) + Integer.parseInt(rebo7);
                                        int ata = Integer.parseInt(test7.getAssi()) + Integer.parseInt(assi7);
                                        int ftf = Integer.parseInt(test7.getFoul()) + Integer.parseInt(fou7);
                                        int gc = test7.getGamecount()+1;


                                        test7.setpoint(String.valueOf(ptp));
                                        test7.setrebo(String.valueOf(rtr));
                                        test7.setassi(String.valueOf(ata));
                                        test7.setfoul(String.valueOf(ftf));
                                        test7.setGamecount(gc);
                                        databaseReference8.setValue(test7);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }




                        final String Home8 = home_name.getText().toString().trim();
                        final String Away8 = away_name.getText().toString().trim();
                        final String name8 = home_player8.getText().toString().trim();
                        final String point8 = player8_score.getText().toString().trim();
                        final String rebo8 = player8_rebound.getText().toString().trim();
                        final String assi8 = player8_assist.getText().toString().trim();
                        final String fou8 = player8_foul.getText().toString().trim();
                        final String time8 = player8_playtime_value1 + player8_playtime_value2 + ":" +player8_playtime_value3 + player8_playtime_value4;
                        final Scoreboard sb8 = new Scoreboard(name8, point8, rebo8, assi8, fou8, time8, Home8, Away8, gameD);
                        if(name8 != null && name8.length()!=0) {
                            databaseReference.child(name8).setValue(sb8);
                            databaseReference9 = FirebaseDatabase.getInstance().getReference("Players").child(name8);
                            databaseReference9.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test8 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test8 == null) {
                                        databaseReference9.setValue(sb8);
                                    } else {
                                        int ptp = Integer.parseInt(test8.getpoint()) + Integer.parseInt(point8);
                                        int rtr = Integer.parseInt(test8.getRebo()) + Integer.parseInt(rebo8);
                                        int ata = Integer.parseInt(test8.getAssi()) + Integer.parseInt(assi8);
                                        int ftf = Integer.parseInt(test8.getFoul()) + Integer.parseInt(fou8);
                                        int gc = test8.getGamecount()+1;


                                        test8.setpoint(String.valueOf(ptp));
                                        test8.setrebo(String.valueOf(rtr));
                                        test8.setassi(String.valueOf(ata));
                                        test8.setfoul(String.valueOf(ftf));
                                        test8.setGamecount(gc);
                                        databaseReference9.setValue(test8);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                        }




                        final String Home9 = home_name.getText().toString().trim();
                        final String Away9 = away_name.getText().toString().trim();
                        final String name9 = home_player9.getText().toString().trim();
                        final String point9 = player9_score.getText().toString().trim();
                        final String rebo9 = player9_rebound.getText().toString().trim();
                        final String assi9 = player9_assist.getText().toString().trim();
                        final String fou9 = player9_foul.getText().toString().trim();
                        final String time9 = player9_playtime_value1 + player9_playtime_value2 + ":" +player9_playtime_value3 + player9_playtime_value4;
                        final Scoreboard sb9 = new Scoreboard(name9, point9, rebo9, assi9, fou9, time9, Home9, Away9, gameD);

                        if(name9 != null && name9.length()!=0) {
                            databaseReference.child(name9).setValue(sb9);
                            databaseReference10 = FirebaseDatabase.getInstance().getReference("Players").child(name9);
                            databaseReference10.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test9 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test9 == null) {
                                        databaseReference10.setValue(sb9);
                                    } else {
                                        int ptp = Integer.parseInt(test9.getpoint()) + Integer.parseInt(point9);
                                        int rtr = Integer.parseInt(test9.getRebo()) + Integer.parseInt(rebo9);
                                        int ata = Integer.parseInt(test9.getAssi()) + Integer.parseInt(assi9);
                                        int ftf = Integer.parseInt(test9.getFoul()) + Integer.parseInt(fou9);
                                        int gc = test9.getGamecount()+1;


                                        test9.setpoint(String.valueOf(ptp));
                                        test9.setrebo(String.valueOf(rtr));
                                        test9.setassi(String.valueOf(ata));
                                        test9.setfoul(String.valueOf(ftf));
                                        test9.setGamecount(gc);
                                        databaseReference10.setValue(test9);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }






                        final String Home10 = home_name.getText().toString().trim();
                        final String Away10 = away_name.getText().toString().trim();
                        final String name10 = home_player10.getText().toString().trim();
                        final String point10 = player10_score.getText().toString().trim();
                        final String rebo10 = player10_rebound.getText().toString().trim();
                        final String assi10 = player10_assist.getText().toString().trim();
                        final String fou10 = player10_foul.getText().toString().trim();
                        final String time10 = player10_playtime_value1 + player10_playtime_value2 + ":" +player10_playtime_value3 + player10_playtime_value4;
                        final Scoreboard sb10 = new Scoreboard(name10, point10, rebo10, assi10, fou10, time10, Home10, Away10, gameD);

                        if(name10 != null && name10.length()!=0) {
                            databaseReference.child(name10).setValue(sb10);
                            databaseReference11 = FirebaseDatabase.getInstance().getReference("Players").child(name10);
                            databaseReference11.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test10 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test10 == null) {
                                        databaseReference11.setValue(sb10);
                                    } else {
                                        int ptp = Integer.parseInt(test10.getpoint()) + Integer.parseInt(point10);
                                        int rtr = Integer.parseInt(test10.getRebo()) + Integer.parseInt(rebo10);
                                        int ata = Integer.parseInt(test10.getAssi()) + Integer.parseInt(assi10);
                                        int ftf = Integer.parseInt(test10.getFoul()) + Integer.parseInt(fou10);
                                        int gc = test10.getGamecount()+1;


                                        test10.setpoint(String.valueOf(ptp));
                                        test10.setrebo(String.valueOf(rtr));
                                        test10.setassi(String.valueOf(ata));
                                        test10.setfoul(String.valueOf(ftf));
                                        test10.setGamecount(gc);
                                        databaseReference11.setValue(test10);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }















                        final String Home11 = home_name.getText().toString().trim();
                        final String Away11 = away_name.getText().toString().trim();
                        final String name11 = home_player11.getText().toString().trim();
                        final String point11 = player11_score.getText().toString().trim();
                        final String rebo11 = player11_rebound.getText().toString().trim();
                        final String assi11 = player11_assist.getText().toString().trim();
                        final String fou11 = player11_foul.getText().toString().trim();
                        final String time11 = player11_playtime_value1 + player11_playtime_value2 + ":" +player11_playtime_value3 + player11_playtime_value4;
                        final Scoreboard sb11 = new Scoreboard(name11, point11, rebo11, assi11, fou11, time11, Home11, Away11, gameD);

                        if(name11 != null && name11.length()!=0) {
                            databaseReference.child(name11).setValue(sb11);
                            databaseReference12 = FirebaseDatabase.getInstance().getReference("Players").child(name11);
                            databaseReference12.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Scoreboard test11 = dataSnapshot.getValue(Scoreboard.class);

                                    if (test11 == null) {
                                        databaseReference12.setValue(sb11);
                                    } else {
                                        int ptp = Integer.parseInt(test11.getpoint()) + Integer.parseInt(point11);
                                        int rtr = Integer.parseInt(test11.getRebo()) + Integer.parseInt(rebo11);
                                        int ata = Integer.parseInt(test11.getAssi()) + Integer.parseInt(assi11);
                                        int ftf = Integer.parseInt(test11.getFoul()) + Integer.parseInt(fou11);
                                        int gc = test11.getGamecount()+1;


                                        test11.setpoint(String.valueOf(ptp));
                                        test11.setrebo(String.valueOf(rtr));
                                        test11.setassi(String.valueOf(ata));
                                        test11.setfoul(String.valueOf(ftf));
                                        test11.setGamecount(gc);
                                        databaseReference12.setValue(test11);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }






                        Toast.makeText(MainActivity.this, "Scoreboard Info is added", Toast.LENGTH_SHORT).show();
                        scoreboardNum++;
                    }
                })
                .setNegativeButton("취소:", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


}
