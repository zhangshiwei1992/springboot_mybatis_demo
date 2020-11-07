package com.zsw.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.zsw.demo.entity.Vehicle;
import com.zsw.demo.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDruidApplicationTests {

    @Autowired
    private VehicleService vehicleService;

    @Test
    void selectListTest() {
        List<Vehicle> vehicleList = vehicleService.list(null);
        System.out.println("vehicleList: " + JSON.toJSON(vehicleList));
    }

}
