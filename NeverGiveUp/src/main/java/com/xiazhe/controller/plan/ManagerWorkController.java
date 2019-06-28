package com.xiazhe.controller.plan;


import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;
import com.xiazhe.service.plan.WorkServices;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderApplyWhereMethodGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("work")
public class ManagerWorkController {

    @Autowired
    WorkServices workServices;

    @RequestMapping("find")
    public String findWork(){
        return "/WEB-INF/jsp/work_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<PlanWorkBean>  getWorkList(int page, int rows){
        QueryJsonBean<PlanWorkBean> queryJsonBean = workServices.queryWorkPages(page,rows);
        return  queryJsonBean;
    }
}
