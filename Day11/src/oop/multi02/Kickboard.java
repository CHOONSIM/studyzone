package oop.multi02;

public class Kickboard implements Electronic, Transportation{

	@Override
	public void move() {
		System.out.println("전동퀵보드가 이동합니다.");
	}

	@Override
	public void on() {
		System.out.println("전동퀵보드의 전원을 켭니다.");
	}

	@Override
	public void off() {
		System.out.println("전동퀵보드의 전원을 끕니다.");
	}

}