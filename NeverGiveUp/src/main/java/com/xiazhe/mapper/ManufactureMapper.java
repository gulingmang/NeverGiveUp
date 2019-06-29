package com.xiazhe.mapper;

import com.xiazhe.bean.Manufacture;
import com.xiazhe.bean.plan.PlanManufactureBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<PlanManufactureBean> queryPlanManufactureBeans();

    List<PlanManufactureBean> searchPlanManufactureBeans(@Param("value")String value,@Param("op")String op);

    PlanManufactureBean getPlanManufactureBean(String id);
}