package com.xforceplus.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @author xuan
 * @create 2020-01-10 18:00
 **/
public class Configuration {

    private static ResourceBundle config;

    static {
        config = ResourceBundle.getBundle("v1/config");
    }

    public <T> T newProxyInstance(Class<T> c, final XSqlSession session) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{c}, new MapperProxy(session));
    }

    public String getStatement(String statementId) {
        return config.getString(statementId);
    }
}
