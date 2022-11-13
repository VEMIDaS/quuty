/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_m_iteration")
@Data
@Builder
public class MIteration {
  @Id
  @Column
  String id;
  @Column
  String iterationName;
  @Column
  String parentIterationName;
}
