package cn.huangdayu.things.engine.chaining.handler;

import cn.huangdayu.things.engine.message.JsonThingsMessage;

/**
 * @author huangdayu
 */
public interface ThingsHandler {

    /**
     * 是否能处理这条消息
     *
     * @param jsonThingsMessage
     * @return
     */
    boolean canHandle(JsonThingsMessage jsonThingsMessage);

    /**
     * 处理消息
     *
     * @param jsonThingsMessage
     * @return
     */
    JsonThingsMessage doHandle(JsonThingsMessage jsonThingsMessage);

}
