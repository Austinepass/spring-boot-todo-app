package com.orgustine.todo.requestbody;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoRequest {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime finishedTime;
}
