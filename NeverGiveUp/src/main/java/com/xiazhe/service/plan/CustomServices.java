package com.xiazhe.service.plan;

import com.xiazhe.bean.Custom;
import com.xiazhe.bean.json.QueryJsonBean;

import java.util.List;

public interface CustomServices {

    QueryJsonBean<Custom> queryCustomPages(int page, int rows);

    List<Custom> getCustomData();

    Custom queryCustomById(String id);
}
