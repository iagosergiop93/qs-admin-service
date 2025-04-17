package com.booking.qs_admin_service.dtos.tasks;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CleanupTimeslotsRequest {
    private List<String> orgIds = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
}
