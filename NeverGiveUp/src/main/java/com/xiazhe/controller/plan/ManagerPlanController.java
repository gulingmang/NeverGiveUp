package com.xiazhe.controller.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.plan.OrderServices;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String order(){
        return "/WEB-INF/jsp/order_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<Order> getOrderList(int page, int rows){
        QueryJsonBean<Order> queryJsonBean;
        queryJsonBean = orderServices.queryOrderPages(page,rows);
        return queryJsonBean;
    }


    @RequestMapping("/*_judge")
    @ResponseBody
    public String OrderJudge(){
        return null;
    }

    @RequestMapping("add")
    public String addOrder(){
        return "/WEB-INF/jsp/order_add.jsp";
    }


    @RequestMapping("insert")
    @ResponseBody
    public Result addNewOrder(Order order){
        int i = orderServices.insertNewOrder(order);
        Result result = new Result();
        if(i>0){
            result.setMsg("ok");
            result.setStatus(200);
        }else{
            result.setMsg("error");
            result.setStatus(404);
        }
        return result;
    }




    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){
        Result result = new Result();
        int deleteOrders = orderServices.deleteOrders(ids);
        if(deleteOrders>0){
            result.setMsg("ok");
            result.setStatus(200);
        }else {
            result.setMsg("error");
            result.setStatus(500);
        }
        return result;
    }

    @RequestMapping("edit")
    public String orderEdit(){
        return "/WEB-INF/jsp/order_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateOrder(Order order){
        Result result = new Result();
        int updateOrder = orderServices.updateOrder(order);
        if (updateOrder>0){
            result.setStatus(200);
            result.setMsg("ok");
        }else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public QueryJsonBean<Order> searchByOrderId(String searchValue, int page, int rows){
        QueryJsonBean<Order> queryJsonBean = orderServices.searchOrders(searchValue, "orderId", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public QueryJsonBean<Order> searchByCustomId(String searchValue, int page, int rows){
        QueryJsonBean<Order> queryJsonBean = orderServices.searchOrders(searchValue, "customId", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public QueryJsonBean<Order> searchByProductId(String searchValue, int page, int rows){
        QueryJsonBean<Order> queryJsonBean = orderServices.searchOrders(searchValue, "productId", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public Order getOrder(@PathVariable("id")String id){
       return orderServices.getOrder(id);
    }
}
