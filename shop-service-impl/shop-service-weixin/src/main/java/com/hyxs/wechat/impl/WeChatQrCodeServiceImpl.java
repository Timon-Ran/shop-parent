package com.hyxs.wechat.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyxs.base.BaseApiService;
import com.hyxs.base.BaseResponse;
import com.hyxs.constant.WeiXinConstant;
import com.hyxs.mp.config.WxMpConfiguration;
import com.hyxs.mp.config.WxMpProperties;
import com.hyxs.wechat.WeChatQrCodeService;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * ClassName:WeChatQrCodeService
 * Package:com.hyxs.wechat.impl
 *
 * @author：冉茂旭 Description:
 * @date:2020/8/15 23:28
 * @author:407897323@qq.com
 */
@RestController
class WeChatQrCodeServiceImpl extends BaseApiService<JSONObject> implements WeChatQrCodeService {


    @Autowired
    private WxMpProperties wxMpProperties;
/*    @Value("${hyxs.wx.qrTicket}")
    private String qrTicket;*/

    @Override
    public BaseResponse<JSONObject> getQrUrl(Long userId) {
        if (userId == null) {
            return setResultError("userId不能为空!");
        }
        try {
            String appId = wxMpProperties.getConfigs().get(0).getAppId();
            WxMpQrcodeService qrcodeService = WxMpConfiguration.getMpServices().get(appId).getQrcodeService();
            WxMpQrCodeTicket wxMpQrCodeTicket = qrcodeService.qrCodeCreateTmpTicket(userId + "",
                    WeiXinConstant.QR_CODE_EXPIRE_SECONDS);


            if (wxMpQrCodeTicket == null) {
                return setResultError("生成二维码失败!");
            }
            String ticket = wxMpQrCodeTicket.getTicket();
            return setResultSuccess(ticket,URLEncoder.encode("utf-8"));
/*
            JSONObject resultData = new JSONObject();
            resultData.put("url", qrTicket + ticket);
            return setResultSuccess(resultData);*/
        } catch (Exception e) {
            return setResultError("生成二维码失败!");
        }
        //return null;
    }
}
