package com.xiazhe.controller.plan;


import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Product;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.plan.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("product")
public class ManagerProductController {

        @Autowired
        ProductServices productServices;


        @RequestMapping("find")
        public String product(){
            return "/WEB-INF/jsp/product_list.jsp";
        }

        @RequestMapping("list")
        @ResponseBody
        public QueryJsonBean<Product> getProductList(int page, int rows){
            return  productServices.queryProductPages(page,rows);
        }

        @RequestMapping("get_data")
        @ResponseBody
        public List<Product> getProductData(){
           return productServices.getProductData();
        }

        @RequestMapping("/*_judge")
        @ResponseBody
        public String productJudge(){
            return null;
        }

        @RequestMapping("add")
        public String addProduct(){
            return "/WEB-INF/jsp/product_add.jsp";
        }

        @RequestMapping("insert")
        @ResponseBody
        public Result addNewProduct(Product product){
            int i = productServices.insertNewProduct(product);
            Result result = new Result();
            if(i>0){
                result.setStatus(200);
                result.setMsg("ok");
            }else{
                result.setStatus(500);
                result.setMsg("error");
            }
            return result;
        }

    @RequestMapping(value="/get/{id}")
    @ResponseBody
    public Product restGetCustom(@PathVariable(value = "id")String id){
        Product product=  productServices.queryProductById(id);
        return product;
    }

    @RequestMapping("edit")
    public String editProduct(){
            return "/WEB-INF/jsp/product_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateProduct(Product product){
        int i = productServices.updateProduct(product);
        Result result = new Result();
        if(i>0){
            result.setStatus(200);
            result.setMsg("ok");
        }else{
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Result deleteProducts(String[] ids){
        int i = productServices.deleteProdcuucts(ids);
        Result result = new Result();
        if(i > 0){
            result.setStatus(200);
            result.setMsg("ok");
        }else{
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }


    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public QueryJsonBean<Product> searchProductByPorductId(String searchValue, int page, int rows){
        QueryJsonBean<Product> queryJsonBean = productServices.searchProducts(searchValue, "productId", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public QueryJsonBean<Product> searchProductByPorductName(String searchValue, int page, int rows){
        QueryJsonBean<Product> queryJsonBean = productServices.searchProducts(searchValue, "productName", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public QueryJsonBean<Product> searchProductByPorductType(String searchValue, int page, int rows){
        QueryJsonBean<Product> queryJsonBean = productServices.searchProducts(searchValue, "productType", page, rows);
        return queryJsonBean;
    }
}
