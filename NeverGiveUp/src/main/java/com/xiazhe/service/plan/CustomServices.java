package com.xiazhe.service.plan;

import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;

import java.util.List;

public interface CustomServices {

    QueryJsonBean<Custom> queryCustomPages(int page, int rows);

    List<Custom> getCustomData();

    Custom queryCustomById(String id);

    int insertNewCustom(Custom custom);

    int updateCustom(Custom custom);

    int deleteCustoms(String[] ids);

    QueryJsonBean<Custom> searchCustoms(String value,String op, int page, int rows);

}
