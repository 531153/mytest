package com.lxy.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager {
	public static void main(String[] args) {
		simpleDemo();
	}

	public static void simpleDemo() {
		//通过SchedulerFactory来获取一个调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler        scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();

			//引进作业程序
			JobDetail job = JobBuilder.newJob(QuartzDemo.class).withIdentity("jobDetail-s1", "jobDetailGroup-s1").build();

			//定义一个触发器 简单Trigger 设置工作名称与组名 5秒触发一次
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();

			//设置工作 与触发器
			scheduler.scheduleJob(job, trigger);
			// and start it off
			//开始定时任务
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
