package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.mapper.ProductMapper;
import org.apache.ibatis.annotations.Mapper;
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

    @Override
    public Product queryProductById(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public int insertNewProduct(Product product) {

        int insert = productMapper.insert(product);
        if(insert > 0){
            return insert;
        }else {
            return 0;
        }
    }

    @Override
    public int updateProduct(Product product) {
        int i = productMapper.updateByPrimaryKey(product);
        if(i>0){
            return i;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteProdcuucts(String[] ids) {
        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i <ids.length ; i++) {
            count += productMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count>0){
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<Product> searchProducts(String value, String op, int page, int rows) {
        QueryJsonBean<Product> queryJsonBean = new QueryJsonBean<>();
        List<Product> list = productMapper.searchProducts(value, op);
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list  = productMapper.searchProducts(value,op);
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }
}
