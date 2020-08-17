package com.hyxs.member.impl;

import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.bean.MyBeanUtils;
import com.hyxs.entitydo.UserDo;
import com.hyxs.mapper.UserMapper;
import com.hyxs.member.api.MemberInfoService;
import com.hyxs.member.dto.req.UserLoginDto;
import com.hyxs.member.dto.req.UserRespDto;
import com.hyxs.utils.DesensitizationUtil;
import com.hyxs.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static com.hyxs.bean.MyBeanUtils.doToDto;

/**
 * ClassName:MemberInfoServiceImpl
 * Package:com.hyxs.member.impl
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/12 0:58
 * @author:407897323@qq.com
 */
@RestController
public class MemberInfoServiceImpl extends BaseApiService implements MemberInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BaseResponse<UserLoginDto> getTokenUser(String token) {

        if (StringUtils.isEmpty(token)) {
            return setResultError("token过期");
        }
        String userId = redisUtil.getString(token);
        if (StringUtils.isEmpty(userId)) {
            return setResultError("token错误");
        }
        Integer l = Integer.valueOf(userId);
        UserDo user = userMapper.findByUser(l);
        UserRespDto userRespDto = doToDto(user, UserRespDto.class);
        userRespDto.setMobile(DesensitizationUtil.mobileEncrypt(userRespDto.getMobile()));
        return setResultSuccess(userRespDto);
    }

    @Override
    public BaseResponse<Object> updateUserOpenId(Integer userId, String openId) {
        int reuslt = userMapper.updateUseOpenId(userId, openId);
        return setResultDb(reuslt, "关联成功", "关联失败");
    }

    @Override
    public BaseResponse<UserRespDto> selectByOpenId(String openId) {
        UserDo userDo = userMapper.selectByOpenId(openId);
        if (userDo == null) {
            return setResultError("根据openId查询该用户没有关注过");
        }
        // 需要将do转换成dto
        UserRespDto userRespDto = doToDto(userDo, UserRespDto.class);
        String mobile = userRespDto.getMobile();
        userRespDto.setMobile(DesensitizationUtil.mobileEncrypt(mobile));
        return setResultSuccess(userRespDto);
    }

    @Override
    public BaseResponse<Object> cancelFollowOpenId(String openId) {
        if (StringUtils.isEmpty(openId)) {
            return setResultError("openId不能为空");
        }
        UserDo userDo = userMapper.selectByOpenId(openId);
        if (userDo == null) {
            return setResultError("根据openId查询该用户没有关注过");
        }
        // 已经关注过，则将对应的用户的openid 变为空
        int result = userMapper.cancelFollowOpenId(openId);
        return setResultDb(result, "取消关注成功", "取消关注成功失败!");
    }
}
