package bz.beppe.test.thread;

public class MyRunnable implements Runnable{

	private StringThread stringThread=null;
	
	
	public MyRunnable(StringThread stringThread) {
		super();
		this.stringThread = stringThread;
	}


	@Override
	public void run() {
		this.stringThread.strAdd("sb");
	}

}
