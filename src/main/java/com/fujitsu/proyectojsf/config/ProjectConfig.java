package com.fujitsu.proyectojsf.config;

import jakarta.servlet.ServletContext;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Esta clase sirve para que redirija a la página de inicio cuando ponemos la URL base
 * EXAMPLE: http://localhost:8080/
 */

@Configuration
public class ProjectConfig extends HttpConfigurationProvider {

    @Autowired
    @Override
    public org.ocpsoft.rewrite.config.Configuration getConfiguration(final ServletContext t) {
        return ConfigurationBuilder.begin().addRule().when(Direction.isInbound().and(Path.matches("/")))
                .perform(Redirect.temporary("/index.faces"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
