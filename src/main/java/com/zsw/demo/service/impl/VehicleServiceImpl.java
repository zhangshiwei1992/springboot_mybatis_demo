package com.zsw.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.demo.entity.Vehicle;
import com.zsw.demo.mapper.VehicleMapper;
import com.zsw.demo.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

/**
 * 汽车库存基本信息表 服务实现类
 *
 * @author zhangshiwei
 * @since 2020-10-22
 */
@Slf4j
@Transactional
@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle> implements VehicleService {

}
