/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jp.vemi.framework.auth.entity.MAccount;
import jp.vemi.framework.auth.repository.AccountRepository;

/**
 * ユーザ情報サービス。
 */
public class MirelUserDetailsService implements UserDetailsService {

  @Autowired
  AccountRepository accountRepository;

  /**
   * @param userCd ユーザコード
   * @return {@link UserDetails ユーザ情報}
   */
  @Override
  public UserDetails loadUserByUsername(String userCd) throws UsernameNotFoundException {
    if (StringUtils.isEmpty(userCd)) {
      throw new UsernameNotFoundException("input userCd.");
    }

    MAccount mAccount = accountRepository.findByAccountId(userCd);
    if (null == mAccount) {
      throw new UsernameNotFoundException("user not found.");
    }
    return new MirelAccountDetails(mAccount, AuthorityUtils.createAuthorityList("USER"));
  }

  /**
   * ユーザパスワードを保存します。
   * 
   * @param userCd   ユーザコード
   * @param password 暗号化されたパスワード
   */
  @Transactional
  public void saveUserPassword(String userCd, String password) {
    if (StringUtils.isAnyEmpty(userCd, password)) {
      return;
    }
    MAccount mAccount = accountRepository.findByAccountId(userCd);
    if (null == mAccount) {
      mAccount = new MAccount();
      accountRepository.save(mAccount);
    } else {
      accountRepository.save(mAccount);
    }
  }
}
