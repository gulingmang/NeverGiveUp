package com.xiazhe.controller.plan;

import com.xiazhe.bean.plan.OrderJson;
import com.xiazhe.service.plan.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("order")
public class ManagerPlanController {
    @Autowired
    OrderServices orderServices;

    @RequestMapping("find")
    public String order(HttpServletRequest request){
        List<String> list =  new LinkedList<>();
        list.add("order:add");
        list.add("order:delete");
        list.add("order:edit");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/order_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public OrderJson getOrderList(int page,int rows){

        OrderJson orderJson = orderServices.queryOrders();
        return orderJson;
    }
}
