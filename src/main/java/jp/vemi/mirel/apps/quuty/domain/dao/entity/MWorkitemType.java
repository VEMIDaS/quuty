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
@Table(name = "q_m_workitem_type")
@Data
@Builder
public class MWorkitemType {

  @EmbeddedId
  PK pk;
  @Column
  String workitemTypeName;
  @Column
  Integer sortNo;
  @Column
  String color;

  @Embeddable
  @Data
  @Builder
  public static class PK implements Serializable {
    @Column
    String projectId;
    @Column
    String workitemTypeId;
  }
}
