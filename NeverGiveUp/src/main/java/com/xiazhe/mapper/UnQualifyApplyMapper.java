package com.xiazhe.mapper;

import com.xiazhe.bean.UnQualifyApply;

import java.util.List;

public interface UnQualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnQualifyApply record);

    int insertSelective(UnQualifyApply record);

    UnQualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnQualifyApply record);

    int updateByPrimaryKey(UnQualifyApply record);
    public List<UnQualifyApply> getApplyList();

}