/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_t_workitem_data")
@Data
@Builder
public class TWorkitemData {
  @EmbeddedId
  PK pk;
  @Column
  String columnCd;
  @Column
  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  byte[] data;

  @Embeddable
  @Data
  @Builder
  public static class PK implements Serializable {
    @Column
    String id;
    @Column
    String revision;
  }

}
