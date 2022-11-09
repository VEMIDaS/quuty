/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.vemi.framework.auth.entity.MAccount;

public interface AccountRepository extends JpaRepository<MAccount, String> {
  MAccount findByAccountId(String accountId);
}
