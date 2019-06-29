package com.xiazhe.service.pmeasurecheckService;

import com.xiazhe.bean.ProcessMeasureCheck;
import com.xiazhe.mapper.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmeasurecheckServiceImpl implements PmeasurecheckService {
    @Autowired
    ProcessMeasureCheckMapper mymapper;

    @Override
    public List<ProcessMeasureCheck> getlist() {

        return mymapper.getlist();
    }

    @Override
    public int deletbyId(ProcessMeasureCheck obj) {
        return mymapper.deleteByPrimaryKey(obj.getpMeasureCheckId());
    }

    @Override
    public int insert(ProcessMeasureCheck obj) {
        return mymapper.insert(obj);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return mymapper.deleteByIds(ids);
    }

    @Override
    public List<ProcessMeasureCheck>  serchById(String searchValue) {
        return mymapper.serchById(searchValue);
    }

    @Override
    public int update_note(String pMeasureCheckId, String note) {
        return mymapper.updatenote(pMeasureCheckId,note);
    }
}
