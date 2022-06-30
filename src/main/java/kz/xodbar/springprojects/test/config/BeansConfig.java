package kz.xodbar.springprojects.test.config;

import kz.xodbar.springprojects.test.entities.FirstBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }

}
