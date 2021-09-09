package com.company.springDBApp.dao.inter;

import com.company.springDBApp.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>, UserRepositoryCustom {
     UserEntity getUserEntityByEmailAndPassword(String email, String password);
}
