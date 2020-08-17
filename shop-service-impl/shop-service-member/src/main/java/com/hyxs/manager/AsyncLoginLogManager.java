package com.hyxs.manager;

import com.hyxs.entity.request.LoginTemplateDto;
import com.hyxs.entitydo.UserLoginLogDo;
import com.hyxs.mapper.UserLoginLogMapper;
import com.hyxs.member.dto.req.UserLoginDto;
import com.hyxs.utils.DesensitizationUtil;
import com.hyxs.wechat.WeChatLoginTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName:AsyncLoginLogManager
 * Package:com.hyxs.manager
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/12 3:18
 * @author:407897323@qq.com
 */

@Component
@Slf4j
public class AsyncLoginLogManager {

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    private WeChatLoginTemplate weChatLoginTemplate;

    @Async
    public void loginLog(String mobile,String wxOpenId,int userId, String loginIp, Date loginTime, String loginToken, String channel, String equipment){
        UserLoginLogDo userLoginLogDo = new UserLoginLogDo();
        userLoginLogDo.setUserId(userId);
        userLoginLogDo.setLoginIp(loginIp);
        userLoginLogDo.setChannel(channel);
        userLoginLogDo.setLoginToken(loginToken);
        userLoginLogDo.setEquipment(equipment);
        userLoginLogDo.setLoginTime(loginTime);
        userLoginLogMapper.loginLog(userLoginLogDo);
        if (!StringUtils.isEmpty(wxOpenId)) {
            LoginTemplateDto loginTemplateDto = new LoginTemplateDto(DesensitizationUtil.mobileEncrypt(mobile),
                    loginTime, loginIp, equipment, wxOpenId);
            weChatLoginTemplate.sendLoginTemplate(loginTemplateDto);
        }
    }
}
