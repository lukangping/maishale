package com.maishale.controller;

import com.maishale.common.TaobaoConstant;
import com.taobao.api.internal.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kplu on 11/24/14.
 */
@Controller
public class GetAccessTokenController {

    @RequestMapping(value="/getAccessToken", method = RequestMethod.GET)
    public String doGet(ModelMap model, HttpServletRequest request,
                        HttpServletResponse response, String code) throws IOException {

        String url= TaobaoConstant.TAOBAO_ACCESS_TOKEN_URL;
        Map<String,String> props=new HashMap<String,String>();
        props.put("grant_type","authorization_code");
        props.put("code",code);
        props.put("client_id", TaobaoConstant.TAOBAO_APPKEY);
        props.put("client_secret", TaobaoConstant.TAOBAO_APPSECRET);
        props.put("redirect_uri", "http://www.test.com");
        props.put("view","web");


        String result = WebUtils.doPost(url, props, 30000, 30000);

        return "access_token.jsp";
    }

}
