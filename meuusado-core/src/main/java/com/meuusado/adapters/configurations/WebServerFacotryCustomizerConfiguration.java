package com.meuusado.adapters.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.util.SocketUtils;

/*
 * Alternative way to provide random ports to spring applications.
 * It's is just an backup code, non functional.
 */
public class WebServerFacotryCustomizerConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Value("${port.number.min:9100}")
    private Integer minPort;

    @Value("${port.number.max:9199}")
    private Integer maxPort;

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        int port = SocketUtils.findAvailableTcpPort(minPort, maxPort);
        factory.setPort(port);
        System.getProperties().put("server.port", port);
    }
}