package com.hyxs.mp.handler;


import com.hyxs.mp.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {
	/**
	 * 发送验证码消息
	 */
	@Value("${hyxs.weixin.registration.code.message}")
	private String registrationCodeMessage;
	/**
	 * 默认回复消息
	 */
	@Value("${hyxs.weixin.default.registration.code.message}")
	private String defaultRegistrationCodeMessage;

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
									WxSessionManager sessionManager) {

		return new TextBuilder().build(defaultRegistrationCodeMessage, wxMessage, weixinService);
	}

	// 获取注册码
	private int registCode() {
		int registCode = (int) (Math.random() * 9000 + 1000);
		return registCode;
	}

}
