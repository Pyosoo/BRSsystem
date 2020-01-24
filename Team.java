package com.example.snstk.psrecord;

import android.widget.Toast;

public class Team {

    private String TN; //team Name
    private String Purl; // Picture Url

    public void Team(){}
    public void Team(String TN, String Purl){
        TN = TN;
        Purl = Purl;
    }

    public String getTeamName(){
        return TN;
    }
    public String getPurl(){
        return Purl;
    }
    public void setTeamName(String TN){
        TN = TN;
    }
    public void setPurl(String Purl){
        Purl = Purl;
    }
}
