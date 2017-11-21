package bz.beppe.test.thread;



import java.util.ArrayList;
import java.util.List;

public class KFCStore {

//	食物种类
	private String names[]={"薯条","鸡翅","汉堡","可乐"};
	
	private static int max=20;
	
	private List<Food> foods=new ArrayList<>();
	
	public void produce(int indx){
//		食材够了的情况下进行等待  食材数量>20
		while(foods.size()>max){
			System.out.println("食材够了！");
			this.notifyAll();
			try {
				String name = Thread.currentThread().getName();
				this.wait();
				System.out.println("生产者："+name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		开始生产食材
		for(int i=0;i<indx;i++){
			Food food=new Food();
			food.setName(names[(int)(Math.random()*4)]);
			foods.add(food);
			System.out.println("生产了："+food.getName()+"长度是"+foods.size());
		}
		
	}
	
	public void consume(int indx){
//		食材不够
		while(foods.size()<indx){
			System.out.println("食材不够了");
			this.notifyAll();
			try {
				String name = Thread.currentThread().getName();
				this.wait();
				System.out.println("消费者："+name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //停止消费
//			足够消费的情况下
			System.out.println("开始消费");
			
		}
	}
}
