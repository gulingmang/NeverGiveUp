package com.xiazhe.service.pmeasurecheckService;

import com.xiazhe.bean.ProcessMeasureCheck;

import java.util.List;

public interface PmeasurecheckService {
    List<ProcessMeasureCheck> getlist();

    int deletbyId(ProcessMeasureCheck obj);

    int insert(ProcessMeasureCheck obj);

    int deleteByIds(String[] ids);

    List<ProcessMeasureCheck>  serchById(String searchValue);

    int update_note(String pMeasureCheckId, String note);
}
