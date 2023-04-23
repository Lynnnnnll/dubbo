package com.alibaba.dubbo.demo.provider.annotation;

import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.demo.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Lynn
 * @create 2023/4/20
 */
public class Application {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        System.setProperty("dubbo.registry.address","multicast://224.5.6.7:1234");
        context.start();
//        DemoService demoService = context.getBean("demoService", DemoService.class);
//        System.out.println(demoService.sayHello("lynn"));
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.alibaba.dubbo.demo.provider.annotation") // <1>
    @PropertySource("classpath:/spring/dubbo-provider.properties") // <2>
    static class ProviderConfiguration {

        @Bean // <3>
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

    }
}