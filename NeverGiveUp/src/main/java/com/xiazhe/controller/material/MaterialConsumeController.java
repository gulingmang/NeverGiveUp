package com.xiazhe.controller.material;

import com.xiazhe.bean.Result;
import com.xiazhe.bean.material.MaterialConsume;
import com.xiazhe.bean.material.MaterialConsumeList;
import com.xiazhe.bean.material.MaterialReceiveList;
import com.xiazhe.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {
    @Autowired
    MaterialConsumeService materialConsumeService;
    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/materialConsume_list.jsp";
    }
   /* @RequestMapping("product/get_data")*/

    @RequestMapping("list")
    @ResponseBody
    public MaterialConsumeList list(){
        List<MaterialConsume> materialConsumes = materialConsumeService.selectAll();
        MaterialConsumeList materialConsumeList = new MaterialConsumeList(materialConsumes.size(), materialConsumes);
        return materialConsumeList;
    }
    @RequestMapping("search_materialConsume_by_consumeId")
    @ResponseBody
    public MaterialConsumeList serachById(String searchValue,int page,int rows){
        MaterialConsume materialConsume = materialConsumeService.selectByPrimaryKey(searchValue);
        ArrayList<MaterialConsume> materialConsumes = new ArrayList<>();
        materialConsumes.add(materialConsume);
        MaterialConsumeList materialConsumeList = new MaterialConsumeList(materialConsumes.size(), materialConsumes);
        return materialConsumeList;
    }
    @RequestMapping("search_materialConsume_by_materialId")
    @ResponseBody
    public MaterialConsumeList serachByMaterialId(String searchValue,int page,int rows){
        List<MaterialConsume> materialConsumes = materialConsumeService.selectByMaterialId(searchValue);
        MaterialConsumeList materialConsumeList = new MaterialConsumeList(materialConsumes.size(), materialConsumes);
        return materialConsumeList;
    }
    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    public MaterialConsumeList serachByWorkId(String searchValue,int page,int rows){
        List<MaterialConsume> materialConsumes = materialConsumeService.selectByWorkId(searchValue);
        MaterialConsumeList materialConsumeList = new MaterialConsumeList(materialConsumes.size(), materialConsumes);
        return materialConsumeList;
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
    public String add(){return "/WEB-INF/jsp/materialConsume_add.jsp"; }

    @RequestMapping("insert")
    @ResponseBody
    public Result insert(MaterialConsume materialConsume){
       materialConsumeService.insert(materialConsume);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
    @RequestMapping("edit")
    public String edit(){return "/WEB-INF/jsp/materialConsume_edit.jsp"; }

    @RequestMapping("update_all")
    @ResponseBody
    public Result update(MaterialConsume materialConsume){
       materialConsumeService.updateByPrimaryKey(materialConsume);
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){
        for (int i = 0; i < ids.length; i++) {
           materialConsumeService.deleteByPrimaryKey(ids[i]);
        }
        Result result = new Result();
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
}
