package cn.huangdayu.things.gateway.handler;

import cn.huangdayu.things.engine.annotation.ThingsBean;
import cn.huangdayu.things.engine.message.JsonThingsMessage;

/**
 * @author huangdayu
 */
@ThingsBean
public class LoggingThingsMessageHandler implements ThingsMessageHandler{
    @Override
    public void handler(JsonThingsMessage jsonThingsMessage) {

    }
}
