/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mir_account")
@Data
public class MAccount {
  @Id
  @Column
  String accountId;
  @Column
  String userCd;
  @Column
  String displayName;
  @Column
  String email;
  @Column
  Date startDate;
  @Column
  Date endDate;
  @Column
  String password;
  @Column
  Boolean deleteFlag;
}
