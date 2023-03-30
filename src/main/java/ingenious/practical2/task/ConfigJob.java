package ingenious.practical2.task;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ConfigJob {

    @Value("${crontabvalue}")
    String crontValue;

    @Bean
    public JobDetail jobBDetails() {
        return JobBuilder.newJob(StockJob.class).withIdentity("sampleJobB").storeDurably().build();
    }
    @Bean
    public Trigger jobBTrigger(JobDetail jobBDetails) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("somedata", UUID.randomUUID().toString());
        return TriggerBuilder.newTrigger()
                .forJob(jobBDetails)
                .withIdentity("TriggerB")
                .withSchedule(CronScheduleBuilder.cronSchedule(crontValue))
                .usingJobData(jobDataMap)
                .build();
    }
}
