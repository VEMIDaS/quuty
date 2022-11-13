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

import jp.vemi.mirel.apps.quuty.domain.facade.enumeration.ColumnType;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_m_workitem_type")
@Data
@Builder
public class MWorkitemColumn {

  @EmbeddedId
  PK pk;
  @Column
  ColumnType columnType;
  @Column
  String columnName;
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
    String columnId;
  }
}
