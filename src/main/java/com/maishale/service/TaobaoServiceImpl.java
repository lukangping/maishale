package com.maishale.service;

import com.maishale.common.TaobaoConstant;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.LogisticsTraceSearchRequest;
import com.taobao.api.request.TradeGetRequest;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import com.taobao.api.response.TradeGetResponse;

/**
 * Created by kplu on 11/24/14.
 */
public class TaobaoServiceImpl implements TaobaoService {

    @Override
    public TradeGetResponse getTradeInfo(String tradeId, String sessionKey) throws Exception {

        TaobaoClient client=new DefaultTaobaoClient(TaobaoConstant.TAOBAO_URL, TaobaoConstant.TAOBAO_APPKEY,
                TaobaoConstant.TAOBAO_APPSECRET);
        TradeGetRequest req=new TradeGetRequest();

        req.setFields("seller_nick");
        req.setTid(Long.valueOf(tradeId));

        return client.execute(req , sessionKey);

    }

    @Override
    public LogisticsTraceSearchResponse getLogisticsInfo(String tradeId, String sessionKey) throws Exception {

        TradeGetResponse trade = this.getTradeInfo(tradeId, sessionKey);
        String sellerNick = trade.getTrade().getSellerNick();

        TaobaoClient client=new DefaultTaobaoClient(TaobaoConstant.TAOBAO_URL, TaobaoConstant.TAOBAO_APPKEY,
                TaobaoConstant.TAOBAO_APPSECRET);
        LogisticsTraceSearchRequest req=new LogisticsTraceSearchRequest();
        req.setTid(Long.valueOf(tradeId));
        req.setSellerNick(sellerNick);

        return client.execute(req);
    }
}
