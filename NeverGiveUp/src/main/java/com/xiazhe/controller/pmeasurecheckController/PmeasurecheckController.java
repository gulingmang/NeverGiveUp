package com.xiazhe.controller.pmeasurecheckController;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.ProcessMeasureCheck;
import com.xiazhe.bean.Result;
import com.xiazhe.service.pmeasurecheckService.PmeasurecheckService;
import com.xiazhe.service.pmeasurecheckService.PmeasurecheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("p_measure_check")
public class PmeasurecheckController {
    @Autowired
    PmeasurecheckService myservice;

    @RequestMapping("find")
    public String getsessionToUrl(HttpSession session) {
        List<String> s = new ArrayList<>();
        s.add("pMeasureCheck:add");
        s.add("pMeasureCheck:edit");
        s.add("pMeasureCheck:delete");
        session.setAttribute("sysPermissionList", s);
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<ProcessMeasureCheck> getlist(int page, int rows) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page - 1) * rows, rows);
        List<ProcessMeasureCheck> getlist = myservice.getlist();
        return getlist;
    }


    @RequestMapping("add")
    /*返回add页面*/
    public String add() {
        return "/WEB-INF/jsp/p_measure_check_add.jsp";
    }

    @RequestMapping("insert")
    @ResponseBody
    /*新加一个对象的操作*/
    public Result insert(ProcessMeasureCheck obj) {
        Result result = new Result();

        int x = myservice.deletbyId(obj);
        int ans = myservice.insert(obj);
        if (ans != 0) {

            result.setData(null);
            result.setMsg("Ok");
            result.setStatus(200);

        } else {
            result.setData(null);
            result.setMsg("加入失败");
            result.setStatus(201);
        }
        return result;

    }

    @RequestMapping("edit")
    /*新加一个对象的操作*/
    public String edit() {
        return "/WEB-INF/jsp/p_measure_check_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    /*新加一个对象的操作*/
    public Result updateAll(ProcessMeasureCheck obj) {
        Result result = new Result();

        int x = myservice.deletbyId(obj);
        int ans = myservice.insert(obj);
        if (ans != 0) {

            result.setData(null);
            result.setMsg("编辑成功");
            result.setStatus(200);

        } else {
            result.setData(null);
            result.setMsg("编辑失败");
            result.setStatus(201);
        }
        return result;

    }

    @RequestMapping("delete_batch")
    @ResponseBody
    /*新加一个对象的操作*/
    public Result deleteBatch(String[] ids) {
        Result result = new Result();


        int ans = myservice.deleteByIds(ids);
        if (ans != 0) {

            result.setData(null);
            result.setMsg("删除成功");
            result.setStatus(200);

        } else {
            result.setData(null);
            result.setMsg("删除失败");
            result.setStatus(201);
        }
        return result;

    }

    @RequestMapping("search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    /*新加一个对象的操作*/
    public  List<ProcessMeasureCheck>  SearchById(String searchValue) {
        return  myservice.serchById(searchValue);
    }
    @RequestMapping("update_note")
    @ResponseBody
    /*新加一个对象的操作*/
    public  Result  update_note(String pMeasureCheckId, String note) {

        Result result = new Result();


        int ans = myservice.update_note(pMeasureCheckId,note);
        if (ans != 0) {

            result.setData(null);
            result.setMsg("删除成功");
            result.setStatus(200);

        } else {
            result.setData(null);
            result.setMsg("删除失败");
            result.setStatus(201);
        }
        return result;
    }
}
