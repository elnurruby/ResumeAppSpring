package com.company.springDBApp.dao.inter;

import com.company.springDBApp.entities.*;
import org.springframework.stereotype.*;

import java.util.*;

public interface UserRepositoryCustom {
    List<UserEntity> getAll(String nm, String surname, Integer nationalityID);
}
