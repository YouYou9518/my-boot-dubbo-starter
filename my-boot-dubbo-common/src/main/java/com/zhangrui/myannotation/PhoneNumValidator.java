package com.zhangrui.myannotation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


/**
 * @author zhangrui
 * @create 2022-08-19 14:19
 */
public class PhoneNumValidator implements ConstraintValidator<PhoneNum, String> {
    //验证手机号码
    private static final Pattern PATTERN = Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.hasLength(value)) {
            return PATTERN.matcher(value).matches();
        }
        return false;
    }

    /*@Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "/^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$/";
        boolean flag = s.matches(regex);
        return flag;
    }*/
}
