package com.hyxs.member.dto.req;

import lombok.Data;

import java.util.Date;

/**
 * ClassName:UserRespDto
 * Package:com.hyxs.member.dto.req
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/12 1:09
 * @author:407897323@qq.com
 */
@Data
public class UserRespDto {
    /**
     * userid
     */

    private Integer userId;
    /**
     * 手机号码
     */

    private String mobile;
    /**
     * 邮箱
     */

    private String email;
    /**
     * 用户名称
     */

    private String userName;
    /**
     * 性别 0 男 1女
     */

    private char sex;
    /**
     * 年龄
     */

    private Long age;
    /**
     * 账号是否可以用 1 正常 0冻结
     */

    private char isAvalible;
    /**
     * 用户头像
     */

    private String picImg;

}
