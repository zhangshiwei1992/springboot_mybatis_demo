package com.zsw.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 汽车库存基本信息表
 * </p>
 *
 * @author zhangshiwei
 * @since 2020-10-22
 */
@TableName("t_vehicle")
public class Vehicle extends Model<Vehicle> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long              id;

    /**
     * 汽车编号
     */
    @TableField("vehicle_code")
    private String            vehicleCode;

    /**
     * 车辆属性:1-新车,2-二手车
     */
    @TableField("vehicle_property")
    private String            vehicleProperty;

    /**
     * 订单编号
     */
    @TableField("order_code")
    private String            orderCode;

    /**
     * 分公司
     */
    @TableField("corgan_code")
    private String            corganCode;

    /**
     * 分公司名称
     */
    @TableField("organ_name")
    private String            organName;

    /**
     * 品牌id
     */
    @TableField("vehicle_brand_id")
    private Long              vehicleBrandId;

    /**
     * 品牌名称
     */
    @TableField("vehicle_brand_name")
    private String            vehicleBrandName;

    /**
     * 厂商id
     */
    @TableField("vehicle_vendor_id")
    private Long              vehicleVendorId;

    /**
     * 厂商名称
     */
    @TableField("vehicle_vendor_name")
    private String            vehicleVendorName;

    /**
     * 车系id
     */
    @TableField("vehicle_series_id")
    private Long              vehicleSeriesId;

    /**
     * 车系名称
     */
    @TableField("vehicle_series_name")
    private String            vehicleSeriesName;

    /**
     * 车型id
     */
    @TableField("vehicle_type_id")
    private Long              vehicleTypeId;

    /**
     * 车型名称
     */
    @TableField("vehicle_type_name")
    private String            vehicleTypeName;

    /**
     * 颜色
     */
    @TableField("vehicle_color")
    private String            vehicleColor;

    /**
     * 是否删除
     */
    @TableField("is_deleted")
    private String            isDeleted;

    /**
     * 创建者
     */
    private String            creator;

    /**
     * 修改者
     */
    private String            modifier;

    /**
     * 创建时间
     */
    @TableField("gmt_created")
    private Date              gmtCreated;

    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private Date              gmtModified;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", vehicleCode='" + vehicleCode + '\'' + ", vehicleProperty='"
            + vehicleProperty + '\'' + ", orderCode='" + orderCode + '\'' + ", corganCode='" + corganCode + '\''
            + ", organName='" + organName + '\'' + ", vehicleBrandId=" + vehicleBrandId + ", vehicleBrandName='"
            + vehicleBrandName + '\'' + ", vehicleVendorId=" + vehicleVendorId + ", vehicleVendorName='"
            + vehicleVendorName + '\'' + ", vehicleSeriesId=" + vehicleSeriesId + ", vehicleSeriesName='"
            + vehicleSeriesName + '\'' + ", vehicleTypeId=" + vehicleTypeId + ", vehicleTypeName='" + vehicleTypeName
            + '\'' + ", vehicleColor='" + vehicleColor + '\'' + ", isDeleted='" + isDeleted + '\'' + ", creator='"
            + creator + '\'' + ", modifier='" + modifier + '\'' + ", gmtCreated=" + gmtCreated + ", gmtModified="
            + gmtModified + '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public void setVehicleProperty(String vehicleProperty) {
        this.vehicleProperty = vehicleProperty;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setCorganCode(String corganCode) {
        this.corganCode = corganCode;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public void setVehicleBrandId(Long vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public void setVehicleVendorId(Long vehicleVendorId) {
        this.vehicleVendorId = vehicleVendorId;
    }

    public void setVehicleVendorName(String vehicleVendorName) {
        this.vehicleVendorName = vehicleVendorName;
    }

    public void setVehicleSeriesId(Long vehicleSeriesId) {
        this.vehicleSeriesId = vehicleSeriesId;
    }

    public void setVehicleSeriesName(String vehicleSeriesName) {
        this.vehicleSeriesName = vehicleSeriesName;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public String getVehicleProperty() {
        return vehicleProperty;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getCorganCode() {
        return corganCode;
    }

    public String getOrganName() {
        return organName;
    }

    public Long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public Long getVehicleVendorId() {
        return vehicleVendorId;
    }

    public String getVehicleVendorName() {
        return vehicleVendorName;
    }

    public Long getVehicleSeriesId() {
        return vehicleSeriesId;
    }

    public String getVehicleSeriesName() {
        return vehicleSeriesName;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public String getModifier() {
        return modifier;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
