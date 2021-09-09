package com.company.springDBApp.dao.inter;

import com.company.springDBApp.entities.*;

import java.util.*;

public interface CountryDaoInter {
    List<CountryEntity> getAllCountry();
    CountryEntity getByID(Integer id);

}
