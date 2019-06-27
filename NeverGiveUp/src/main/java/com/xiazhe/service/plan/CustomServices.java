package com.xiazhe.service.plan;

import com.xiazhe.bean.Custom;
import com.xiazhe.bean.json.QueryJsonBean;

public interface CustomServices {

    QueryJsonBean<Custom> queryCustomPages(int page, int rows);
}
