package com.example.demo.huyue.dubbo.spi;

import com.example.demo.huyue.dubbo.spi.loader.MyExtensionLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.provider.ConfigFile;

import java.util.ServiceLoader;

/**
 * @author huyue01@sinovatech.com 2020/1/5 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiServiceTest {

    @Test
    public void test1() {
        ServiceLoader<SpiService> loaders = ServiceLoader.load(SpiService.class);
        for (SpiService spiService:loaders){
            spiService.test();
        }
    }

    @Test
    public void test2(){
        //获取默认实现类
        SpiService one = MyExtensionLoader.
                getExtensionLoader(SpiService.class).
                getDefaultExtension();
        one.test();

        //指定特定的实现类,例如配置的tobyLog
        SpiService two = MyExtensionLoader.
                getExtensionLoader(SpiService.class).
                getExtension("two");
        two.test();
    }
}
