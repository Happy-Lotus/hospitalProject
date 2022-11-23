package hospital;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class Reservation extends Reception implements UIData, Manageable {
    Scanner scan = new Scanner(System.in);

    Reservation(){	}

    public Reservation(Object[] row) {

    }

    public void read() {
        super.read(scan);


        //super.addReception(this);
        //Main.receptionMgr.printAll();
    }
}