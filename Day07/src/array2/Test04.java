package array2;

public class Test04 {
	public static void main(String[] args) {
        
		//배열 안에서 위치 이동(맞교환)
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//data[0]과 data[3]에 있는 데이터를 서로 교체(swap)하고 싶다면
		//자바는 데이터 맞교환이 불가능
		//별도의 임시변수를 추가하여 교체가 가능하다 (백업추가하여 빼놓고 교환) 

		int backup = data[0];
		data[0] = data[3];
		data[3] = backup;
		
		
		for (int i=0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

}
