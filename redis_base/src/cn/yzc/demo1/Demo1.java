package cn.yzc.demo1;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Demo1 {

	@Test
	public void run1(){
		Jedis jedis = new Jedis("192.168.218.129", 6379);
	//	jedis.set("name", "李四");
		System.out.println(jedis.get("name"));
	}
}
