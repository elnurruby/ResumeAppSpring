package com.company.springDBApp.service.impl;

import com.company.springDBApp.entities.*;
import com.company.springDBApp.service.inter.*;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.*;

public class CountryServiceImpl extends AbstractDao implements CountryServiceInter {
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
