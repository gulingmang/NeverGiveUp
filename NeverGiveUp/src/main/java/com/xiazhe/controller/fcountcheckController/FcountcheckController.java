package com.xiazhe.controller.fcountcheckController;
import	java.sql.ResultSet;

import com.xiazhe.bean.FinalCountCheck;
import com.xiazhe.bean.Result;
import com.xiazhe.service.finalCountCheckService.FinalCountCheckService;
import com.xiazhe.service.finalCountCheckService.FinalCountCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("f_count_check")
public class FcountcheckController {
    @Autowired
    FinalCountCheckService myservice;

    @RequestMapping("/find")

    public String find(HttpSession sessions) {
        List<String> sysPermissionList = new ArrayList<>();

        sysPermissionList.add("fCountCheck:add");
        sysPermissionList.add("fCountCheck:edit");
        sysPermissionList.add("fCountCheck:delete");
        sessions.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<FinalCountCheck> getlist() {

        List<FinalCountCheck> getlist = myservice.getlist();
        return getlist;
    }

    @RequestMapping("/add")
    public String toaddUrl() {

        return "/WEB-INF/jsp/f_count_check_add.jsp";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(FinalCountCheck fcc) {
        int insertanew = myservice.insertANew(fcc);
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

    @RequestMapping("/edit")
    public String toeditUrl() {

        return "/WEB-INF/jsp/f_count_check_edit.jsp";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Result updateAll(FinalCountCheck fcc) {
         int x=myservice.deleteById(fcc);
        int insertanew = myservice.insertANew(fcc);
        Result result = new Result();
        if (insertanew != 0) {
            result.setData(null);
            result.setMsg("编辑成功");
            result.setStatus(200);
            return result;
        } else {
            result.setData(null);
            result.setMsg("编辑失败");
            result.setStatus(400);
            return result;
        }
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteBatch(String[] ids) {

        int insertanew = myservice.deleteByIds(ids);
        Result result = new Result();
        if (insertanew != 0) {
            result.setData(null);
            result.setMsg("删除成功");
            result.setStatus(200);
            return result;
        } else {
            result.setData(null);
            result.setMsg("删除失败");
            result.setStatus(401);
            return result;
        }
    }
    @RequestMapping("search_fCountCheck_by_orderId")
    @ResponseBody
    public List<FinalCountCheck> searchbyOrderId(String searchValue) {

        List<FinalCountCheck> getlist = myservice.getlistByOrderId(searchValue);
        return getlist;
    }
    @RequestMapping("search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public List<FinalCountCheck> searchbyFcountCkeckId(String searchValue) {

        List<FinalCountCheck> getlist = myservice.getlistByFcountCkeckId(searchValue);
        return getlist;
    }
    @RequestMapping("update_note")
    @ResponseBody
    public Result updateNote(String fCountCheckId,String note) {

        int insertanew = myservice.updateNote(fCountCheckId,note);
        Result result = new Result();
        if (insertanew != 0) {
            result.setData(null);
            result.setMsg("修改备注成功");
            result.setStatus(200);
            return result;
        } else {
            result.setData(null);
            result.setMsg("修改备注失败");
            result.setStatus(401);
            return result;
        }
    }
}
