package bz.beppe.quartz;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo extends JobBuilder {

	@Test
	public void quartzTest(){
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			JobDetail detail = newJob(MyJob.class).withIdentity("job1", "group1")
				      .build();
			Trigger trigger = newTrigger()
				      .withIdentity("trigger1", "group1")
				      .startNow().withSchedule(simpleSchedule()
				              .withIntervalInSeconds(40)
				              .repeatForever())            
				      .build();
			scheduler.scheduleJob(detail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
