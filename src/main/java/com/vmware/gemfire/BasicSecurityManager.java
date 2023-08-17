package com.vmware.gemfire;

import org.apache.geode.security.AuthenticationExpiredException;
import org.apache.geode.security.AuthenticationFailedException;
import org.apache.geode.security.ResourcePermission;
import org.apache.geode.security.SecurityManager;

import java.util.Properties;

public class BasicSecurityManager implements SecurityManager {

  @Override
  public void init(Properties securityProps) {
    SecurityManager.super.init(securityProps);
  }

  @Override
  public Object authenticate(Properties credentials) throws AuthenticationFailedException {

    Boolean isAuthenticated = false;
    String username = credentials.getProperty("security-username");
    String password = credentials.getProperty("security-password");

    if ("gemfire".equals(username) && "changeme".equals(password) ) {
      isAuthenticated = true;
    } else{
      throw new AuthenticationFailedException("Wrong username/password");
    }
    return isAuthenticated;
  }

  @Override
  public boolean authorize(Object principal, ResourcePermission permission) throws AuthenticationExpiredException {
    return SecurityManager.super.authorize(principal, permission);
  }

  @Override
  public void close() {
    SecurityManager.super.close();
  }

}
