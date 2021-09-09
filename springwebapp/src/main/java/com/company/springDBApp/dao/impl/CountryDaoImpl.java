package com.company.springDBApp.dao.impl;

import com.company.springDBApp.dao.inter.*;
import com.company.springDBApp.entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {
    @Override
    public List<CountryEntity> getAllCountry() {
        return null;
    }

    @Override
    public CountryEntity getByID(Integer id) {
        SessionFactory sf = buildSessionFactory();
        Session s = sf.openSession();
        String hql = "from CountryEntity where id=:id";
        Query q = s.createQuery(hql);
        q.setParameter("id",id);
        return (CountryEntity) q.uniqueResult();
    }
}
