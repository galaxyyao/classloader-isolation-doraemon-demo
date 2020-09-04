package org.example.doraemon.demo2.bundle1;

import io.github.qianxingchuan.framework.doraemon.BundleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @Author: yaohao.yh
 * @Date: 2020/9/4 10:02
 */
public class DemoBundleRun implements BundleService {

    private ClassPathXmlApplicationContext applicationContext;

    @Override
    public void doIt() {
        this.applicationContext = new ClassPathXmlApplicationContext("beans.xml") {
            @Override
            public String getApplicationName() {
                return UUID.randomUUID().toString();
            }
        };
    }

    @Override
    public <T> T getBundleBean(Class<T> typeClass) {
        return applicationContext.getBean(typeClass);
    }
}
