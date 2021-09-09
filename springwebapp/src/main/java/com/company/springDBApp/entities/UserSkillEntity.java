package com.company.springDBApp.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_skill", schema = "resume")
public class UserSkillEntity {
    private int id;
    private Integer userId;
    private Integer skillId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "skill_id", nullable = true)
    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSkillEntity that = (UserSkillEntity) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, skillId);
    }
}
