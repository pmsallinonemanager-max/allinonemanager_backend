package com.mobile.allinonemanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.allinonemanager.entity.CreditCardInfo;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCardInfo, Integer> {

	List<CreditCardInfo> findByUserId(Integer userId);

}
