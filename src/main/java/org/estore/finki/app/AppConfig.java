package org.estore.finki.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.annotation.PostConstruct;

/**
 * Created by dragan on 17.4.17.
 */
@Configuration
public class AppConfig {

    @Autowired
    private TemplateResolver templateResolver;

    @PostConstruct
    public void extension() {
        templateResolver.setTemplateMode("LEGACYHTML5");
    }
}
