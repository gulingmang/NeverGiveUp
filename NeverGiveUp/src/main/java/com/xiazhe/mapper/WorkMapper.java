package com.xiazhe.mapper;

import com.xiazhe.bean.Work;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<PlanWorkBean> queryWorkList();
}