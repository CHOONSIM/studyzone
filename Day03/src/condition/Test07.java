package condition;
import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
		//과속단속 카메라 프로그램
		//KH전자에서 만든 과속단속 카메라는 다음 규칙에 따라서 벌금을 계산합니다
		//50km를 초과하는 속도로 달리는 자동차를 단속
		//기본 벌금은 30000원으로 설정
		//벌금은 제한속도보다 10km 이상 빨라질 때마다 10000원씩 증가
		//자동차 속도를 입력값으로 설정한 뒤 예상되는 벌금을 출력(과속이 아니면 벌금은 없습니다)
		
		//내 풀이
		
		//입력
		int carSpeed = 59;
		int fine = 30000;
		int speedLimit = 50;
		int extraFine = 10000;
		int extraFineSpeed = 10;
		
		//처리
		boolean fine1 = carSpeed <= speedLimit;
		
		//출력
		if(fine1) {
			System.out.println("정상속도 입니다.");
		}
		else {
			System.out.println((carSpeed - speedLimit) / extraFineSpeed * extraFine + fine + "원 입니다.");
		}
	}

}