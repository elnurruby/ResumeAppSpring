package com.company.springDBApp.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "skill", schema = "resume")
public class SkillEntity {
    private int id;
    private String name;
    private int power;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "power", nullable = false)
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillEntity that = (SkillEntity) o;
        return id == that.id && power == that.power && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, power);
    }

}
