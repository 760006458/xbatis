package com.xforceplus.v1;

import java.util.UUID;

/**
 * @author xuan
 * @create 2020-01-10 17:59
 **/
public class Main {

    public static void main(String[] args) {
//        XSqlSession session = new XSqlSession(new Configuration(), new Executor());
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        User user = mapper.getById(1L);
//        System.out.println(user);

        System.out.println(UUID.randomUUID().toString());
    }
}
