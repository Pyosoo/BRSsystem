package com.example.snstk.psrecord;

public class Scoreboard {
    private String name;
    private String point;
    private String rebo;
    private String assi;
    private String foul;
    private String away;
    private String home;
    private String time;
    private String gameD;
    private float avgP;        //추가

    private int gamecount;
    public Scoreboard(){
        this.name = null;
        this.point = null;
        this.rebo = null;
        this.assi = null;
        this.foul = null;
        this.time = null;
        this.home = null;
        this.away = null;
        this.gamecount = 0;
        this.gameD = null;
    }
    public Scoreboard(String name, String point, String rebo, String assi, String foul,String time ,String home,String away, String gameD ){
        this.name = name;
        this.point = point;
        this.rebo = rebo;
        this.assi = assi;
        this.foul = foul;
        this.time = time;
        this.home = home;
        this.away = away;
        this.gamecount = 1;
        this.gameD = gameD;
    }

    public void calAVGP(String point, String gamecount){
        int p = Integer.parseInt(point);
        int gc = Integer.parseInt(gamecount);
        this.avgP = (float)p/gc;
    }

    public void setname(String name){
        this.name = name;
    }
    public void setpoint(String point){
        this.point = point;
    }
    public void setrebo(String rebo){
        this.rebo = rebo;
    }
    public void setassi(String assi){
        this.assi = assi;
    }
    public void setfoul(String foul){
        this.foul = foul;
    }
    public void settime(String time){this.time= time;}
    public void setaway(String away){this.away =away;}
    public void sethome(String home){this.home =home;}
    public void setgameD(String gameD){this.gameD = gameD;}
    public void setGamecount(int gamecount){this.gamecount = gamecount;}
    public void setAVGP(float avgP){this.avgP = avgP;}



    public String getname(){
        return name;
    }
    public String getpoint(){
        if(point == null) return "0";
        else return point;
    }
    public String getRebo(){
        return rebo;
    }
    public String getAssi(){
        return assi;
    }
    public String getFoul(){
        return foul;
    }
    public String getTime(){return time;}
    public String getaway(){return away;}
    public String gethome(){return home;}
    public String getgameD(){return gameD;}
    public int getGamecount(){return this.gamecount;}
    public String toString(){
        return "이름 : " + this.name + "\n득점 : " + this.point + "\n리바운드 : " + this.rebo + "\n어시스트 : " + this.assi +"\n파울 : " + this.foul
                + "\nplaytime : "+ this.time + "\nMatch:" + home + " VS " + away + "\n게임일시:" + gameD;
    }

}
