import Parkhaussystem.Singleton_Parkhaus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Singleton_ParkhausTest {

    @Test
    void setViewTageseinnahmen() {
        // kommt nirgendwo vor
    }

    @Test
    void getViewTageseinnahmen() {
    }

    @Test
    void setViewParkdauer() {
    }

    @Test
    void getViewParkdauer() {
    }

    @Test
    void setController() {
    }

    @Test
    void getController() {
    }

    @Test
    void stringIncoming() {
    }

    @Test
    void getInstance() {
        Singleton_Parkhaus sp = Singleton_Parkhaus.getInstance();

        assertEquals(sp, Singleton_Parkhaus.getInstance());
        assertEquals(sp, Singleton_Parkhaus.getInstance());
        assertEquals(sp, Singleton_Parkhaus.getInstance());

        assertEquals(Singleton_Parkhaus.getInstance(), Singleton_Parkhaus.getInstance());
        assertEquals(Singleton_Parkhaus.getInstance(), Singleton_Parkhaus.getInstance());
        assertEquals(Singleton_Parkhaus.getInstance(), Singleton_Parkhaus.getInstance());
    }


    @Test
    void invariant() {
    }

    @Test
    void carLeft() {
    }

    @Test
    void getMinutenEinnahmen() {
    }

    @Test
    void getTagesEinnahmen() {
    }
}
