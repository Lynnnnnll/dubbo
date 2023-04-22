/**
 * Author:   Lynn
 * Date:     2023/4/20 0:34
 */
package com.alibaba.dubbo.demo.provider.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.demo.DemoService;

/**
 * @author Lynn
 * @create 2023/4/20
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "DemoServiceImpl . sayHello:" + name;
    }
}