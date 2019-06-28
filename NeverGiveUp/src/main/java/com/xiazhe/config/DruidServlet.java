package com.xiazhe.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*")
public class DruidServlet extends StatViewServlet {
}
