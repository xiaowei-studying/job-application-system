package com.example.it.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 岗位实体类，对应jobs表
 */
@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", nullable = false, length = 255)
    private String companyName;

    @Column(name = "position_name", nullable = false, length = 255)
    private String positionName;

    @Column(name = "salary", nullable = false, length = 100)
    private String salary;

    @Column(name = "requirements", nullable = false, columnDefinition = "TEXT")
    private String requirements;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "post_date", length = 50)
    private String postDate;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;
}