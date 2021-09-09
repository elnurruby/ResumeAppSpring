package com.company.springDBApp.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "employment_history", schema = "resume")
public class EmploymentHistoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private int userId;

    @Basic
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "header", nullable = false, length = 45)
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Basic
    @Column(name = "begin_date", nullable = false)
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "job_description", nullable = false, length = -1)
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmploymentHistoryEntity that = (EmploymentHistoryEntity) o;
        return userId == that.userId && Objects.equals(header, that.header) && Objects.equals(beginDate, that.beginDate) && Objects.equals(endDate, that.endDate) && Objects.equals(jobDescription, that.jobDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, beginDate, endDate, jobDescription, userId);
    }
}
