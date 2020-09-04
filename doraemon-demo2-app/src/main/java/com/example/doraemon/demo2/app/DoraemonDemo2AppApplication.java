package com.example.doraemon.demo2.app;

import io.github.qianxingchuan.framework.doraemon.bundle.AsgardClassLoader;
import io.github.qianxingchuan.framework.doraemon.main.RunDoraemonBundle;
import org.example.doraemon.demo2.facade.Demo2Facade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoraemonDemo2AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoraemonDemo2AppApplication.class, args);

		String bundle1Path = DoraemonDemo2AppApplication.class.getResource("/doraemon-demo2-bundle1-1.0.0-SNAPSHOT-release.zip").getPath();
		System.out.println("bundle1 path is " + bundle1Path);
		RunDoraemonBundle[] runDoraemonBundles = new RunDoraemonBundle[1];
		RunDoraemonBundle runDoraemonBundle = new RunDoraemonBundle(bundle1Path, null);
		runDoraemonBundle.run();
		runDoraemonBundles[0] = runDoraemonBundle;


		AsgardClassLoader bundle1ClassLoader = runDoraemonBundle.getBundle().getBundleClassLoader();
		ClassLoader defaultClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(defaultClassLoader);
		System.out.println(bundle1ClassLoader);

		Thread.currentThread().setContextClassLoader(bundle1ClassLoader);
		runDoraemonBundles[0].getBundleBean(Demo2Facade.class).doSomething();
	}

}
