package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Manufacture;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanManufactureBean;
import com.xiazhe.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufactureServicesImpl implements ManufactureServices {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public QueryJsonBean<PlanManufactureBean> queryManufactures(int page, int rows) {
        List<PlanManufactureBean> list = manufactureMapper.queryPlanManufactureBeans();
        QueryJsonBean<PlanManufactureBean> queryJsonBean = new QueryJsonBean<>();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list = manufactureMapper.queryPlanManufactureBeans();
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }

    @Override
    public List<PlanManufactureBean> getManufactureData() {
        List<PlanManufactureBean> list = manufactureMapper.queryPlanManufactureBeans();
        return list;
    }

    @Override
    public int insertNewManufacture(Manufacture manufacture) {
        int insert = manufactureMapper.insert(manufacture);
        if(insert>0){
            return insert;
        }else {
            return 0;
        }
    }

    @Override
    public int updateManufacture(Manufacture manufacture) {
        int i = manufactureMapper.updateByPrimaryKey(manufacture);
        if(i>0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteManufactures(String[] ids) {

        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i <ids.length ; i++) {
            count += manufactureMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count>0){
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<PlanManufactureBean> searchPlanManufactureBeans(String value, String op, int page, int rows) {
        List<PlanManufactureBean> list = manufactureMapper.searchPlanManufactureBeans(value, op);
        QueryJsonBean<PlanManufactureBean> queryJsonBean = new QueryJsonBean<>();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list = manufactureMapper.searchPlanManufactureBeans(value,op);
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }

    @Override
    public PlanManufactureBean getPlanManufacture(String id) {
        PlanManufactureBean planManufactureBean = manufactureMapper.getPlanManufactureBean(id);
        return planManufactureBean;
    }
}
