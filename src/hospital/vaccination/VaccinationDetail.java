package hospital.vaccination;

import facade.UIData;
import mgr.Manageable;

import java.util.Scanner;

public class VaccinationDetail implements Manageable, UIData {
    int startTime; // 시기 입력받음.
    int endTime;

    @Override
    public void set(Object[] uitexts) {

    }

    @Override
    public String[] getUiTexts() {
        return new String[0];
    }

    @Override
    public void read(Scanner scan) {
        startTime = scan.nextInt();
        endTime = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf(" %d~%d개월 접종 필요\n",startTime,endTime);
    }

    @Override
    public boolean matches(String kwd) {
        if((startTime+"개월").equals(kwd) || (endTime+"개월").equals(kwd))
            return true;
        return false;
    }
}
