package com.xiazhe.service.unqulifyControllerService;

import com.xiazhe.bean.UnQualifyApply;

import java.util.List;

public interface UnqualifyService {
    public List<UnQualifyApply> getApplyList();
    public  int insert(UnQualifyApply record);
}
