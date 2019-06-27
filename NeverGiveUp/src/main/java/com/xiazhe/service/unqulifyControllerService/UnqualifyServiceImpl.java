package com.xiazhe.service.unqulifyControllerService;

import com.xiazhe.bean.UnQualifyApply;
import com.xiazhe.mapper.UnQualifyApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UnqualifyServiceImpl implements  UnqualifyService{
    @Autowired
    UnQualifyApplyMapper mymapper;
    @Override
    public List<UnQualifyApply> getApplyList() {
        List<UnQualifyApply> applyList = mymapper.getApplyList();
        return applyList;
    }
}
