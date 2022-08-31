package com.zhangrui.service.impl;

import com.zhangrui.pojo.User;
import com.zhangrui.service.ConsumerUserService;
import com.zhangrui.service.ProviderUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author zhangrui
 * @create 2022-08-19 17:25
 */
//从provider查询传入的user是否存在，若不存在则返回一个新user
@Service
public class ConsumerUserServiceImpl implements ConsumerUserService {
    @DubboReference  //引用远程服务提供者
    ProviderUserService providerUserService;
    @Override
    public User creatUser(User user) {
        if (providerUserService.selectUser(user)){
            System.out.println(user + "用户已存在，且已返回老用户");
            return user;
        }
        System.out.println(user + "为新用户，且已自动创建");
        return new User(user.getName(), user.getPhoneNum());
    }

}
