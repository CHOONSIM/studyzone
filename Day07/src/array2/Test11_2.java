package array2;

public class Test11_2 {
	public static void main(String[] args) {
		
		//삽입정렬
		//1회차 의미X , 자리하나 지정 후 정렬
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//삽입정렬
		for(int k=0; k < data.length; k++) {
		int index = k; //(0~4)
		int backup = data[index]; //int backup = data[20];
		
		//비교
		//backup vs data[index -1]
		//backup vs data[index -2]
		//...
		for(int i=index-1; i>=0; i--) {
			//System.out.println("i = " + i + ", backup = " + backup);
			if(backup < data[i]){//backup보다 큰 데이터가 발견되었다면
				data[i+1] = data[i]; //해당 데이터를 오른쪽으로 한 칸 이동시키세요
				index--; //index 위치를 왼쪽으로 한칸 이동합니다. (index : backup이 들어갈자리)
			}
		}
		//index가 삽일될 위치
		System.out.println("index = " + index);
		data[index] = backup;
		//출력
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		}
		System.out.println();
		}
	}


