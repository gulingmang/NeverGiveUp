package com.xiazhe.service.finalCountCheckService;

import com.xiazhe.bean.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckService {
    List<FinalCountCheck> getlist();

    int insertANew(FinalCountCheck fcc);

    int deleteById(FinalCountCheck fcc);

    int deleteByIds(String[] ids);

    List<FinalCountCheck> getlistByOrderId(String searchValue);

    List<FinalCountCheck> getlistByFcountCkeckId(String searchValue);

    int updateNote(String fCountCheckId, String note);
}
