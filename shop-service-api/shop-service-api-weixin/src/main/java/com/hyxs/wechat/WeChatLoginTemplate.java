package com.hyxs.wechat;

import com.hyxs.base.BaseResponse;
import com.hyxs.entity.request.LoginTemplateDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "微信模版消息推送")
public interface WeChatLoginTemplate {

    /**
     *
     * @param loginTemplateDto
     * @return
     */
    @PostMapping("/sendLoginTemplate")
    BaseResponse<Object> sendLoginTemplate(@RequestBody LoginTemplateDto loginTemplateDto);
}