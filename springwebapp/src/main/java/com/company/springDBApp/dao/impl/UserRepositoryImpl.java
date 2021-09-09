package com.company.springDBApp.dao.impl;

import com.company.springDBApp.dao.inter.*;
import com.company.springDBApp.entities.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    public List<UserEntity> getAll(String nm, String surname, Integer nationalityID){
        String query = "from UserEntity userEntity where 1=1";
        if (nm != null && !nm.trim().isEmpty()) {
            query += " and userEntity.name=:nm";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query += " and userEntity.surname=:surname";
        }
        boolean check = String.valueOf(nationalityID).isEmpty();
        if (nationalityID != null && !check) {
            query += " and userEntity.nationalityId=:nationalityID";
        }
        Query q = em.createQuery(query);
        if (nm != null && !nm.trim().isEmpty()) {
            q.setParameter("nm", nm);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityID != null && !check) {
            q.setParameter("nationalityID", nationalityID);
        }
        return (List<UserEntity>) q.getResultList();
    }

}
