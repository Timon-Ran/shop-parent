package com.hyxs.member.api;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseResponse;
import com.hyxs.member.dto.req.UserResRegisterDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:MemberRegisterService
 * Package:com.hyxs.member.api
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/11 17:16
 * @author:407897323@qq.com
 */
@Api(tags = "会员注册服务")
public interface MemberRegisterService {

    @PostMapping("register")
    BaseResponse<JSONObject> register(@RequestBody UserResRegisterDto userResRegisterDto);
}
