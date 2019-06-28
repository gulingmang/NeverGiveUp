package com.xiazhe.controller.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.service.plan.OrderServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderGetDataController {

    @Autowired
    OrderServicesImpl myservice;
     @RequestMapping("order/get_data")
    @ResponseBody
    List<Order> getlist(){
       return   myservice.getlist();
     }
}
