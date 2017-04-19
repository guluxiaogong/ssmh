package com.antin.test;

import com.alibaba.fastjson.JSON;
import com.antin.entity.AcctUser;
import com.antin.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean.xml", "classpath:spring-transaction.xml", "classpath:spring-hibernate.xml", "classpath:spring-mybatis.xml"})
public class TestUserService {

    private static final Logger LOGGER = Logger
            .getLogger(TestUserService.class);

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        AcctUser acctUser = new AcctUser();
        acctUser.setId(UUID.randomUUID().toString());
        acctUser.setNickName("admin");
        acctUser.setRegisterTime(new Date());
        acctUser.setTelephone("13022221121");
        String id = userService.save(acctUser);
        LOGGER.info(JSON.toJSONString(id));
    }

}