package com.thoughtworks.fam;

import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.thoughtworks.fam.exception.GlobalExceptionHandler;

public class TestUtils
{
    public static WebMvcConfigurationSupport prepareExceptionHandlerConfig()
    {
        final StaticApplicationContext applicationContext =
                new StaticApplicationContext();
        applicationContext.registerSingleton("exceptionHandler",
                GlobalExceptionHandler.class);

        final WebMvcConfigurationSupport webMvcConfigurationSupport =
                new WebMvcConfigurationSupport();
        webMvcConfigurationSupport.setApplicationContext(applicationContext);

        return webMvcConfigurationSupport;
    }
}
