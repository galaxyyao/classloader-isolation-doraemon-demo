package org.example.doraemon.demo2.bundle1;

import org.example.doraemon.demo2.facade.Demo2Facade;
import org.springframework.stereotype.Component;

/**
 * @Author: yaohao.yh
 * @Date: 2020/9/4 10:03
 */
@Component
public class DemoServiceBundleImpl implements Demo2Facade {
    @Override
    public void doSomething() {
        System.out.println("do something in bundle1");
    }
}
