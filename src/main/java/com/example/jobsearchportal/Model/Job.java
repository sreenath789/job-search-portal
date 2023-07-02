package com.example.jobsearchportal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="job")
public class Job {
    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    @Min(value=20001,message = "the salary should be greater than 20000")
    private Double salary;
    private String companyEmail;
    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
}
