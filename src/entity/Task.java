package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "task")
@Table(name = "task")
//@Lombok
public class Task implements Serializable {
    @Id
    @Column(name = "task_id", columnDefinition = "number")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title", columnDefinition = "nvarchar2(50)")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "status", columnDefinition = "nvarchar2(20)")
    private String status;

    @Column(name = "duration", columnDefinition = "date")
    private LocalDateTime duration;

    @Column(name = "created_on", columnDefinition = "date")
    private LocalDate createdOn;

    @Column(name = "updated_on", columnDefinition = "date")
    private LocalDate updatedOn;

    public Task() {
    }

    public Task(String title, String description, String status, LocalDateTime duration, LocalDate createdOn, LocalDate updatedOn) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.duration = duration;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Task setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getDuration() {
        return duration;
    }

    public Task setDuration(LocalDateTime duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Task setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public Task setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

}
