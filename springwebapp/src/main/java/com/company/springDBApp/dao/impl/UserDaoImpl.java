package com.company.springDBApp.dao.impl;

import com.company.springDBApp.dao.inter.*;
import com.company.springDBApp.entities.*;
import org.hibernate.*;
import org.springframework.stereotype.*;

import javax.persistence.Query;
import javax.persistence.*;
import java.util.*;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserEntity> getAll(String nm, String surname, Integer nationalityID) {
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

    @Override
    public UserEntity getUserByEmailAndPassword(String email, String password) {
        String query = "from UserEntity where email=:email and password=:password";
        return (UserEntity) em.createQuery(query)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    public UserEntity getByID(int id) {
        String query = "from UserEntity where id=:id";
        return (UserEntity) em.createQuery(query).setParameter("id", id).getSingleResult();
    }

    @Override
    public boolean addUser(UserEntity u) {
        try {
            em.merge(u);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(UserEntity u) {
        try {
            em.merge(u);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        SessionFactory sf = buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        try {
            s.remove(getByID(id));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        s.getTransaction().commit();
        return true;
    }
}
