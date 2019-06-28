package com.xiazhe.controller.material;

import com.xiazhe.bean.Result;
import com.xiazhe.bean.material.Material;
import com.xiazhe.bean.material.MaterialList;
import com.xiazhe.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/material_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public MaterialList list(){
        List<Material> materials = materialService.selectAll();
        MaterialList materialList = new MaterialList(materials.size(), materials);
        return materialList;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public MaterialList getData(){
        List<Material> materials = materialService.selectAll();
        MaterialList materialList = new MaterialList(materials.size(), materials);
        return materialList;
    }
    @RequestMapping("get/{materialId}")
    @ResponseBody
    public Material get(@PathVariable("materialId") String materialId){
        Material material = materialService.selectByPrimaryKey(materialId);
        return material;
    }
    @RequestMapping("search_material_by_materialId")
    @ResponseBody
    public MaterialList searchById(String searchValue,int page,int rows){
        Material material = materialService.selectByPrimaryKey(searchValue);
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(material);
        MaterialList materialList = new MaterialList(materials.size(), materials);
        return materialList;
    }
    @RequestMapping("search_material_by_materialType")
    @ResponseBody
    public MaterialList searchByType(String searchValue,int page,int rows){
        Material material = materialService.selectByType(searchValue);
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(material);
        MaterialList materialList = new MaterialList(materials.size(), materials);
        return materialList;
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
    public String add(){return "/WEB-INF/jsp/material_add.jsp"; }

    @RequestMapping("insert")
    @ResponseBody
    public Result insert(Material material){
        materialService.insert(material);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
    @RequestMapping("edit")
    public String edit(){return "/WEB-INF/jsp/material_edit.jsp"; }

    @RequestMapping("update_all")
    @ResponseBody
    public Result update(Material material){
        materialService.updateByPrimaryKey(material);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){
        for (int i = 0; i < ids.length; i++) {
            materialService.deleteByPrimaryKey(ids[i]);
        }
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
}
