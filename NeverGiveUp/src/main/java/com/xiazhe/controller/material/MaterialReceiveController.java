package com.xiazhe.controller.material;

import com.xiazhe.bean.Result;
import com.xiazhe.bean.material.MaterialReceive;
import com.xiazhe.bean.material.MaterialReceiveList;
import com.xiazhe.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;
    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/materialReceive_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public MaterialReceiveList lis(){
        List<MaterialReceive> materialReceives = materialReceiveService.selectAll();
        MaterialReceiveList materialReceiveList = new MaterialReceiveList(materialReceives.size(), materialReceives);
        return materialReceiveList;
    }
    @RequestMapping("search_materialReceive_by_receiveId")
    @ResponseBody
    public MaterialReceiveList searchByReceiveId(String searchValue,int page,int rows){
        MaterialReceive materialReceive = materialReceiveService.selectByPrimaryKey(searchValue);
        ArrayList<MaterialReceive> materialReceives = new ArrayList<>();
        materialReceives.add(materialReceive);
        MaterialReceiveList materialReceiveList = new MaterialReceiveList(materialReceives.size(), materialReceives);
        return materialReceiveList;
    }
    @RequestMapping("search_materialReceive_by_materialId")
    @ResponseBody
    public MaterialReceiveList searchByMaterialId(String searchValue,int page,int rows){
        MaterialReceive materialReceive = materialReceiveService.selectByMaterialId(searchValue);
        ArrayList<MaterialReceive> materialReceives = new ArrayList<>();
        materialReceives.add(materialReceive);
        MaterialReceiveList materialReceiveList = new MaterialReceiveList(materialReceives.size(), materialReceives);
        return materialReceiveList;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){return "/WEB-INF/jsp/materialReceive_add.jsp"; }

    @RequestMapping("insert")
    @ResponseBody
    public Result insert(MaterialReceive materialReceive){
       materialReceiveService.insert(materialReceive);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
    @RequestMapping("edit")
    public String edit(){return "/WEB-INF/jsp/materialReceive_edit.jsp"; }

    @RequestMapping("update_all")
    @ResponseBody
    public Result update(MaterialReceive materialReceive){
        materialReceiveService.updateByPrimaryKey(materialReceive);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){
        for (int i = 0; i < ids.length; i++) {
            materialReceiveService.deleteByPrimaryKey(ids[i]);
        }
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
}
