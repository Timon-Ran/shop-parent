package com.hyxs.member.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName:UserLoginDto
 * Package:com.hyxs.member.dto.req
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/11 23:04
 * @author:407897323@qq.com
 */
@Data
public class UserLoginDto {

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "mobile", required = true)
    private String mobile;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "passWord", required = true)
    private String passWord;
}
