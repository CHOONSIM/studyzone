package array;

public class Test04 {

	public static void main(String[] args) {
//		어떤 반 학생 10명의 성적정보는 다음과 같습니다
//
//		점수 : [90, 85, 51, 63, 77, 71, 77, 85, 99, 70]
//		요구사항을 지켜 프로그래밍 하세요
//
//		모든 학생의 점수를 출력
//		모든 학생에 대한 평균 점수를 출력
//		재평가자(60점 미만) 인원수를 출력
//		성적 우수자(90점 이상) 인원수를 출력
//		만약 이 반에 새로 들어온 학생이 80점이면 몇 등인지 계산하여 출력
		
		int[] data = new int[] {90, 85, 51, 63, 77, 71, 77, 85, 99, 70};

//		모든 학생의 점수를 출력
		for(int i=0; i<data.length; i++) {
			System.out.println("점수 = "+data[i]);
		}
		
		System.out.println();
		
		
//		모든 학생에 대한 평균 점수를 출력	
		int total=0;
		for(int i=0; i<data.length; i++) {
			total += data[i];
		}
		//System.out.println(total);
		double average = (double)total / data.length;
		System.out.println("평균 = " + average);
		
		System.out.println();
		
//		재평가자(60점 미만) 인원수를 출력
		int count = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i] <60) {
				count++;
			}
		}
		System.out.println("재평가자 인원 = "+count+" 명");
		
		System.out.println();
		
//		성적 우수자(90점 이상) 인원수를 출력
		int cnt = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i] >= 90) {
				cnt++;
			}
		}
		System.out.println("성적우수자 = "+cnt+" 명");
		
		
		System.out.println();
		
		
//		만약 이 반에 새로 들어온 학생이 80점이면 몇 등인지 계산하여 출력
		int cnt1 = 1; //등수는 1등부터 (등수 = 1+나보다 점수가 높은 인원수)
		int stu = 80;
		int totalStudents = data.length+1; 
		for(int i=0; i<data.length; i++) {
			if(stu<data[i]) {
				cnt1++;
			}
		}
		System.out.println("총"+totalStudents+"명 중"+ cnt1+"등");
		
		
//      번외) 모든 학생의 등수 구하기
//		- 등수를 10개 구해야 핟나(변수 10개 or 배열1개)
		int[] rank = new int[] {
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1,	
		};

//      등수 계산
		
		for(int i=0; i < data.length; i++) {   //for(int i=0; i <= 9; i++)
			for(int k=0; k < data.length;k++) {
				if(data[i] < data[k]) {   //0~9까지 반복
					rank[i]++;
				}
	     	}
		
		}
		
//      등수 출력
		for(int i=0; i<rank.length; i++) {
			System.out.println(rank[i]);
			System.out.println(" ");
		}
		
		
		
		
		
	}

}