package com.example.snstk.psrecord;



public class Player {
    private String name;
    private String point;
    private String rebo;
    private String assi;
    private String foul;
    private String time;
    private String home;
    private String away;
    private int gamecount;
    private float avgP;
    private float avgA;
    private float avgR;
   // private String avgP;
    public Player(){}

    public Player(String name,String point, String rebo, String assi, String foul,String time , String home, String away){
        this.name = name;
        this.point = point;
        this.rebo = rebo;
        this.assi = assi;
        this.foul = foul;
        this.time = time;
        this.home  = home;
        this.away =away;
        this.gamecount = 1;
    }

    public void setname(String name){this.name = name;}
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
    public void sethome(String home){this.home= home;}
    public void setaway(String away){this.away = away;}
    public void setGamecount(int g){this.gamecount = g;}
    public void setAvgP(float avgP){
        int poi = Integer.parseInt(point);
        this.avgP = (float)(poi / gamecount);
    }

    public String getName(){return name;}
    public String getpoint(){
        return point;
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
    public String gethome(){return home;}
    public String getaway(){return away;}
    public int getGamecount(){return gamecount;}
    public float getAvgP(){
        int poi = Integer.parseInt(point);
        avgP = (float)(poi / gamecount);
        return avgP;
    }
    public float getAvgA(){
        int aoi = Integer.parseInt(assi);
        avgA = (float)(aoi / gamecount);
        return avgA;
    }
    public float getAvgR(){
        int roi = Integer.parseInt(rebo);
        avgR = (float)(roi / gamecount);
        return avgR;
    }
    public String toString(){
        return "\n득점 : " + this.point + "\n리바운드 : " + this.rebo + "\n어시스트 : " + this.assi +"\n파울 : " + this.foul
                + "\nplaytime : "+ this.time + "\ngamecount : " + this.gamecount;
    }

}

