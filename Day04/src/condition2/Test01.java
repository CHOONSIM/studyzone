package condition2;
import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		
		//그룹조건
		
		//피자 25000원, 치킨 18000. 떡볶이 5000원
		//주문할 수 있는 가장 비싼 메뉴를 1개만 추천
		
		int money = 1000;
	
		//boolean order = money >= 25000;
		if(money >= 25000) {
			System.out.println("피자추천");
		}
		else if(money >= 18000) {
				System.out.println("치킨추천");
			}
			else if(money >=5000) {
					System.out.println("떡볶이추천");
				}
				else {
					System.out.println("추천할 메뉴가 없습니다.");
				}
		}
		
	}


