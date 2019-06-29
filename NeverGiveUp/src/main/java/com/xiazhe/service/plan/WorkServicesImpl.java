package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Work;
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

    @Override
    public int insertNewWork(Work work) {
        int insert = workMapper.insert(work);
        if(insert>0){
            return insert;
        }else {
            return 0;
        }
    }

    @Override
    public int updateWork(Work work) {
        int i = workMapper.updateByPrimaryKey(work);
        if(i>0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteWorks(String[] ids) {
        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i <ids.length ; i++) {
            count += workMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count>0){
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<Work> searchWorks(String value, String op, int page, int rows) {
        QueryJsonBean<Work> queryJsonBean = new QueryJsonBean<>();
        List<Work> list = workMapper.serachWorks(value,op);
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows, rows);
        list = workMapper.serachWorks(value,op);
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }

    @Override
    public List<Work> getWorkData() {
        List<Work> workData = workMapper.getWorkData();
        return workData;
    }

    @Override
    public PlanWorkBean getWorkById(String id) {
        PlanWorkBean planWorkBeanById = workMapper.getPlanWorkBeanById(id);
        return planWorkBeanById;
    }
}
