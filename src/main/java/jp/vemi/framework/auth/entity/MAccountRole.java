/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mir_account_role")
@Data
public class MAccountRole {

  @EmbeddedId
  PK pk;

  @Embeddable
  public static class PK implements Serializable {
    @Column
    String accountId;
    @Column
    String roleId;
  }
}
