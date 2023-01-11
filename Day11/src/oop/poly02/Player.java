package oop.poly02;

public abstract class Player {
	
	
	private final String id;
	private int level;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level < 1)return;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	
	
	public Player(String id) {
		this.id = id;
		this.level = 1;
	}

	
	public abstract void attack();
	public abstract void move();
	public abstract void market();
	public final void output() {
	 System.out.println("<캐릭터 정보>");
	 System.out.println("아이디 : " + id);
	 System.out.println("레벨 : " + level);
	}

}
