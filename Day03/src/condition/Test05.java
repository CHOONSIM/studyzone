package condition;
import java.lang.*;

public class Test05 {
	public static void main(String[] args) {
		//ex : 성인은 만원, 나머지는 오천원
		
		int age = 25;
		
		boolean adult = age >= 20;
		
		//int price = 10000 or 5000; ??
		int price;  //맞는지 안맞는지 모르면 안맞는다고 판단
		//price = 10000; 
		//price = 5000;
		//이중에서 골라서 사용
		
		if(adult) {
			price = 10000;  
		}
		else{
			price = 5000;   
		}
		
		System.out.println(price);
		
	}

}
