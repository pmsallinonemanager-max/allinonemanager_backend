package com.mobile.allinonemanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.allinonemanager.entity.CcDueDetailsInfo;

@Repository
public interface CcDueDetailsRepo extends JpaRepository<CcDueDetailsInfo, Integer> {

	List<CcDueDetailsInfo> findByCcIdOrderByDueDateDesc(Integer ccId);

	List<CcDueDetailsInfo> findByCcIdInOrderByDueDateDesc(List<Integer> ccIds);

}
