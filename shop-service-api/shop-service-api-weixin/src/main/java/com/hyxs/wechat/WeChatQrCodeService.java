package com.hyxs.wechat;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:WeChatQrCodeService
 * Package:com.hyxs.wechat
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/15 11:15
 * @author:407897323@qq.com
 */

@Api
public interface WeChatQrCodeService {

    @GetMapping("getQrUrl")
    BaseResponse<JSONObject> getQrUrl(@RequestParam("userId") Long userId);
}
