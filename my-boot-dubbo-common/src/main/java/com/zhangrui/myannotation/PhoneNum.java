package com.zhangrui.myannotation;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.Length;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/**
 * @author zhangrui
 * @create 2022-08-19 11:10
 */

@ConstraintComposition(CompositionType.AND)
//@NotBlank(message = "电话号码不能为空")
//@Length(min = 11, max = 11, message = "手机号码必须为11位！")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumValidator.class)
@Documented
public @interface PhoneNum {
    String message() default "电话号码格式错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
