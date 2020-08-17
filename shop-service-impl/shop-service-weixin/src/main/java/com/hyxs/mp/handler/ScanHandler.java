package com.hyxs.mp.handler;


import com.hyxs.manager.WxMpServiceManager;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class ScanHandler extends AbstractHandler {

    @Autowired
    private WxMpServiceManager wxMpServiceManager;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                    WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {



        String eventKey = wxMpXmlMessage.getEventKey();
        if (!StringUtils.isEmpty(eventKey)){
            String openId = wxMpXmlMessage.getFromUser();
            Integer userId = Integer.valueOf(eventKey);
            wxMpServiceManager.handle(userId,openId);
        }

        return null;
    }
}
