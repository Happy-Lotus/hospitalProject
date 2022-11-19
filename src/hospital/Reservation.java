package hospital;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class Reservation extends Reception implements UIData, Manageable {
	Scanner scan = new Scanner(System.in);

	public void read() {
		super.read(scan);
		super.addReception(this);

	}

	/*List<String> getStringList(Scanner scan) { // 날짜랑 정보 같이 입력받음, 예약리스트에 저장
		Reception.add
			List<String> reserveList = new ArrayList<>();
			String tmp;
			while (true) {
				tmp = scan.next();
				if (tmp.contentEquals("-1"))
					break;
				super.read(scan);
				reserveList.add(tmp);
			}
			return reserveList;
		}
		*/

/*		public Reservation search(String kwd) { //날짜 선택해서 해당 날짜 현황 보여줌
			while(true){
				Main.receptionMgr.find(kwd)
			}){
				for(  )
					if((""+kwd).contentEquals(s))
						return reserveList;
			}
		}
		
		public void addReserve(int kwd) {
			// 예약 버튼 누르면 구현되도록 GUI작성
		}
		
		public boolean matches(String kwd) {
			if(super.matches(kwd)) //진료내역 매치됨
				return true;
			if(!super.symptom.contentEquals(kwd)) { //증상이 kwd와 맞지 않음
				while(true){
					for(Vaccination v : typeList) //예방접종 종류 리스트를 가져와 kwd와 비교
						if(v.matches(kwd))
							return true;
				}
			}
			return false;
	    }
}
*/
}