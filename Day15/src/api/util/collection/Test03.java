package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
		
		Random r = new Random();
//		List<Integer> lottery = new ArrayList<Integer>();
		List<Integer> lottery = new ArrayList<>();
		
		
		while(lottery.size() < 6) {
			int lotto = r.nextInt(45) +1;
			if(lottery.contains(lotto)) {	
				lottery.add(lotto);
			}
			
		}
		System.out.println(lottery);
	}

}
