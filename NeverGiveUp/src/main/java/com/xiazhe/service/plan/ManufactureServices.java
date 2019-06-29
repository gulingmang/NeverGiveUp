package com.xiazhe.service.plan;


import com.xiazhe.bean.Manufacture;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanManufactureBean;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ManufactureServices {

    QueryJsonBean<PlanManufactureBean> queryManufactures(int page, int rows);

    List<PlanManufactureBean> getManufactureData();

    int insertNewManufacture(Manufacture manufacture);

    int updateManufacture(Manufacture manufacture);

    int deleteManufactures(String[] ids);

    QueryJsonBean<PlanManufactureBean> searchPlanManufactureBeans(String value, String op, int page, int rows);

    PlanManufactureBean getPlanManufacture(String id);
}
