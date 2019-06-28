package com.xiazhe.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebFilter(urlPatterns = "/*",initParams = { @WebInitParam (name="exclusions", value ="*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")})
public class DruidFilter extends WebStatFilter {
}
