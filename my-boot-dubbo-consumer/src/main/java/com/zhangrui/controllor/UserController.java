package com.zhangrui.controllor;

import com.zhangrui.pojo.User;
import com.zhangrui.service.ConsumerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author zhangrui
 * @create 2022-08-19 17:32
 */

@Controller
@Validated
public class UserController {
//    @DubboReference 远程调用，此处controller和ConsumerUserServiceImpl在同一个模块
    @Autowired
    ConsumerUserService consumerUserService;

    @ResponseBody
    @PostMapping(value = "/creatUser")
    public String creatUser(@Valid @RequestBody User user, BindingResult bindingResult) {
//        if (StringUtils.isBlank(user.getPhoneNum())) {
//            return "电话号码不能为空";
//        }
        if (bindingResult.hasErrors()) {
            // 获取验证失败的信息,可在验证注解的message()中设置
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return consumerUserService.creatUser(user).toString();
    }

}
