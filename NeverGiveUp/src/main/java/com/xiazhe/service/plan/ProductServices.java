package com.xiazhe.service.plan;

import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;

public interface ProductServices {
    QueryJsonBean<Product> queryProductPages(int page, int rows);

    QueryJsonBean<Product> getProductData();


}
