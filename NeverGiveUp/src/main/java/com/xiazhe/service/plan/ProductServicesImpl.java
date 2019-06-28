package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductMapper productMapper;

    @Override
    public QueryJsonBean<Product> queryProductPages(int page, int rows) {
            QueryJsonBean<Product> queryJsonBean = new QueryJsonBean<>();
            List<Product> list = productMapper.queryProducts();
            queryJsonBean.setTotal(list.size());
            PageHelper pageHelper = new PageHelper();
            pageHelper.offsetPage((page-1)*rows,rows);
            list = productMapper.queryProducts();
            queryJsonBean.setRows(list);
            return queryJsonBean;

    }

    @Override
    public List<Product> getProductData() {

        return productMapper.queryProducts();
    }
}
