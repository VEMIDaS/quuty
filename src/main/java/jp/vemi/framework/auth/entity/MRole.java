/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mir_role")
@Data
public class MRole {
  @Id
  @Column
  String roleId;
  @Column
  String roleName;
}
