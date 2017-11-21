package bz.beppe.test.thread;



public class Person implements Runnable{

	private int money;
	Bank bank;
	public Person(Bank bank){
		this.bank=bank;
	}
	
	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}



	@Override
	public void run() {
		synchronized ("lock") {
		while(bank.money>0){
				bank.getCountMoney(money);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
