package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;
import com.xiazhe.mapper.ProductMapper;
import com.xiazhe.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class WorkServicesImpl implements WorkServices {
    @Autowired
    WorkMapper workMapper;

    @Override
    public QueryJsonBean<PlanWorkBean> queryWorkPages(int page, int rows) {
        QueryJsonBean<PlanWorkBean> queryJsonBean = new QueryJsonBean<>();
        List<PlanWorkBean> list = workMapper.queryWorkList();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list = workMapper.queryWorkList();
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }
}
