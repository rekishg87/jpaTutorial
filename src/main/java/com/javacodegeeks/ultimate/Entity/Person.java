package com.javacodegeeks.ultimate.Entity;

import javax.persistence.*;

/**
 * Created by Rekish on 9/11/2015.
 */

@Entity
@Table(name = "T_PERSON")
public class Person {
    private Long id;
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
