package com.maishale.service;

import com.taobao.api.ApiException;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import com.taobao.api.response.TradeGetResponse;

/**
 * Created by kplu on 11/24/14.
 */
public interface TaobaoService {

    public TradeGetResponse getTradeInfo(String tradeId, String sessionKey) throws Exception;

    public LogisticsTraceSearchResponse getLogisticsInfo(String tradeId, String sessionKey) throws Exception;

}
