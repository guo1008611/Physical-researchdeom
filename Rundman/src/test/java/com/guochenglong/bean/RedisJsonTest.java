/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: RedisJsonTest.java 
 * @Prject: redis_chj
 * @Package: com.chj.redis_chj.test 
 * @Description: TODO
 * @author: chj   
 * @date: 2019年8月10日 上午8:17:21 
 * @version: V1.0   
 */
package com.guochenglong.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guochenglong.utils.RandomUitl;
import com.guochenglong.utils.StringUtil;


/**
 * @ClassName: RedisJsonTest
 * @Description: TODO
 * @author: chj
 * @date: 2019年8月10日 上午8:17:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans2.xml")
public class RedisJsonTest {

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;

	@Test
	public void test_insert() {
		List<Bean> employees = new ArrayList<Bean>();
		// 随机生成1万个数据ddd
		for (int i = 1; i < 100000; i++) {
			employees.add(new Bean(i, StringUtil.generateChineseName() + StringUtil.randomChineseString(2),
					"13" + RandomUitl.randomString(9), StringUtil.randomChineseString(10)));
		}

		long startTimes = System.currentTimeMillis();
		for (Bean employee : employees) {
			redisTemplate.opsForValue().set("u_" + employee.getId(), employee);
		}
		long endTimes = System.currentTimeMillis();

		System.out.println("采用json序列化存储的时间：" + (endTimes - startTimes));

	}

}
