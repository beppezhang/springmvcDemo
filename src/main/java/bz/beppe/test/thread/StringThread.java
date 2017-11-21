package bz.beppe.test.thread;

public class StringThread implements Runnable{
	
	private String str="";
	
	public StringThread(String str) {
		super();
		this.str = str;
	}
	StringBuffer sb=new StringBuffer();
	
	public void strAdd(String str){

		sb.append(str);
		System.out.println(sb.toString()+"========"+Thread.currentThread().getName());
	}
	
	
	@Override
	public void run() {
		sb.append(str);
		System.out.println(sb.toString()+"========"+Thread.currentThread().getName());
	} 
	
	
}
