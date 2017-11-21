package bz.beppe.test.thread;



public class Food {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		int random = (int)(Math.random()*4);
		System.out.println(random);
	}
	
}
