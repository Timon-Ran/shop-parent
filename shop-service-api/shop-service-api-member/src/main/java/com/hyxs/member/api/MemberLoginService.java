package com.hyxs.member.api;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseResponse;
import com.hyxs.member.dto.req.UserLoginDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * ClassName:MemberLoginService
 * Package:com.hyxs.member.api
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/11 21:25
 * @author:407897323@qq.com
 */
@Api(tags = "用户登录接口")
public interface MemberLoginService {

    @PostMapping("login")
    BaseResponse<JSONObject> login(@RequestBody UserLoginDto userLoginDto, @RequestParam(value = "userToken",required = false) String userToken, @RequestHeader("X-Real-IP") String sourceIp,
                                   @RequestHeader String channel, @RequestHeader String equipment);
}
