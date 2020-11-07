package com.zsw.demo.mapper;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsw.demo.entity.Vehicle;

/**
 * 车辆信息表 Mapper 接口
 *
 * @author zhangshiwei
 * @since 2020-10-22
 */
@Component
public interface VehicleMapper extends BaseMapper<Vehicle> {

}
