package com.xiazhe.service.finalMeasureCheckService;

import com.xiazhe.bean.FinalMeasuretCheck;
import com.xiazhe.mapper.FinalMeasuretCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalMeasuretServiceImpl implements FinalMeasuretService {
    @Autowired
    FinalMeasuretCheckMapper mymapper;

    @Override
    public List<FinalMeasuretCheck> getlist() {
        return mymapper.getlist();
    }

    @Override
    public int insertanew(FinalMeasuretCheck fmc) {
        int i = mymapper.insert(fmc);
        return  i;
    }

    @Override
    public int deletebyId(FinalMeasuretCheck fmc) {
        int i = mymapper.deleteByPrimaryKey(fmc.getfMeasureCheckId());
        return i;
    }

    @Override
    public int deletebyIds(String[] ids) {
        return mymapper.deletebyIds(ids);
    }

    @Override
    public int UpdateNote(String fMeasureCheckId, String note) {
        return mymapper.UpdateNote(fMeasureCheckId,note);
    }

    @Override
    public List<FinalMeasuretCheck> getlistByFCid(String searchValue) {
        return mymapper.getlistByFCid(searchValue);
    }

    @Override
    public List<FinalMeasuretCheck> getlistByOid(String searchValue) {
        return mymapper.getlistByOid(searchValue);
    }
}
