package com.xforceplus.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xuan
 * @create 2020-01-10 21:22
 **/
public class MapperProxy implements InvocationHandler {

    private XSqlSession session;

    MapperProxy(XSqlSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return session.selectOne(method.getDeclaringClass().getName() + "." + method.getName(), args[0]);
    }
}
