/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_t_workitem_trash")
@Data
@Builder
public class TWorkitemTrash {
  @Id
  @Column
  String id;
  @Column
  String projectCd;
  @Column
  String workitemId;
  @Column
  String revision;
  @Column
  String title;
  @Column
  String statusCd;
  @Column
  String assigneeUserCd;
  @Column
  Date createDate;
  @Column
  String updateUserCd;
  @Column
  Date updateDate;

}
