package com.zsw.demo.redis;

import com.zsw.demo.entity.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * redis 控制类
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    /**
     * redis中存储的默认过期时间60s
     */
    private static int REDIS_DEFAULT_EXPIRE_TIME_SIXTY_SECOND = 60;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    @Resource
    private RedisService redisService;

    @RequestMapping("/set")
    public boolean redisSet(String key, String value) {
        boolean result = redisService.set(key, value);
        System.out.println("RedisController redisSet : K - " + key + ", V - " + value + ", result : " + result);
        return result;
    }

    @RequestMapping("/redisSetVehicle")
    public boolean redisSetVehicle(String key, String value) {
        Vehicle vehicle = new Vehicle();
        String vehicleCode = DATE_FORMAT.format(new Date());
        vehicle.setVehicleCode("V" + vehicleCode);
        boolean result = redisService.set(key, vehicle, REDIS_DEFAULT_EXPIRE_TIME_SIXTY_SECOND);
        System.out.println("RedisController redisSetVehicle : K - " + key + ", V - " + value + ", result : " + result);
        return result;
    }

    @RequestMapping("/get")
    public Object redisGet(String key) {
        Object result = redisService.get(key);
        System.out.println("RedisController redisGet : K - " + key + ", result : " + result);
        return result;
    }

    @RequestMapping("/expire")
    public boolean expire(String key) {
        boolean result = redisService.expire(key, REDIS_DEFAULT_EXPIRE_TIME_SIXTY_SECOND);
        System.out.println("RedisController expire : K - " + key + ", result : " + result);
        return result;
    }
}