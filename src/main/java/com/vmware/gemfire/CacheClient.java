package com.vmware.gemfire;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import java.util.Properties;

public class CacheClient {
  public static void main(String[] args){
    Properties properties = new Properties();
    properties.setProperty("security-client-auth-init", UserPasswordAuthInit.class.getName());

    ClientCache cache = new ClientCacheFactory(properties).addPoolLocator("localhost", 10334).create();
    //ClientCache cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).create();

    Region<String, String>
            testRegion =
            cache.<String, String>createClientRegionFactory(ClientRegionShortcut.PROXY).create("testRegion");

    testRegion.put("1", "one");
    String value1 = testRegion.get("1");
    System.out.println(value1);
    cache.close();
  }
}
