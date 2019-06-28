package com.xiazhe.service.plan;

import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;

public interface WorkServices {

    QueryJsonBean<PlanWorkBean> queryWorkPages(int page, int rows);
}
