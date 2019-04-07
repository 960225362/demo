package com.example.demo.huyue.jdk;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author huyue01@sinovatech.com 2019/3/31 17:57
 */
public class MyinterfaceImpl implements Myinterface {
    @Override
    public void rest() {

    }

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ScriptException {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        LocalDate date = LocalDate.now();
        LocalDate localDate = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(localDate);

        LocalTime time = LocalTime.now();
        LocalTime localTime = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(localTime);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        System.out.println(scriptEngine.getClass().getName());
        System.out.println("Result:" + scriptEngine.eval("function f() { return 1; }; f() + 1;"));

        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.toString());

        List<String> list1 = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(list1, (String o1, String o2) -> o2.compareTo(o1));
        System.out.println(list1.toString());

        Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("123");
        System.out.println(convert);

        Supplier<MyinterfaceImpl> supplier = MyinterfaceImpl::new;
        System.out.println(supplier.get());

        long count = list.stream().filter(l -> "anna".equalsIgnoreCase(l)).count();
        System.out.println(count);

        Integer[] nums = {3, 6, 98, 4, 6, 7};
        int max = Stream.of(nums).max(Comparator.comparing(s -> s)).get();
        int min = Stream.of(nums).min(Integer::compareTo).get();
        System.out.println("最大值：" + max + "||最小值：" + min);



    }
}
