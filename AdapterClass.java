package com.example.snstk.psrecord;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>{

    ArrayList<Player> list;
    public AdapterClass(ArrayList<Player> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_holder,
                parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.match_info.setText(list.get(position).getName());
        //holder.match_info.setText(list.get(position).gethome() +" vs " + list.get(position).getaway());

        float avgP = Float.valueOf(list.get(position).getpoint()) / list.get(position).getGamecount();
        float avgA = Float.valueOf(list.get(position).getAssi()) / list.get(position).getGamecount();
        float avgR = Float.valueOf(list.get(position).getRebo()) / list.get(position).getGamecount();
        float avgF = Float.valueOf(list.get(position).getFoul()) / list.get(position).getGamecount();

       // holder.n.setText("이름 = " + list.get(position).getName());
        holder.s.setText("평균 득점 = " + Float.toString(avgP));
        holder.a.setText("평균 어시스트 = " + Float.toString(avgA));
        holder.r.setText("평균 리바운드 = " + Float.toString(avgR));
        holder.f.setText("평균 파울 = " + Float.toString(avgF));
      //  holder.t.setText("플레이타임= " + list.get(position).getTime());
        holder.g.setText("게임 수 = " + list.get(position).getGamecount());
       // holder.avP.setText("평균 득점 = " + list.get(position).getAvgP());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s,a,r,f,match_info,g; // ,avgP , t,n
        public MyViewHolder(View itemView) {
            super(itemView);
          //  n = itemView.findViewById(R.id.n);
            s = itemView.findViewById(R.id.s);
            a = itemView.findViewById(R.id.a);
            r = itemView.findViewById(R.id.r);
            f = itemView.findViewById(R.id.f);
        //    t = itemView.findViewById(R.id.t);
            match_info = itemView.findViewById(R.id.match_info);
            g = itemView.findViewById(R.id.g);
          //  avP = itemView.findViewById(R.id.avP);
        }
    }
}

