package com.orgustine.todo.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Todos extends BaseModel{
    private String title;
    private String description;
    @CreatedDate
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private LocalDateTime startTime;
    private LocalDateTime finishedTime;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne
    private Users users;
}
