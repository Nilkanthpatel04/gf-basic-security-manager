package com.vmware.gemfire;

import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.security.AuthInitialize;
import org.apache.geode.security.AuthenticationFailedException;

import java.util.Properties;

public class UserPasswordAuthInit implements AuthInitialize {

  @Override
  public Properties getCredentials(Properties properties, DistributedMember distributedMember, boolean isPeer) throws AuthenticationFailedException {
    properties.setProperty("security-username", "gemfire");
    properties.setProperty("security-password", "changeme");
    return properties;
  }
}
