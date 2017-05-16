package bz.beppe.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class MyJob implements Job{

	
	
	/*public void schedule(){
		System.out.println("开始了新的任务");
	}*/

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("定时执行了");
	}

	

}
