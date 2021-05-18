package Parkhaussystem;

import java.util.Calendar;
import java.util.Date;

public class TagesEinnahmen extends SummenKlasse {

	private static TagesEinnahmen singleton;
    Date datum;
    boolean neuerTag = true;
    
    static {
    	singleton = new TagesEinnahmen();
    }

    private TagesEinnahmen(){
          super();
        }
    
    public static TagesEinnahmen getInstance() {
    	return singleton;
    }

    @Override
    public boolean check(Date datum2) {

        if(neuerTag) {
            this.datum = datum2;
            neuerTag = false;
            return true;
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(this.datum);
        c2.setTime(datum2);

        boolean sameDay =c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) &&
                c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
        return sameDay;
    }

    @Override
    public void initialsieren() {
        super.tagesEinnahmen = 0;
    }

    @Override
    public void aufaddieren(float gebuehr) {
        super.tagesEinnahmen += gebuehr;
    }

    @Override
    public float rueckgabewert() {
        return this.tagesEinnahmen;
    }


}
