package com.example.snstk.psrecord;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



// 랭킹랭킹
public class SearchPrac extends AppCompatActivity {

    StorageReference sref;
    DatabaseReference ref;
    ArrayList<Player> list;
    ArrayList<Player> sortedlist;
    RecyclerView recyclerView;
    SearchView searchView;
    Button ScoreOrderButton;
    Button ReboundOrderButton;
    Button AssistOrderButton;
    Button ranking_back;
    AdapterClass adapterClass = new AdapterClass(list);

    private final static Comparator<Player> sortByAvgp = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            return Float.compare(o2.getAvgP(), o1.getAvgP());
        }
    };
    private final static Comparator<Player> sortByAvga = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            return Float.compare(o2.getAvgA(), o1.getAvgA());
        }
    };
    private final static Comparator<Player> sortByAvgr = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            return Float.compare(o2.getAvgR(), o1.getAvgR());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_prac);

        sref = FirebaseStorage.getInstance().getReference();
        ref = FirebaseDatabase.getInstance().getReference().child("Players");
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);
        ScoreOrderButton = findViewById(R.id.ScoreOrderButton);
        AssistOrderButton = findViewById(R.id.AssistOrderButton);
        ReboundOrderButton = findViewById(R.id.ReboundOrderButton);
        ranking_back = findViewById(R.id.ranking_back);


        ranking_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);
                startActivity(intent);
            }
        });
        ScoreOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ref != null)
                {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                list = new ArrayList<>();
                                for(DataSnapshot ds : dataSnapshot.getChildren())
                                {
                                    list.add(ds.getValue(Player.class));
                                }

                                Collections.sort(list,sortByAvgp);

                                for(int i=0; i<list.size(); i++){
                                    Player rankPlayer = list.get(i);
                                    rankPlayer.setname("[" + (i+1) + "등]" + rankPlayer.getName());
                                    list.remove(i);
                                    list.add(i, rankPlayer);
                                }

                                AdapterClass adapterClass = new AdapterClass(list);
                                recyclerView.setAdapter(adapterClass);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(SearchPrac.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if(searchView != null)
                {
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String s) {
                            search(s);
                            return true;
                        }
                    });
                }



                AdapterClass adapterClass = new AdapterClass(list);
                recyclerView.setAdapter(adapterClass);
                adapterClass.notifyDataSetChanged();


            }
        });

        AssistOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ref != null)
                {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                list = new ArrayList<>();
                                for(DataSnapshot ds : dataSnapshot.getChildren())
                                {
                                    list.add(ds.getValue(Player.class));
                                }

                                Collections.sort(list,sortByAvga);

                                for(int i=0; i<list.size(); i++){
                                    Player rankPlayer = list.get(i);
                                    rankPlayer.setname("[" + (i+1) + "등]" + rankPlayer.getName());
                                    list.remove(i);
                                    list.add(i, rankPlayer);
                                }

                                AdapterClass adapterClass = new AdapterClass(list);
                                recyclerView.setAdapter(adapterClass);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(SearchPrac.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if(searchView != null)
                {
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String s) {
                            search(s);
                            return true;
                        }
                    });
                }

                AdapterClass adapterClass = new AdapterClass(list);
                recyclerView.setAdapter(adapterClass);
                adapterClass.notifyDataSetChanged();
            }
        });

        ReboundOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ref != null)
                {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                list = new ArrayList<>();
                                for(DataSnapshot ds : dataSnapshot.getChildren())
                                {
                                    list.add(ds.getValue(Player.class));
                                }

                                Collections.sort(list,sortByAvgr);

                                for(int i=0; i<list.size(); i++){
                                    Player rankPlayer = list.get(i);
                                    rankPlayer.setname("[" + (i+1) + "등]" + rankPlayer.getName());
                                    list.remove(i);
                                    list.add(i, rankPlayer);
                                }

                                AdapterClass adapterClass = new AdapterClass(list);
                                recyclerView.setAdapter(adapterClass);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(SearchPrac.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if(searchView != null)
                {
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String s) {
                            search(s);
                            return true;
                        }
                    });
                }

                AdapterClass adapterClass = new AdapterClass(list);
                recyclerView.setAdapter(adapterClass);
                adapterClass.notifyDataSetChanged();
            }
        });


    }



    @Override
    protected void onStart(){                  // 여기가 기본적으로 켜졌을때 나열되는 리스트 같은데...
        super.onStart();
        if(ref != null)
        {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        list = new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            list.add(ds.getValue(Player.class));
                        }

                        Collections.sort(list,sortByAvgp);

                        for(int i=0; i<list.size(); i++){
                             Player rankPlayer = list.get(i);
                             rankPlayer.setname("[" + (i+1) + "등]" + rankPlayer.getName());
                             list.remove(i);
                             list.add(i, rankPlayer);
                        }

                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(SearchPrac.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }



    private void search(String str){
        ArrayList<Player> myList = new ArrayList<>();
        for(Player object : list)
        {
           // 검색시 나오는 결과를 이름으로 내림차순 한 것
            if(object.getName().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }

        }
        AdapterClass adapterClass = new AdapterClass(myList);
        recyclerView.setAdapter(adapterClass);
    }



}
