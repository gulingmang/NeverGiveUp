package com.xiazhe.service.plan;

import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;

import java.util.List;

public interface ProductServices {
    QueryJsonBean<Product> queryProductPages(int page, int rows);

    List<Product> getProductData();


}
