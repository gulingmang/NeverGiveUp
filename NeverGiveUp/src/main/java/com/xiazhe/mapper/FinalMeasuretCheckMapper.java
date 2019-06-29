package com.xiazhe.mapper;

import com.xiazhe.bean.FinalMeasuretCheck;
import com.xiazhe.service.finalMeasureCheckService.FinalMeasuretService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
    public List<FinalMeasuretCheck> getlist() ;

    int deletebyIds(@Param("ids") String[] ids);

    int UpdateNote(@Param("fMeasureCheckId")String fMeasureCheckId, @Param("note") String note);

    List<FinalMeasuretCheck> getlistByFCid(String searchValue);

    List<FinalMeasuretCheck> getlistByOid(String searchValue);
}