package Parkhaussystem;

import java.util.Calendar;
import java.util.Date;

public class Singleton_Parkhaus {
    private static Singleton_Parkhaus only_instance;
    private static byte counter;

	private ViewTageseinnahmen viewTageseinnahmen;
	private ViewParkdauer viewParkdauer;
	private Model model;
	private Controller controller;
	
	private static TagesEinnahmen tagesEinnahmen;
	private static MinutenEinnahmen minutenEinnahmen;

    static {
        //wird beim Laden der Klasse ausgeführt

        only_instance = new Singleton_Parkhaus();
        counter = 0;
    }


    private Singleton_Parkhaus(){
        //Konstruktor private

        counter++;
        this.model = new Model();
        this.viewTageseinnahmen = new ViewTageseinnahmen(Calendar.getInstance());
        this.model.anmelden(this.viewTageseinnahmen);
        this.viewParkdauer = new ViewParkdauer(1);
        this.model.anmelden(this.viewParkdauer);
        this.controller = new Controller(this.model, this.viewTageseinnahmen);
        tagesEinnahmen = TagesEinnahmen.getInstance();
        minutenEinnahmen = MinutenEinnahmen.getInstance();
        
    }
    
    
    public void setViewTageseinnahmen(Calendar date) {
    	this.viewTageseinnahmen = new ViewTageseinnahmen(date);
    	this.model.anmelden(this.viewTageseinnahmen);
    }
    
    public ViewTageseinnahmen getViewTageseinnahmen() {
    	return this.viewTageseinnahmen;
    }
    
    public void setViewParkdauer(int id) {
    	this.viewParkdauer = new ViewParkdauer(id);
    	this.model.anmelden(this.viewParkdauer);
    }
    
    public ViewParkdauer getViewParkdauer() {
    	return this.viewParkdauer;
    }
    
    public void setController() {
    	this.controller = new Controller(this.model, this.viewTageseinnahmen);
    }
    
    public Controller getController() {
    	return this.controller;
    }
    
    public void stringIncoming(String incoming) {
    	this.controller.setValues(incoming);
    }

    public static Singleton_Parkhaus getInstance(){
        return only_instance;
    }

    public static boolean invariant(){
        return counter==1;
    }
    
    
    public void carLeft(String s) {
    	carLeft_TagesEinnahmen(s);
    	carLeft_MinutenEinnahmen(s);
    }
    
    private void carLeft_MinutenEinnahmen(String s) {
    	minutenEinnahmen.splitten(s);
    	System.out.println(minutenEinnahmen.check(new Date((minutenEinnahmen.unixStampLong+minutenEinnahmen.vergangeneZeit))) + "minuten");
    	if(!minutenEinnahmen.check(new Date((minutenEinnahmen.unixStampLong+minutenEinnahmen.vergangeneZeit)))){
    		minutenEinnahmen.initialsieren();
    		minutenEinnahmen.minutenEinnahmen = minutenEinnahmen.gebuehr;
    		minutenEinnahmen.datum = new Date((minutenEinnahmen.unixStampLong+minutenEinnahmen.vergangeneZeit));
        }
    	else {
    		minutenEinnahmen.aufaddieren(minutenEinnahmen.gebuehr);
    	}
    }

    public float getMinutenEinnahmen() {
    	return minutenEinnahmen.minutenEinnahmen;
    }

    private void carLeft_TagesEinnahmen(String s) {
    	tagesEinnahmen.splitten(s);
    	System.out.println(tagesEinnahmen.check(new Date((tagesEinnahmen.unixStampLong+tagesEinnahmen.vergangeneZeit))) + "tag");
    	if(!tagesEinnahmen.check(new Date((tagesEinnahmen.unixStampLong+tagesEinnahmen.vergangeneZeit)))){
    		tagesEinnahmen.initialsieren();
    		tagesEinnahmen.tagesEinnahmen = tagesEinnahmen.gebuehr;
    		tagesEinnahmen.datum = new Date((tagesEinnahmen.unixStampLong+tagesEinnahmen.vergangeneZeit));
        }
    	else {
    		tagesEinnahmen.aufaddieren(tagesEinnahmen.gebuehr);
    	}
    }
    
    public float getTagesEinnahmen() {
    	return tagesEinnahmen.tagesEinnahmen;
    }

}
