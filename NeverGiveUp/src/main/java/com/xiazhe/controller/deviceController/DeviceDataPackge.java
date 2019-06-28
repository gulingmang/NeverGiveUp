package com.xiazhe.controller.deviceController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class DeviceDataPackge {
    //封装页面数据显示
    public void ableSysPermissionList(HttpSession session,String status){
        List sysPermissionList = new ArrayList<>();
        sysPermissionList.add("device" + status + ":add");
        sysPermissionList.add("device" + status + ":edit");
        sysPermissionList.add("device" + status + ":delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
    }
}
