/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_m_workitem_status")
@Data
@Builder
public class MWorkitemStatus {

  @EmbeddedId
  PK pk;
  @Column
  String statusName;
  @Column
  String description;
  @Column
  Integer sortNo;

  @Embeddable
  @Data
  @Builder
  public static class PK implements Serializable {
    @Column
    String projectId;
    @Column
    String statusCd;
  }
}
