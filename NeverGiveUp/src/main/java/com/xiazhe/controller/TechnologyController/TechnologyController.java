package com.xiazhe.controller.TechnologyController;

import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;
    //显示工艺管理列表
    @RequestMapping("/find")
    public String toTechnologyList(HttpSession httpSession){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technology:add");
        objects.add("technology:edit");
        objects.add("technology:delete");
        httpSession.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<Technology> queryAllTechnology(){
        List<Technology> technologies = technologyService.queryAllTechnology();
        return technologies;
    }


    //通过id进行模糊查询
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public Technology[] selectByIdAm(String searchValue){
        Technology[] technologies = technologyService.selectByPrimaryKey(searchValue);
        return technologies;
    }

    /*增加工艺*/
    //跳转至增加页面
    @RequestMapping("add_judge")
    public String toAddjudge(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }
    @RequestMapping("add")
    public String toAdd(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }
    //增加工艺操作
    @RequestMapping("insert")
    @ResponseBody
    public Result insert(Technology technology){
        technologyService.insert(technology);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工艺修改*/
    //跳转至修改界面
    @RequestMapping("edit_judge")
    public String toEditjudge(){
        return "/WEB-INF/jsp/technology_edit.jsp";
    }
    @RequestMapping("edit")
    public String toEdit(){
        return "/WEB-INF/jsp/technology_edit.jsp";
    }

    //修改工艺操作
    @RequestMapping("update_all")
    @ResponseBody
    public Result edit(Technology technology){
        technologyService.updateByPrimaryKey(technology);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工艺删除操作*/
    //跳转至删除页面
    @RequestMapping("delete_judge")
    public String todeletejudge(){
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){//参数名称要与前端传来的一样，mapper层注解也是
        technologyService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }
}
