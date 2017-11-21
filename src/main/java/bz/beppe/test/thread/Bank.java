package bz.beppe.test.thread;



public class Bank {

	static int money=2000;
	
//	柜台取钱
	public void getCountMoney(int money){
		Bank.money-=money;
		System.out.println(Thread.currentThread().getName()+"柜台取走了"+money+"还剩下"+Bank.money);
	}
	
//	ATM取钱
	public void getATMMoney(int money){
		Bank.money-=money;
		System.out.println("ATM取走了"+money+"还剩下"+Bank.money);
	}
}
