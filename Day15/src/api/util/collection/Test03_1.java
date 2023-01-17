package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test03_1 {

	public static void main(String[] args) {
		
		Random r = new Random();
//		List<Integer> lottery = new ArrayList<Integer>();
		List<Integer> lottery = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			int lotto = r.nextInt(45) +1;
			if(lottery.contains(lotto)) {	//똑같은 숫자가 없다면
				lottery.add(lotto);
			}
			else {
				i--;						//다시 뽑아라
			}
		}
		System.out.println(lottery);
		
		
		
		
		
		

	}

}
