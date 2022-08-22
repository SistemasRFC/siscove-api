package siscove.siscovejava.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@RequiredArgsConstructor
@Component
public class ConfigInterceptor extends WebMvcConfigurerAdapter {

    private final InterceptorConfig inperceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(inperceptor);
    }

}