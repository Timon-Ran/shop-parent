package com.hyxs.member.api;

import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.member.dto.req.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:MemberInfoService
 * Package:com.hyxs.member.api
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/12 0:45
 * @author:407897323@qq.com
 */
public interface MemberInfoService {


    @GetMapping("getTokenUser")
    BaseResponse getTokenUser(@RequestParam("token") String token);

    @PostMapping("updateUseOpenId")
    BaseResponse<Object> updateUserOpenId(@RequestParam("userId") Integer userId,
                                         @RequestParam(name = "openId", required = false) String openId);

    @GetMapping("selectByOpenId")
    BaseResponse<UserRespDto> selectByOpenId(@RequestParam("openId") String openId);

    @GetMapping("cancelFollowOpenId")
    BaseResponse<Object> cancelFollowOpenId(@RequestParam("openId") String openId);

}
