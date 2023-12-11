package com.kuoyio.component.webmvc;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;

/**
 * @author xyz
 * @since 1.0
 */

public class KuoyioWebServerCustomizer implements WebServerFactoryCustomizer<AbstractServletWebServerFactory> {
    @Override
    public void customize(AbstractServletWebServerFactory factory) {
    }
}
