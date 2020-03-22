package com.edu.test;

import com.edu.dao.UserMapper;
import com.edu.entry.User;
import com.edu.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis-config.xml"})
public class ServiceTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserWithTelAndPassword(){
        User user = new User("13281682261","123456");
        System.out.println("账号"+user.getTel()+"密码"+user.getPassword());
        boolean result = userService.findUserWithTelAndPassword(user);
        System.out.println(result);

    }
}
