package com.javacodegeeks.ultimate.Entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekish on 9/11/2015.
 */


@Entity
@Table(name = "T_GEEK")
public class Geek extends Person {
    private String favouriteProgrammingLanguage;
    private List<Project> projects = new ArrayList<Project>();

    @Column(name = "FAV_PROG_LANG")
    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }

    @ManyToMany
    @JoinTable(
            name = "T_GEEK_PROJECT",
            joinColumns = {@JoinColumn(name = "GEEK_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")}
    )
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
