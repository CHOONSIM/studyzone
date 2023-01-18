package api.util.collection3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test01 {

	public static void main(String[] args) {
		
//		Queue vs Stack
//		- 사용법이 정해져있는 Collection
//		- Queue는 FIFO(First-In-First-Out, 선입선출) 형태의 저장소		//줄, 대기열
//		- Stack은 LIFO(Last-In-First-Out,  후입선출) 형태의 저장소
		
		Stack<Integer> stack = new Stack<>();		// 한 종류 밖에없음
		stack.push(10);			//10번 글 읽음
		stack.push(12);			//12번 글 읽음
		stack.push(17);			//17번 글 읽음
		stack.push(20);			//20번 글 읽음
		stack.push(25);			//25번 글 읽음
		
		System.out.println(stack.peek());		//가장 최신 데이터 확인저장소 (맨 마지막에 읽은 글 번호)
		
		System.out.println(stack.pop());		//가장 최신 데이터 확인 + 삭제
		
		
		System.out.println("------------------------------");
		
//		LinkedList<Integer> queue = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);			//맨 뒤에 10 줄세우기
		queue.add(12);			//맨 뒤에 12 줄세우기
		queue.add(17);			//맨 뒤에 17 줄세우기
		queue.add(20);			//맨 뒤에 20 줄세우기
		queue.add(25);			//맨 뒤에 25 줄세우기
		
//		System.out.println(queue.peek());		//확인만
		System.out.println(queue.poll());		//확인 + 추출
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
	}

}