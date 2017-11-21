package bz.beppe.test.thread;



public class Station implements Runnable{

	public static int ticket=100;
	@Override
	public void run() {
		
		while(ticket>0){
			 synchronized (this) {
				
				 if(ticket>0){
					 System.out.println(Thread.currentThread().getName()+"卖出了第："+ticket+"张票");
					 ticket--;
				 }else{
					 System.out.println("票卖完了");
				 }
			}
			
//			try {
//				sleep(1000);//休息一秒
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
//	public Station(String name){
//		super(name);
//	}
//
//	public static int ticket=100;
//	
//	
//	public Object ob="lock";
//	@Override
//	public void run() {
////		如果ticket>0 继续卖票
//		while(ticket>0){
//			 synchronized (this) {
//				
//				 if(ticket>0){
//					 System.out.println(getName()+"卖出了第："+ticket+"张票");
//					 ticket--;
//				 }else{
//					 System.out.println("票卖完了");
//				 }
//			}
//			
////			try {
////				sleep(1000);//休息一秒
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
//		}
//		
//	}

}
