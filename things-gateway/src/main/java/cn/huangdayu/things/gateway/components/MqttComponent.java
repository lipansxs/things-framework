package cn.huangdayu.things.gateway.components;

import cn.huangdayu.things.engine.annotation.ThingsBean;
import cn.huangdayu.things.engine.message.JsonThingsMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.component.ComponentsBuilderFactory;

/**
 * @author huangdayu
 */
@ThingsBean
@RequiredArgsConstructor
public class MqttComponent extends AbstractComponent<ComponentProperties> {

    private final CamelContext camelContext;
    private Component component;

    @SneakyThrows
    @Override
    void start(ComponentProperties property) {

        ComponentsBuilderFactory.pahoMqtt5()
                .brokerUrl(property.getServer())
                .userName(property.getUserName())
                .password(property.getPassword())
                .clientId(property.getClientId())
                .automaticReconnect(true)
                .qos(2)
                .keepAliveInterval(60)
                .register(camelContext, property.getName());

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from(property.getName() + ":" + property.getTopic())
                        .to(TARGET_ROUTER);
            }
        });

        component = camelContext.getComponent(property.getName());
        component.start();
    }

    @Override
    void stop() {
        component.stop();
    }

    @Override
    void output(JsonThingsMessage jsonThingsMessage) {

    }

}
