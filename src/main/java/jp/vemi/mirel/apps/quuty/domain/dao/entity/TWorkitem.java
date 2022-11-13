/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "q_t_workitem")
@Data
@Builder
public class TWorkitem {
  @Id
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column
  String id;
  @Column
  String projectId;
  @Column
  String workitemId;
  @Column
  String workitemTypeId;
  @Column
  String revision;
  @Column
  String title;
  @Column
  String statusCd;
  @Column
  String reason;
  @Column
  String description;
  @Column
  String area;
  @Column
  String iteration;
  @Column
  String assigneeUserCd;
  @Column
  Date createDate;
  @Column
  String updateUserCd;
  @Column
  Date updateDate;

}
