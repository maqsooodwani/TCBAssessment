package hs.com.in.tcb.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hs.com.in.tcb.assessment.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer>{

}
