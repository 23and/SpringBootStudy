package boot.board.schedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            
            JobDetail job = newJob(JobTest.class).withIdentity("job1", "group1").build();

            Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

            scheduler.scheduleJob(job, trigger);
            
            Thread.sleep(70000);

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}