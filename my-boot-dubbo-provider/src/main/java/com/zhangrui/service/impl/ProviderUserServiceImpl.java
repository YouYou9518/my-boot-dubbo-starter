package com.zhangrui.service.impl;

import com.zhangrui.pojo.User;
import com.zhangrui.service.ProviderUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author zhangrui
 * @create 2022-08-19 17:07
 */
@Component
@DubboService    //暴露服务
public class ProviderUserServiceImpl implements ProviderUserService {
    User user1 = new User("ZhangSan", "18236359518");
    //利用手机号判断传入的user是否存在
    @Override
    public boolean selectUser(User user) {
        return user.getPhoneNum().equals(user1.getPhoneNum());
    }

}
