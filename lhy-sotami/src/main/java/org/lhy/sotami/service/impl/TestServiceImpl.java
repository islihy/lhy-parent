package org.lhy.sotami.service.impl;

import com.alibaba.fastjson.JSON;
import org.lhy.sotami.primary.bean.PrimaryTest;
import org.lhy.sotami.primary.repository.TestPrimaryRepository;
import org.lhy.sotami.secondary.bean.SecondaryTest;
import org.lhy.sotami.secondary.repository.TestSecondaryRepository;
import org.lhy.sotami.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/19 5:49 PM
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestSecondaryRepository secondaryRepository;

    @Autowired
    private TestPrimaryRepository primaryRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void test() {
        List<SecondaryTest> setestLists = secondaryRepository.findAll();
        List<PrimaryTest> primaryTests = primaryRepository.findAll();
        redisTemplate.opsForList().leftPush("setestLists : ", setestLists);
        stringRedisTemplate.opsForValue().set("primaryTests : ",JSON.toJSON(primaryTests.get(0)).toString());

        System.out.println(setestLists.size());
        System.out.println(primaryTests.size());
    }
}
