package com.example.snstk.psrecord;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    EditText SearchHome;
    EditText SearchAway;
    Button Search;
    EditText Search_gamedate;


    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Scoreboard> list;
    ArrayList<Player> list2;    //선수검색 추가
    ArrayAdapter<Scoreboard> adapter;
    ArrayAdapter<Player> adapter2;  //선수검색 추가
    Scoreboard scoreboard;
    Player player; //선수 검색 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        SearchHome = (EditText)findViewById(R.id.SearchHome);
        SearchAway = (EditText)findViewById(R.id.SearchAway);
        Search_gamedate = (EditText)findViewById(R.id.Search_gamedate);
     //  SearchName = (EditText)findViewById(R.id.SearchName);
        Search = (Button)findViewById(R.id.Search);
     //   Search2 = (Button)findViewById(R.id.Search2);
        scoreboard = new Scoreboard();
        listView = (ListView)findViewById(R.id.ScoreListView);
        database = FirebaseDatabase.getInstance();
        list = new ArrayList<>();
        list2 = new ArrayList<>();  //선수검색 추가
        adapter2 = new ArrayAdapter<Player>(this,R.layout.score_info, R.id.scoreinfo, list2); //선수검색 추가
        adapter = new ArrayAdapter<Scoreboard>(this,R.layout.score_info,R.id.scoreinfo,list);



        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gets = SearchHome.getText().toString();
                String gets2 = SearchAway.getText().toString();
                final String dates = Search_gamedate.getText().toString();
                if (gets.isEmpty()) {
                    Toast.makeText(SearchActivity.this, "홈팀vs원정팀을 입력하여주세요.", Toast.LENGTH_SHORT).show();
                }
                if(Search_gamedate.length() == 0){
                    Toast.makeText(SearchActivity.this, "게임일시를 입력하여주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SearchActivity.this, gets +" vs " + gets2 + "의 기록 중 " + gets + "의 기록을 불러옵니다.", Toast.LENGTH_LONG).show();
                    list.clear();
                    adapter.notifyDataSetChanged();
                    ref = database.getReference().child(gets+"vs"+gets2);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {

                                scoreboard = ds.getValue(Scoreboard.class);
                                if(scoreboard.getgameD().equals(dates)) {
                                    list.add(scoreboard);
                                }
                            }
                            listView.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });


    }
}
