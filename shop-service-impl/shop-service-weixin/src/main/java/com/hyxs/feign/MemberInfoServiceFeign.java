package com.hyxs.feign;

import com.hyxs.member.api.MemberInfoService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:MemberInfoServiceFeign
 * Package:com.hyxs.feign
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/16 11:11
 * @author:407897323@qq.com
 */
@FeignClient("hyxs-member-info")
public interface MemberInfoServiceFeign extends MemberInfoService {
}
