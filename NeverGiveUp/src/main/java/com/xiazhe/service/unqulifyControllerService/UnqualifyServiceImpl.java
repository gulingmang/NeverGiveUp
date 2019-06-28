package com.xiazhe.service.unqulifyControllerService;

import com.xiazhe.bean.UnQualifyApply;
import com.xiazhe.mapper.UnQualifyApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UnqualifyServiceImpl implements  UnqualifyService{
    @Autowired
    UnQualifyApplyMapper mymapper;
    @Override
    public List<UnQualifyApply> getApplyList() {
        List<UnQualifyApply> applyList = mymapper.getApplyList();
        return applyList;
    }
    @Override
    public  int insert(UnQualifyApply record){
        int insert = mymapper.insert(record);
        return  insert;
    }
}
