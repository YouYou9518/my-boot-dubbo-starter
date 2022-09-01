package com.zhangrui.pojo;

import com.zhangrui.myannotation.PhoneNum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zhangrui
 * @create 2022-08-19 16:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @NotNull(message = "名字不能为空！")
    private String name;

    @PhoneNum
    private String phoneNum;

}
