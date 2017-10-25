package cn.yzc.demo1;

import org.junit.Test;

import cn.yzc.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Demo1 {

	@Test
	public void run1(){
		Jedis jedis = new Jedis("192.168.218.129", 6379);
	//	jedis.set("name", "李四");
		System.out.println(jedis.get("name"));
	}
	
	/*
	 * jedis连接池
	 * */
	@Test
	public void run2(){
		//1、设置连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//2、设置连接池对象
		JedisPool pool = new JedisPool(config,"192.168.218.129", 6379);
		//3、从池中获取连接对象
		Jedis jedis = pool.getResource();
		System.out.println(jedis.get("name"));
		//4、连接归还池中
		jedis.close();
	}
	
	@Test
	public void test_util(){
		Jedis jedis = JedisUtil.getJedis();
		System.out.println(jedis.get("name"));
	}
}
