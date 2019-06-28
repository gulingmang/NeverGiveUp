package com.xiazhe.bean.file;


/**
 *@author: Draven
 *@date: 2019/6/28
 *@description: 用来对file上传之后的返回数据
 *@param:
 *@return:
 */

public class FileResult {
    // 文件上传之后成功与否的状态码
    private int error;

    // 文件上传之后的url
    private String url;

    public FileResult() {
    }

    public FileResult(int error, String url) {
        this.error = error;
        this.url = url;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
