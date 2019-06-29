package com.xiazhe.service.finalMeasureCheckService;

import com.xiazhe.bean.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasuretService {
    List<FinalMeasuretCheck> getlist();

    int insertanew(FinalMeasuretCheck fmc);

    int deletebyId(FinalMeasuretCheck fmc);

    int deletebyIds(String[] ids);

    int UpdateNote(String fMeasureCheckId, String note);

    List<FinalMeasuretCheck> getlistByFCid(String searchValue);

    List<FinalMeasuretCheck> getlistByOid(String searchValue);
}
