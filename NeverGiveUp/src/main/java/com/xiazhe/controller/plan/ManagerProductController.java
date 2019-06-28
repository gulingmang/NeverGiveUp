package com.xiazhe.controller.plan;


import com.xiazhe.bean.Product;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.plan.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        public String product(HttpServletRequest request){
            List<String> list =  new LinkedList<>();
            list.add("product:add");
            list.add("product:delete");
            list.add("product:edit");
            request.getSession().setAttribute("sysPermissionList",list);
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

}
