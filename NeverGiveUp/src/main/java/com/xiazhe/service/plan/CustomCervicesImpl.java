package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CustomCervicesImpl implements CustomServices{
    @Autowired
    CustomMapper customMapper;


    @Override
    public QueryJsonBean<Custom> queryCustomPages(int page, int rows) {
        QueryJsonBean<Custom> queryJsonBean = new QueryJsonBean<>();
        List<Custom> list = customMapper.queryCustoms();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list = customMapper.queryCustoms();
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }

    @Override
    public List<Custom> getCustomData() {

        return customMapper.queryCustoms();
    }

    @Override
    public Custom queryCustomById(String id) {
        Custom custom = customMapper.selectByPrimaryKey(id);
        return custom;
    }

    @Override
    public int insertNewCustom(Custom custom) {
        int insert = customMapper.insert(custom);
        if(insert>0){
            return insert;
        }else{
            return 0;
        }
    }

    @Override
    public int updateCustom(Custom custom) {
        int update = customMapper.updateByPrimaryKey(custom);
        if(update>0){
            return update;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteCustoms(String[] ids) {

        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i <ids.length ; i++) {
            count += customMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count>0){
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<Custom> searchCustoms(String value, String op, int page, int rows) {
        QueryJsonBean<Custom> queryJsonBean = new QueryJsonBean<>();
        List<Custom> list = customMapper.searchCustoms(value, op);
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list  = customMapper.searchCustoms(value,op);
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }
}
