package com.example.pj2be.domain.admin;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class SuspensionDTO {
    private Integer id;
    private String member_id;
    private Boolean is_suspended;
    private String reason;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Integer period;
    private Integer remaindate;
    private LocalTime remaintime;
}
