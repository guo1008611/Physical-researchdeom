/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: RedisHashTest.java 
 * @Prject: redis_chj
 * @Package: com.chj.redis_chj.test 
 * @Description: TODO
 * @author: chj   
 * @date: 2019年8月10日 上午8:17:32 
 * @version: V1.0   
 */
package com.guochenglong.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guochenglong.utils.RandomUitl;
import com.guochenglong.utils.StringUtil;

/**
 * @ClassName: RedisHashTest
 * @Description: TODO
 * @author: chj
 * @date: 2019年8月10日 上午8:17:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class RedisHashJDKTest {

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;

	@Test
	public void test_insert() {
		Map<String, Bean> employees = new HashMap<>();
		// 随机生成1万个数据
		for (int i = 1; i < 100000; i++) {
			employees.put("e_" + i,
					new Bean(i, StringUtil.generateChineseName() + StringUtil.randomChineseString(2),
							"13" + RandomUitl.randomString(9), StringUtil.randomChineseString(10)));
		}

		long startTimes = System.currentTimeMillis();

		// redisTemplate.opsForHash().put("key","u_" + employee.getId(), employee)
		redisTemplate.opsForHash().putAll("employee_keys", employees);

		long endTimes = System.currentTimeMillis();

		System.out.println("采用Hash,jdk序列化存储的时间：" + (endTimes - startTimes));

	}
}
