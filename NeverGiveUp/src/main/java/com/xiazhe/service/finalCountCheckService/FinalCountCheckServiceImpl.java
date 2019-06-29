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

    @Override
    public int insertANew(FinalCountCheck fcc) {
        int insert = mymapper.insert(fcc);
        return insert;
    }

    @Override
    public int deleteById(FinalCountCheck fcc) {

        return mymapper.deleteByPrimaryKey(fcc.getfCountCheckId());
    }

    @Override
    public int deleteByIds(String[] ids) {
   return mymapper.deleteByIds(ids);
    }

    @Override
    public List<FinalCountCheck> getlistByOrderId(String searchValue) {
        return mymapper.getlistByOrderId(searchValue);
    }

    @Override
    public List<FinalCountCheck> getlistByFcountCkeckId(String searchValue) {
        return mymapper.getlistByFcountCkeckId(searchValue);
    }

    @Override
    public int updateNote(String fCountCheckId, String note) {
        return mymapper.updateNote(fCountCheckId,note);
    }
}
