package org.lhy.sb.shiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhy.sb.SbApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/1 下午12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbApplication.class)
public class PipelineTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testPipeLine(){
        redisTemplate.opsForList().leftPush("l","");
        redisTemplate.opsForValue().set("a",1);
        redisTemplate.opsForValue().set("b",2);
        redisTemplate.executePipelined((RedisCallback<Object>) redisConnection -> {
            redisConnection.openPipeline();
            for (int i = 0;i < 10;i++){
                redisConnection.incr("a".getBytes());
            }
            System.out.println("a:"+redisTemplate.opsForValue().get("a"));
            redisTemplate.opsForValue().set("c",3);
            for(int j = 0;j < 20;j++){
                redisConnection.incr("b".getBytes());
            }
            System.out.println("b:"+redisTemplate.opsForValue().get("b"));
            System.out.println("c:"+redisTemplate.opsForValue().get("c"));
            redisConnection.closePipeline();
            return null;
        });
        System.out.println("a:"+redisTemplate.opsForValue().get("a"));
        System.out.println("b:"+redisTemplate.opsForValue().get("b"));
    }
    @Test
    public void testPipeLine2(){
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            redisTemplate.opsForValue().increment("pipline", 1);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                for (int i = 0; i < 10000; i++) {
                    redisTemplate.opsForValue().increment("pipline", 1L);
                }
                return null;
            }
        });
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Nullable
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                stringRedisConnection.openPipeline();
                for (int i = 0;i < 10000;i++){
                    stringRedisConnection.incrBy("pipline",1L);
                }
                stringRedisConnection.closePipeline();
                return null;
            }
        });
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
    }

}
