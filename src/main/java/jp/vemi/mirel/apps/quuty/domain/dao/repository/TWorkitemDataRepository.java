/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.vemi.mirel.apps.quuty.domain.dao.entity.TWorkitemData;

public interface TWorkitemDataRepository extends JpaRepository<TWorkitemData, String>{
  
}
