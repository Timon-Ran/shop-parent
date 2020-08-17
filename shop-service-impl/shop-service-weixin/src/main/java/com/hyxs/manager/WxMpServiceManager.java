package com.hyxs.manager;

import com.hyxs.base.BaseResponse;
import com.hyxs.constant.HttpConstant;
import com.hyxs.feign.MemberInfoServiceFeign;
import com.hyxs.member.dto.req.UserRespDto;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName:WxMpServiceManager
 * Package:com.hyxs.manager
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/16 8:33
 * @author:407897323@qq.com
 */
@Component
public class WxMpServiceManager {

    @Autowired
    private MemberInfoServiceFeign memberInfoServiceFeign;

    public WxMpXmlOutMessage handle(Integer userId,String openId){

        BaseResponse<UserRespDto> userRespDtoBaseResponse =memberInfoServiceFeign.selectByOpenId(openId);
        if (userRespDtoBaseResponse.getCode().equals(HttpConstant.RPC_RESULT_SUCCESS)){
            return null;
        }
        memberInfoServiceFeign.updateUserOpenId(userId,openId);
        return null;
    }
}
