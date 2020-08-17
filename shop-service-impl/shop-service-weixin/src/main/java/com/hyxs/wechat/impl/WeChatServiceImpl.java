package com.hyxs.wechat.impl;

import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.wechat.WeChatService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:WeChatServiceImpl
 * Package:com.hyxs.wechat
 * @author：冉茂旭 Description:
 * @date:2020/8/8 20:54
 * @author:407897323@qq.com
 */

@RestController
public class WeChatServiceImpl extends BaseApiService implements WeChatService {


    @Override
    public String getAppInfo(Integer userId) {

        return "微信服务接口userid："+userId;
    }

    @Override
    public BaseResponse<String> addApp(String userId, String password) {
        if (StringUtils.isEmpty(userId)){
            return setResultError("id不能为空");
        }
        if (StringUtils.isEmpty(password)){
            return setResultError("密码不能为空");
        }
        return setResultSuccess("success");
    }
}
