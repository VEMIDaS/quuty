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
@Table(name = "q_t_workitem_relation")
@Data
@Builder
public class TWorkitemRelation {

  @EmbeddedId
  PK pk;

  @Embeddable
  public static class PK implements Serializable {
    @Column
    String issueId;
    @Column
    String relatedId;
    @Column
    String relationTypeCd;
  }
}
