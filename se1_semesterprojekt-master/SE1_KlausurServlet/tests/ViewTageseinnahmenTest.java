import Parkhaussystem.Controller;
import Parkhaussystem.Model;
import Parkhaussystem.ViewTageseinnahmen;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

class ViewTageseinnahmenTest {

    String entry0 = "enter,1,1560956068177,_,_,38f378d76d969625d0f54d644cef0b05,#915a74";
    String entry1 = "enter,2,1560956075535,_,_,0bd8e15894ba476337216ce3962770dd,#b0fee7";
    String entry2 = "leave,2,1560956075535,3113,311,0bd8e15894ba476337216ce3962770dd,#b0fee7";
    String entry3 = "enter,3,1560956082160,_,_,725ce2ce061c7a85bda2b0fab2c4b7e7,#61f7b1";
    String entry4 = "enter,4,1560956084120,_,_,8ba974810ec2a83ba0323d7c0b0de140,#b9955a";
    String entry5 = "leave,1,1560956068177,18607,1861,38f378d76d969625d0f54d644cef0b05,#915a74";
    String entry6 = "leave,4,1560956084120,7960,796,8ba974810ec2a83ba0323d7c0b0de140,#b9955a";
    String entry7 = "leave,3,1560956082160,13424,1342,725ce2ce061c7a85bda2b0fab2c4b7e7,#61f7b1";
    String entry8 = "enter,5,1560956097032,_,_,59aac08cf91520b2b8c9baa8e8687823,#d47d19";
    String entry9 = "leave,5,1560956097032,2407,241,59aac08cf91520b2b8c9baa8e8687823,#d47d19";
    String entry10 = "enter,6,1560962475000,_,_,test,test";

    Model model = new Model();

    ViewTageseinnahmen einnahmen20190619 = new ViewTageseinnahmen(new GregorianCalendar(2019,5,19));
    Controller einnahmen20190619Controller = new Controller(model, einnahmen20190619);
    //model.anmelden(einnahmen20190619);




    @Test
    void aktualisieren() {
    }

    @Test
    void showDate() {
    }

    @Test
    void getValue() {
    }

    @Test
    void getTable() {
    }
}
