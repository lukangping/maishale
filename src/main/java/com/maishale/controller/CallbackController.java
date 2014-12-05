package com.maishale.controller;

import com.maishale.common.TaobaoConstant;
import com.maishale.service.TaobaoService;
import com.taobao.api.domain.TransitStepInfo;
import com.taobao.api.internal.util.WebUtils;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kplu on 11/24/14.
 */
@Controller
public class CallbackController {

    @Autowired
    private TaobaoService taobaoService;

    @RequestMapping(value="/taobaoCallback", method = RequestMethod.GET)
    public String doGet(ModelMap model, HttpServletRequest request,
                        HttpServletResponse response, String code) throws Exception {

        String url= TaobaoConstant.TAOBAO_ACCESS_TOKEN_URL;
        Map<String,String> props=new HashMap<String,String>();
        props.put("grant_type","authorization_code");
        props.put("code",code);
        props.put("client_id", TaobaoConstant.TAOBAO_APPKEY);
        props.put("client_secret", TaobaoConstant.TAOBAO_APPSECRET);
        props.put("redirect_uri", "http://maishale.tanghongtech.com/");
        props.put("view","web");

        String result = WebUtils.doPost(url, props, 30000, 30000);

        JSONObject jsonObject = JSONObject.fromObject(result);
        String accessToken = jsonObject.get("access_token").toString();

        LogisticsTraceSearchResponse logisticsInfo = taobaoService.getLogisticsInfo("842745659601275", accessToken);
        String status = logisticsInfo.getStatus();
        List<TransitStepInfo> traceList = logisticsInfo.getTraceList();
        model.addAttribute("status", status);
        model.addAttribute("traceList", traceList);

        return "logistics.jsp";
    }

}
