package jdbc.test;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.SubjectDao;
import jdbc.dto.SubjectDto;

public class Test04_1 {

	public static void main(String[] args) {
		
//		목록/검색
		
//		Scanner를 사용하면 null이 입력되지 않는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("검색분류 : ");
		String column = sc.nextLine();
		System.out.println("검색어 : ");
		String keyword = sc.nextLine();
		sc.close();
		
		SubjectDao dao = new SubjectDao();
		List<SubjectDto> list;
		if(column != null && !column.equals("") && keyword != null && !keyword.equals("")) {	//Scanner에서는 null입력 불가능
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		if(list.isEmpty()) {
			System.out.println("데이터 없음");
		}
		else {
			System.out.println("데인터 개수 : " + list.size());
			for(SubjectDto dto : list) {
				System.out.println(dto);
			}
		}
		

	}

}
