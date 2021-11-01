package com.example.so69787512;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    private int id;
    private String name;
    private String description;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime endEventDateTime;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private String location;
    private boolean free;
    private boolean offline;
}
