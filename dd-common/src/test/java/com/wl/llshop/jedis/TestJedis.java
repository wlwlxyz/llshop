package com.wl.llshop.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 19:51
 * Version:V1.0
 */
public class TestJedis {
    @Test
    public void testJedis1(){
        Jedis jedis = new Jedis("101.132.179.155",6379);
        jedis.set("key","value");
        System.out.println(jedis.get("key"));
        jedis.close();
    }

    @Test
    public void testJedis2(){
        JedisPool jedisPool=new JedisPool("101.132.179.155",6379);
        Jedis resource = jedisPool.getResource();
        resource.set("key","value");
        System.out.println(resource.get("key"));
        resource.close();
        jedisPool.close();

    }

    @Test
    public void testJedis3(){
        Set<HostAndPort> nodes=new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("101.132.179.155",8001));
        nodes.add(new HostAndPort("101.132.179.155",8002));
        nodes.add(new HostAndPort("101.132.179.155",8003));
        nodes.add(new HostAndPort("101.132.179.155",8004));
        nodes.add(new HostAndPort("101.132.179.155",8005));
        nodes.add(new HostAndPort("101.132.179.155",8006));
        //创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //存入数据
        jedisCluster.set("name","value2");
        jedisCluster.hset("content1","123","{'name':'wl'}");
        System.out.println(jedisCluster.get("name"));
        //关闭连接
        jedisCluster.close();

    }

}
