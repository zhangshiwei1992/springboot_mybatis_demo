package com.zsw.demo;

import com.zsw.demo.entity.Vehicle;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

public class DemoTest {

    @Test
    public void substringTest() {
        String dateTimeString = "2021-01-13 10:44:12";
        System.out.println("date: |" + dateTimeString.substring(0, 10) + "|");
        System.out.println("time: |" + dateTimeString.substring(11) + "|");
    }

    @Test
    public void dateToStringTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        System.out.println("date: " + date);
        System.out.println("time: " + new SimpleDateFormat("HH:mm").format(new Date()));
    }

    @Test
    public void mergeTest2() {
        Map<String, Integer> countMap3 = new HashMap<>();
        if (countMap3.containsKey("张飞")) {
            countMap3.put("张飞", countMap3.get("张飞") + 1);
        } else {
            countMap3.put("张飞", 1);
        }

        Map<String, BigDecimal> countMap = new HashMap<>();
        countMap.merge("houyi", new BigDecimal(10), BigDecimal::add);

        Map<String, Long> countMap2 = new HashMap<>();
        countMap2.merge("houyi", 5L, Long::sum);

        countMap3.merge("houyi", 1, Integer::sum);
    }

    @Test
    public void mergeTest() {
        Map<String, Integer> feeCountMap = new HashMap<>();
        feeCountMap.merge("houyi", 1, Integer::sum);
        feeCountMap.merge("houyi", 1, Integer::sum);
        feeCountMap.merge("亚瑟", 1, Integer::sum);
        feeCountMap.merge("亚瑟", 1, Integer::sum);
        feeCountMap.merge("亚瑟", 1, Integer::sum);
        for (String key : feeCountMap.keySet()) {
            System.out.println("key: " + key + " , value: " + feeCountMap.get(key));
        }
    }

    @Test
    public void timeTest() throws ParseException {
        String dateTime = "2021-01-14 14:55:44.428";
        Calendar orderDate = DateUtil.fromStringToCalendar(dateTime, DateUtil.YYYY_MM_DD_HH_mm_ss);
        String date1 = DateUtil.fromCalendarToString(orderDate, DateUtil.YYYY_MM_DD_HH_mm_ss);
        System.out.println("date1: " + date1);

        String date2 = DateUtil.formatDate(dateTime);
    }

    @Test
    public void mapTest() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleCode("V0001");
        vehicle1.setOrganName("合肥");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleCode("V0002");
        vehicle2.setOrganName("淮南");
        List<Vehicle> vehicleList = Lists.newArrayList(vehicle1, vehicle2);
        Map<String, String> vehicleCodeNameMap =
            vehicleList.stream().collect(Collectors.toMap(Vehicle::getOrganName, Vehicle::getVehicleCode));
        for (String key : vehicleCodeNameMap.keySet()) {
            System.out.println("key: " + key + " , value: " + vehicleCodeNameMap.get(key));
        }
    }

}
