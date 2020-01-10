package com.xforceplus.v1;

/**
 * @author xuan
 * @create 2020-01-10 17:59
 **/
public class Main {

    public static void main(String[] args) {
        XSqlSession session = new XSqlSession(new Configuration(), new Executor());
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getById(1L);
        System.out.println(user);
    }
}
