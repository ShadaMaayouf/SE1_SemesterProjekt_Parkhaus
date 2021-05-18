package Parkhaussystem;

import java.util.Date;

public abstract class SummenKlasse {

    float tagesEinnahmen, wochenEinnahmen, monatsEinnahmen, jahresEinnahmen, minutenEinnahmen;
    Float gebuehr;
    String[] parameters;
    Long unixStampLong;
    Long vergangeneZeit;


   
    public String[] splitten(String s){
        this.parameters = s.split(",");
        this.gebuehr = Float.parseFloat(parameters[4]);
        this.unixStampLong = Long.parseLong(parameters[2]);
        this.vergangeneZeit = Long.parseLong(parameters[3]);
        return parameters;
    }
    
    public SummenKlasse(){

    }


    public float evaluieren()
    {
        initialsieren();
        aufaddieren(this.gebuehr);
        return rueckgabewert();
    }

    //Template methods
    public abstract boolean check(Date datum2);
    public abstract void initialsieren();
    public abstract void aufaddieren(float gebuehr);
    public abstract float rueckgabewert();

    
}
