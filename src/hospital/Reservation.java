package Hospital;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mgr.Manageable;

public class Reservation extends Reception{
		ArrayList <Vaccination> typeList = new ArrayList<>();
		public void setType(Vaccination v) {  //예방접종 종류 리스트 복사
			typeList = v.typeList;
		}
		Scanner scanner = new Scanner(System.in);
		
		
		static List<String> getStringList(Scanner scan) { // 날짜랑 정보 같이 입력받음, 예약리스트에 저장
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
		
		public search(int kwd) { //날짜 선택해서 해당 날짜 현황 보여줌
			if (date==kwd) {
				for( String s : reserveList ) 
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
