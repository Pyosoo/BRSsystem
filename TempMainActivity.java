package com.example.snstk.psrecord;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TempMainActivity extends AppCompatActivity {

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

    TextView teamfoul1;
    TextView teamfoul2;
    TextView playerscore;
    TextView playerrebound;
    TextView playerassist;
    TextView playerfoul;
    TextView playeredit;
    TextView playtime;
    Button reset;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_main);


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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }

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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
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
                        "1득점", "2득점", "3득점", "리바운드", "어시스트", "파울", "감점"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(TempMainActivity.this);
                dialog.setTitle("항목을 선택하세요")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                                }
                            }
                        }).show();
            }
        });
    }
}
