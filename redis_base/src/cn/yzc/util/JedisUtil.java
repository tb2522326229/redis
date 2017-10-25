package cn.yzc.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	// 定义一个连接池对象
	private final static JedisPool POOL;

	// 初始化操作
	static {
		// 1、设置连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置池中最大连接数（可选）
		config.setMaxTotal(50);
		// 设置空闲时池中存在的最大连接数（可选）
		config.setMaxIdle(10);
		// 2、设置连接池对象
		POOL = new JedisPool(config, "192.168.218.129", 6379);
	}

	// 从池中获取链接
	public static Jedis getJedis() {
		return POOL.getResource();
	}
}
