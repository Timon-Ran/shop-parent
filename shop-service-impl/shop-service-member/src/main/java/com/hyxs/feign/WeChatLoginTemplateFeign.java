package com.hyxs.feign;

import com.hyxs.wechat.WeChatLoginTemplate;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:WeChatLoginTemplateFeign
 * Package:com.hyxs.feign
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/16 22:09
 * @author:407897323@qq.com
 */
@FeignClient("hyxs-weixin")
public interface WeChatLoginTemplateFeign extends WeChatLoginTemplate {
}
