package com.example.springtestingpurposes;

import entity.*;

import javax.persistence.*;

public class Test {
    @PersistenceContext
    EntityManager entityManager;


    void doTest(){
        UsernewEntity entity = new UsernewEntity();
        entity.setName("Elnur");
        entityManager.
    }

}
