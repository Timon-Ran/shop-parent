package com.hyxs.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.bean.MyBeanUtils;
import com.hyxs.entitydo.UserDo;
import com.hyxs.mapper.UserMapper;
import com.hyxs.member.api.MemberRegisterService;
import com.hyxs.member.dto.req.UserResRegisterDto;
import com.hyxs.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:MemberRegisterServiceImpl
 * Package:com.hyxs.member.impl
 *
 * @author：冉茂旭
 * @date:2020/8/11 16:47
 * @author:407897323@qq.com
 */
@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<JSONObject> register(UserResRegisterDto userResRegisterDto) {

        String mobile = userResRegisterDto.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号不能为空");
        }
        String passWord = userResRegisterDto.getPassWord();
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("密码不能为空");
        }
        UserDo userDbDo = userMapper.existMobile(mobile);
        if (userDbDo != null) {
            return setResultError("手机号码已存在");
        }
        String md5Psw = MD5Util.MD5(passWord + mobile);
        UserDo userDo = MyBeanUtils.dtoToDo(userResRegisterDto, UserDo.class);
        userDo.setPassWord(md5Psw);
        int register = userMapper.register(userDo);
        return setResultDb(register, "注册成功", "注册失败");
    }
}
