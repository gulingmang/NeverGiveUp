package com.xiazhe.service.finalCountCheckService;

import com.xiazhe.bean.FinalCountCheck;
import com.xiazhe.mapper.FinalCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinalCountCheckServiceImpl implements  FinalCountCheckService{
   @Autowired
    FinalCountCheckMapper mymapper;
    @Override
    public List<FinalCountCheck> getlist() {

        return   mymapper.getlist();
    }
}
