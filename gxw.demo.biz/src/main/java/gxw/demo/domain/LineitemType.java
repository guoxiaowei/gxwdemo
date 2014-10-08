package gxw.demo.domain;

import ocean.core.type.EnumCodeGetter;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * 
 * 订单行项目类型，行项目类型决定了数据存储<br>
 *
 * @author ZGF
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum LineitemType implements EnumCodeGetter {

    /**
     * 道路救援类
     */
    ROAD_RESCUE("1"),

    /**
     * 维修保养
     */
    MAINTAIN_DETAIL("2"),
    /**
     * 代驾服务
     */
    DESIGNATED_DRIVER("3"),

    /**
     * 保险理赔
     */
    INSURANCE("4"),

    /**
     * 汽车服务代理类
     */
    AUTOMOBILE_SERVICE_AGENT("5"),

    /**
     * 上门服务
     */
    ONSITE_SERVICE("6"),

    /**
     * 洗车服务
     */
    CAR_WASH("7"),

    /**
     * 实体
     */
    ENTITY("8"),

    /**
     * 团购券
     */
    GROUP_COUPON("9");// coupon

    private String code;

    private LineitemType(String code) {
        this.code = code;
    }

    @Override
    @JsonValue
    public String getCode() {
        return this.code;
    }
}
