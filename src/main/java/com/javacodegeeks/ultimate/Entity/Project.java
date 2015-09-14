package com.javacodegeeks.ultimate.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekish on 9/14/2015.
 */

@Entity
@Table(name = "T_PROJECT")
public class Project {
    private Long id;
    private String title;
    private List<Geek> geeks = new ArrayList<Geek>();
    private Period projectPeriod;
    private List<Period> billingPeriods =new ArrayList<Period>();
    private ProjectType projectType;

    public enum ProjectType {
        FIXED, TIME_AND_METERIAL
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "projects")
    public List<Geek> getGeeks() {
        return geeks;
    }
    public void setGeeks(List<Geek> geeks) {
        this.geeks = geeks;
    }

    @Embedded
    public Period getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(Period projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    @ElementCollection
    @CollectionTable(
            name = "T_BILLING_PERIOD",
            joinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    public List<Period> getBillingPeriods() {
        return billingPeriods;
    }

    public void setBillingPeriods(List<Period> billingPeriods) {
        this.billingPeriods = billingPeriods;
    }

    @Enumerated(EnumType.ORDINAL)
    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

}
