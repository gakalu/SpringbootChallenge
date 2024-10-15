package com.getachew.challengeApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity//shows system modele
public class Challenge {
    @Id //assign as a primary key.
    private Long id;
    @Column(name="challengeMonth") //to assign a columenn value
    private String month;
    private String description;

    public Challenge() {
    }

    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public String getMonth() {
        return month;
    }

    public Long getId() {
        return id;
    }
}
