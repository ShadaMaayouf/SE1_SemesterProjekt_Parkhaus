package Parkhaussystem;

import java.util.Calendar;
import java.util.Date;

public class MinutenEinnahmen extends SummenKlasse {
    Date datum;
	boolean neueMinute = true;
	
	private static MinutenEinnahmen singleton;
	
	static {
		singleton = new MinutenEinnahmen();
	}
	
	private MinutenEinnahmen() {
		super();
	}
	
	public static MinutenEinnahmen getInstance() {
		return singleton;
	}

	@Override
	public boolean check(Date datum2) {
		// TODO Auto-generated method stub
		 if(neueMinute) {
	            this.datum = datum2;
	            neueMinute = false;
	            return true;
	        }
	        Calendar c1 = Calendar.getInstance();
	        Calendar c2 = Calendar.getInstance();
	        c1.setTime(this.datum);
	        c2.setTime(datum2);

	        boolean sameMinute =c1.get(Calendar.MINUTE) == c2.get(Calendar.MINUTE) &&
	                c1.get(Calendar.HOUR_OF_DAY) == c2.get(Calendar.HOUR_OF_DAY) &&
	    	                c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) && 
	    	                c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
	        System.out.println(c1.getTime()+"      c1     "+c2.getTime() +"   c2");
	        //System.out.println(c1.get(Calendar.MINUTE)+"c1 minute      "+c2.get(Calendar.MINUTE)+"c2 minute");
	        return sameMinute;
	        }

	@Override
	public void initialsieren() {
           super.minutenEinnahmen = 0.0f;	
	}

	@Override
	public void aufaddieren(float gebuehr) {
           super.minutenEinnahmen += gebuehr;		
	}

	@Override
	public float rueckgabewert() {
		return super.minutenEinnahmen;
	}

}
