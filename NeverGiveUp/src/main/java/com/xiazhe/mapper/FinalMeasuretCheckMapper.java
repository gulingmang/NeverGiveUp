package com.xiazhe.mapper;

import com.xiazhe.bean.FinalMeasuretCheck;
import com.xiazhe.service.finalMeasureCheckService.FinalMeasuretService;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
    public List<FinalMeasuretService> getlist() ;
}