package org.example.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheDemo {

    public static void main(String[] args) {
        Cache<String,String> cache= CacheBuilder.newBuilder()
                ////设置cache的初始大小为10，要合理设置该值
                .initialCapacity(10)
                //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
                .concurrencyLevel(5)
                //设置cache中的数据在写入之后的存活时间为10秒
                .expireAfterWrite(10, TimeUnit.SECONDS)
                //开启统计信息开关
                .recordStats()
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        cache.put("key4","value4");
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key6"));
        System.out.println(cache.stats());
    }
}
