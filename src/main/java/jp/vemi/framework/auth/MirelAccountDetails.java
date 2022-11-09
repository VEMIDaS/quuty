/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.vemi.framework.auth.entity.MAccount;

public class MirelAccountDetails implements UserDetails {

  MAccount mAccount;

  private Collection<GrantedAuthority> authorities;

  /**
   * Default constructor.
   * 
   * @param mAccount {@link MAccount}
   * @param authorities {@link Collection<GrantedAuthority>}
   */
  public MirelAccountDetails(MAccount mAccount, Collection<GrantedAuthority> authorities) {
    this.mAccount = mAccount;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.mAccount.getPassword();
  }

  @Override
  public String getUsername() {
    return this.mAccount.getUserCd();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
