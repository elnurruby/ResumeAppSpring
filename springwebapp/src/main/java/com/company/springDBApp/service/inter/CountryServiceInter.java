package com.company.springDBApp.service.inter;

import com.company.springDBApp.entities.*;

import java.util.*;

public interface CountryServiceInter {
    List<CountryEntity> getAllCountry();
    CountryEntity getByID(Integer id);

}
