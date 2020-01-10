package com.xforceplus.v1;

/**
 * @author xuan
 * @create 2020-01-10 18:00
 **/
public class XSqlSession {

    private Configuration configuration;

    private Executor executor;

    public XSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> c) {
        return configuration.newProxyInstance(c, this);
    }

    public <T> T selectOne(String statementId, Object parameter) {
        return executor.query(configuration.getStatement(statementId), parameter);
    }
}
