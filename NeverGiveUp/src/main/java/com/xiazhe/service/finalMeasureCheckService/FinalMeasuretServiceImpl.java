package com.xiazhe.service.finalMeasureCheckService;

import com.xiazhe.mapper.FinalMeasuretCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalMeasuretServiceImpl implements FinalMeasuretService {
    @Autowired
    FinalMeasuretCheckMapper mymapper;

    @Override
    public List<FinalMeasuretService> getlist() {
        return mymapper.getlist();
    }
}
