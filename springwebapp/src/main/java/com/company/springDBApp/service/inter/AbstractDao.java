package com.company.springDBApp.service.inter;

import org.hibernate.*;
import org.hibernate.cfg.*;


public abstract class AbstractDao {
    public SessionFactory buildSessionFactory() {
        Configuration cfg = new Configuration()
                .configure();
        SessionFactory sf = cfg.buildSessionFactory();

        return sf;
    }
}
