package com.maishale.controller;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.LogisticsTraceSearchRequest;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kplu on 11/21/14.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String doGet(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        return "index.jsp";
    }


}
