/**
 * Author:   Lynn
 * Date:     2023/4/20 0:56
 */
package com.alibaba.dubbo.demo.consumer.annotation;

import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.demo.DemoService;
import org.springframework.context.annotation.*;

/**
 * @author Lynn
 * @create 2023/4/20
 */
public class Application {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        DemoService demoService = context.getBean("demoServiceComponent", DemoServiceComponent.class);
        System.out.println(demoService.sayHello("lynn"));
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.alibaba.dubbo.demo.consumer.annotation") // <1>
    @PropertySource("classpath:/spring/dubbo-consumer.properties") // <2>
    @ComponentScan(value = {"com.alibaba.dubbo.demo.consumer.annotation"})
    static class ConsumerConfiguration {
    }
}