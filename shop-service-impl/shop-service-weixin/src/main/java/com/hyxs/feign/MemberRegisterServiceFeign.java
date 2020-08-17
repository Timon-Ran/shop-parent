package com.hyxs.feign;

import com.hyxs.member.api.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:MemberRegisterServiceFeign
 * Package:com.hyxs.feign
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/11 19:49
 * @author:407897323@qq.com
 */
@FeignClient("hyxs-member-register")
public interface MemberRegisterServiceFeign extends MemberRegisterService {
}
