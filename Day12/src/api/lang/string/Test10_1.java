package api.lang.string;

public class Test10_1 {
	public static void main(String[] args) {
		//날짜 검사 프로그램
		String day = "2004-02-29";
		
		String year = day.substring(0, 4);
		System.out.println(year);
		
		int yearValue = Integer.parseInt(year);
		System.out.println(yearValue);
		
		boolean leap = yearValue % 4 == 0 && yearValue % 100 != 0 || yearValue % 400 == 0;
		//int max = 8 or 9;
		int max;
		if(leap) max = 9;
		else max = 8;
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-"+max+"])))$";
		
//		if(Pattern.matches(regex, day)) {
		if(day.matches(regex)) {
			System.out.println("올바른 날짜");
		}
		else {
			System.out.println("잘못된 날짜");
		}
	}
}