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
}
