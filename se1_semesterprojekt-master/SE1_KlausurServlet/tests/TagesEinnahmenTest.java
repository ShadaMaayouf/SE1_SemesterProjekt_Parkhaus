import Parkhaussystem.Singleton_Parkhaus;
import Parkhaussystem.TagesEinnahmen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Parkhaussystem.SummenKlasse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TagesEinnahmenTest {

    String entry2 = "leave,2,1560956075535,3113,311,0bd8e15894ba476337216ce3962770dd,#b0fee7";
    //Singleton_Parkhaus sp = Singleton_Parkhaus.getInstance();
    TagesEinnahmen tagesEinnahmen = TagesEinnahmen.getInstance();


    @Test
    void getInstance() {
        assertEquals(tagesEinnahmen, TagesEinnahmen.getInstance());
        assertEquals(tagesEinnahmen, TagesEinnahmen.getInstance());
    }

    @Test
    void check() {

    }

    @Test
    void initialsieren() {
        tagesEinnahmen.initialsieren();
        assertEquals(0, tagesEinnahmen.rueckgabewert());
    }

    @Test
    void aufaddieren() {
        tagesEinnahmen.aufaddieren(3.0f);
        assertEquals(3.0f, tagesEinnahmen.rueckgabewert());
    }

    @Test
    void rueckgabewert() {


        TagesEinnahmen t = TagesEinnahmen.getInstance();
        String[] s = t.splitten(entry2);

        boolean f = t.check(new java.util.Date(Long.parseLong(s[2])+Long.parseLong(s[3])*1000L));
        Assertions.assertFalse(f);


        if(f){
            assertEquals(311f, t.evaluieren());
        }

        String entry3 = "leave,2,1560956075800,3100,305,0bd8e15894ba476337216ce3962770dd,#b0fee7";
        TagesEinnahmen t2 = TagesEinnahmen.getInstance();
        String[] s2 = t2.splitten(entry3);

        f = t2.check(new java.util.Date(Long.parseLong(s2[2])+Long.parseLong(s2[3])*1000L));
        Assertions.assertTrue(f);
        if(f){
            assertEquals(616f, t.evaluieren());
        }

    }
}
