package com.xiazhe.service.plan;

import com.xiazhe.bean.Work;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;

import java.util.List;

public interface WorkServices {

    QueryJsonBean<PlanWorkBean> queryWorkPages(int page, int rows);

    int insertNewWork(Work work);

    int updateWork(Work work);

    int deleteWorks(String[] ids);

    QueryJsonBean<Work> searchWorks(String value, String op, int page, int rows);

    List<Work> getWorkData();

    PlanWorkBean getWorkById(String id);
}
