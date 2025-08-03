package com.booking.qs_admin_service.messages.taskscheduler;

import com.booking.qs_admin_service.dtos.tasks.CleanupTimeslotsRequest;
import com.booking.qs_admin_service.dtos.tasks.CreateTimeslotsRequest;
import com.booking.qs_admin_service.messages.BaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedulerProducer {

    @Autowired
    private StreamBridge streamBridge;

    public Boolean clearTimeslots(CleanupTimeslotsRequest ctr) {
        var baseMessage = new BaseMessage<CleanupTimeslotsRequest>(ctr);
        var message = new GenericMessage<>(baseMessage);
        return this.streamBridge.send("task-timeslot-cleanup",message);
    }

}
