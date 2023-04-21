/**
 * Author:   Lynn
 * Date:     2023/4/20 0:59
 */
package com.alibaba.dubbo.demo.consumer.annotation;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.demo.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author Lynn
 * @create 2023/4/20
 */
@Component("demoServiceComponent")
public class DemoServiceComponent implements DemoService {

    @Reference
    private DemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}