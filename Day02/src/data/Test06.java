package data;
import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		//나눗셈, 나머지
		//(중요) 정수끼리 연산시 정수가 나옴
		System.out.println(10 / 3); //나눗셈의 몫
		System.out.println(10 % 3); //나눗셈의 나머지
		
		//(예)
		//집이 10채가 있고 사람이 3명이 있습니다
		//나눠 갖게 되면 한사람당 몇 채를 갖고, 몇 채가 남을까요?
		int house = 10;
		int people = 3;
		int give = house / people;
		int remain = house % people;
		
		System.out.println(give);
		System.out.println(remain);
		
	}

}
