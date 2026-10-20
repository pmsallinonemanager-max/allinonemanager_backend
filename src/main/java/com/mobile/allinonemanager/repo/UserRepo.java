package com.mobile.allinonemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.allinonemanager.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	@Query(value = "SELECT * FROM users u WHERE u.mobile = :mobile AND u.password = :password", nativeQuery = true)
	Users findByMobileAndPassword(@Param("mobile")String mobile, @Param("password")String password);

}
