package com.hyxs.wechat;

import com.hyxs.base.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:WeChatService
 * Package:com.hyxs.wechat
 * @author：冉茂旭 Description:
 * @date:2020/8/8 20:51
 * @author:407897323@qq.com
 */
@Api
public interface WeChatService {

    @GetMapping("getAppInfo")
    String getAppInfo(@RequestParam("userId")Integer userId);

    @GetMapping("addApp")
    BaseResponse<String> addApp(@RequestParam("userId")String userId,@RequestParam("password")String password);
}
