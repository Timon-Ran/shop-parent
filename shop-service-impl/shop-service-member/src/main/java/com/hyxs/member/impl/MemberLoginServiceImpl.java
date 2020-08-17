package com.hyxs.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.entitydo.UserDo;
import com.hyxs.manager.AsyncLoginLogManager;
import com.hyxs.mapper.UserLoginLogMapper;
import com.hyxs.mapper.UserMapper;
import com.hyxs.member.api.MemberLoginService;
import com.hyxs.member.dto.req.UserLoginDto;
import com.hyxs.utils.ChannelUtils;
import com.hyxs.utils.MD5Util;
import com.hyxs.utils.TokenUtils;
import com.hyxs.wechat.WeChatLoginTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ClassName:MemberLoginService
 * Package:com.hyxs.member.impl
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/11 23:06
 * @author:407897323@qq.com
 */
@RestController
public class MemberLoginServiceImpl extends BaseApiService implements MemberLoginService {

    @Autowired
    private ChannelUtils channelUtils;

    @Autowired
    private AsyncLoginLogManager asyncLoginLogManager;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public BaseResponse<JSONObject> login(UserLoginDto userLoginDto, String userToken, String sourceIp,
                                          String channel, String equipment) {
        String mobile = userLoginDto.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号不能为空");
        }
        String passWord = userLoginDto.getPassWord();
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("密码不能为空");
        }
        String md5Psw = MD5Util.MD5(passWord + mobile);
        UserDo userDo = userMapper.login(mobile, md5Psw);
        if (userDo == null) {
            return setResultError("用户名或密码错误");
        }
        if (!channelUtils.existChannel(channel)) {
            return setResultError("非法平台登录");
        }
        int userId = userDo.getUserId();
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotEmpty(userToken) && userLoginLogMapper.channelExist(channel, userId) != 0) {
            if (tokenUtils.getTokenValue(userToken) != null) {
                asyncLoginLogManager.loginLog(mobile,userDo.getWxOpenId(),userId, sourceIp, new Date(), userToken, channel, equipment);
                jsonObject.put("token", userToken);
                return setResultSuccess(jsonObject);
            }
        }
        userToken = tokenUtils.createToken(channel, userId + "");
        asyncLoginLogManager.loginLog(mobile,userDo.getWxOpenId(),userId, sourceIp, new Date(), userToken, channel, equipment);
        jsonObject.put("token", userToken);
        return setResultSuccess(jsonObject);
    }
}
