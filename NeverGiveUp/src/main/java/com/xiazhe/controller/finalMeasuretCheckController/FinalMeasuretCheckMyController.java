package com.xiazhe.controller.finalMeasuretCheckController;

import com.xiazhe.bean.FinalMeasuretCheck;
import com.xiazhe.bean.Result;
import com.xiazhe.service.finalMeasureCheckService.FinalMeasuretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FinalMeasuretCheckMyController {
    @Autowired
    FinalMeasuretService myservice;

    @RequestMapping("measure/find")
    public String getlisturl(HttpSession httpSession) {
       List<String> sysPermissionList=new ArrayList<>();

        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public List<FinalMeasuretCheck> returnalist(int page, int rows) {
        List<FinalMeasuretCheck> getlist = myservice.getlist();
        return getlist;
    }

    @RequestMapping("fMeasureCheck/*_judge")
    @ResponseBody
    public String judge() {
        return "";
    }

    @RequestMapping("measure/add")
    public String measureadd() {
        return "/WEB-INF/jsp/measurement_add.jsp";
    }
    @RequestMapping("measure/insert")
    @ResponseBody
    public Result measureinsert(FinalMeasuretCheck fmc) {
        int insertanew = myservice.insertanew(fmc);
        Result result = new Result();
        if (insertanew != 0) {
            result.setData(null);
            result.setMsg("Ok");
            result.setStatus(200);
            return result;
        } else {
            result.setData(null);
            result.setMsg("用户id不能相同");
            result.setStatus(400);
            return result;
        }
    }
}
