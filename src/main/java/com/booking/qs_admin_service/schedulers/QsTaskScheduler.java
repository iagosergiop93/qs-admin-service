package com.booking.qs_admin_service.schedulers;

import com.booking.qs_admin_service.dtos.tasks.CleanupTimeslotsRequest;
import com.booking.qs_admin_service.messages.taskscheduler.TaskSchedulerProducer;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;

@Component
public class QsTaskScheduler {

    @Autowired
    private TaskSchedulerProducer producer;

    @Scheduled(cron = "0 0 0 ? * MON")
    @SchedulerLock(name = "weeklyTimeslotCleanup", lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M")
    public void scheduleTimeslotCleanup() {
        // Publish the task message to Kafka
        var ctr = new CleanupTimeslotsRequest();
        var today = LocalDate.now();
        var startDate = today.minusDays(30);
        var endDate = today.minusDays(1);
        ctr.setStartDate(startDate);
        ctr.setEndDate(endDate);
        var published = producer.clearTimeslots(ctr);
        // Additional logic and logging can be added here
    }

    @Scheduled(cron = "0 */1 * * * *")
    @SchedulerLock(name = "weeklyTimeslotCleanupTest", lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M")
    public void test() {
        // Publish the task message to Kafka
        var ctr = new CleanupTimeslotsRequest();
        var today = LocalDate.now();
        var startDate = today.minusDays(30);
        var endDate = today.minusDays(1);
        ctr.setStartDate(startDate);
        ctr.setEndDate(endDate);
        var published = producer.clearTimeslots(ctr);
        // Additional logic and logging can be added here
        System.out.println("Event published ? " + published.toString());
    }

}
