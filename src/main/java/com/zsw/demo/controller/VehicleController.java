package com.zsw.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsw.demo.entity.Vehicle;
import com.zsw.demo.service.VehicleService;

/**
 * 汽车库存基本信息表 前端控制器
 *
 * @author zhangshiwei
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }

    /**
     * 根据ID获取信息
     */
    @RequestMapping("/getById")
    public Vehicle getById() {
        Vehicle vehicle = vehicleService.getById(1L);
        System.out.println("getById: " + JSON.toJSON(vehicle));
        return vehicle;
    }

    /**
     * 查询全部信息
     */
    @RequestMapping("/list")
    public List<Vehicle> list() {
        List<Vehicle> vehicleList = vehicleService.list(null);
        System.out.println("list: " + JSON.toJSON(vehicleList));
        return vehicleList;
    }

    /**
     * 分页查询全部数据
     */
    @RequestMapping("/page")
    public IPage<Vehicle> page() {
        //需要在Config配置类中配置分页插件
        IPage<Vehicle> page = new Page<>();
        page.setCurrent(5); //当前页
        page.setSize(1); //每页条数
        Wrapper<Vehicle> vehicleWrapper = new Wrapper<Vehicle>() {
            @Override
            public Vehicle getEntity() {
                return null;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getCustomSqlSegment() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        };

        page = vehicleService.page(page, vehicleWrapper);

        System.out.println("page: " + JSON.toJSON(page));
        return page;
    }

    /**
     * 根据指定字段查询信息集合
     */
    @RequestMapping("/getListMap")
    public Collection<Vehicle> getListMap() {
        Map<String, Object> map = new HashMap<>();
        // kay是字段名 value是字段值
        map.put("status", 2);

        Collection<Vehicle> vehicleList = vehicleService.listByMap(map);

        System.out.println("listByMap: " + JSON.toJSON(vehicleList));
        return vehicleList;
    }

    /**
     * 新增信息
     */
    @RequestMapping("/save")
    public String save() {
        Vehicle vehicle = new Vehicle();
        String vehicleCode = dateFormat.format(new Date());
        vehicle.setVehicleCode("V" + vehicleCode);
        boolean result = vehicleService.save(vehicle);
        System.out.println("save: " + result);
        return "save result: " + result;
    }

    /**
     * 批量新增信息
     */
    @RequestMapping("/saveBatch")
    public String saveBatch() {
        //创建对象
        Vehicle vehicle1 = new Vehicle();
        String vehicleCode1 = dateFormat.format(new Date());
        vehicle1.setVehicleCode("V" + vehicleCode1);

        Vehicle vehicle2 = new Vehicle();
        String vehicleCode2 = dateFormat.format(new Date());
        vehicle2.setVehicleCode("V" + vehicleCode2);

        // 批量保存
        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle1);
        list.add(vehicle2);

        boolean result = vehicleService.saveBatch(list);
        System.out.println("saveBatch: " + result);

        return "saveBatch result: " + result;
    }

    /**
     * 更新信息
     */
    @RequestMapping("/updateInfo")
    public String updateInfo() {
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        Vehicle vehicleCondition = new Vehicle();
        vehicleCondition.setId(1L);

        String vehicleCode = dateFormat.format(new Date());
        vehicleCondition.setVehicleCode("V" + vehicleCode);

        boolean result = vehicleService.updateById(vehicleCondition);
        System.out.println("updateById: " + result);

        return "updateById result: " + result;
    }

    /**
     * 新增或者更新信息
     */
    @RequestMapping("/saveOrUpdateInfo")
    public String saveOrUpdate() {
        // 传入的实体类Vehicle中ID为null就会新增(ID自增)
        // 实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        Vehicle vehicleCondition = new Vehicle();
        vehicleCondition.setId(2L);

        String vehicleCode = dateFormat.format(new Date());
        vehicleCondition.setVehicleCode("V" + vehicleCode);

        boolean result = vehicleService.saveOrUpdate(vehicleCondition);
        System.out.println("saveOrUpdate: " + result);

        return "saveOrUpdate result: " + result;
    }

    /**
     * 根据ID删除信息
     */
    @RequestMapping("/removeById")
    public String removeById() {
        boolean result = vehicleService.removeById(3L);
        System.out.println("removeById: " + result);

        return "removeById result: " + result;
    }

    /**
     * 根据ID批量删除信息
     */
    @RequestMapping("/removeByIds")
    public String removeByIds() {
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);

        boolean result = vehicleService.removeByIds(idList);
        System.out.println("removeByIds: " + result);

        return "removeByIds result: " + result;
    }

    /**
     * 根据指定字段删除信息
     */
    @RequestMapping("/removeByMap")
    public String removeByMap() {
        // kay是字段名 value是字段值
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");

        boolean result = vehicleService.removeByMap(map);
        System.out.println("removeByMap: " + result);

        return "removeByMap result: " + result;
    }

}
