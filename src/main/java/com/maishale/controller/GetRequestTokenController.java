package com.maishale.controller;

import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kplu on 11/24/14.
 */
@Controller
public class GetRequestTokenController {


    @RequestMapping(value="/getRequestToken", method = RequestMethod.GET)
    public String doGet(){
        return "request_token.jsp";
    }
}
