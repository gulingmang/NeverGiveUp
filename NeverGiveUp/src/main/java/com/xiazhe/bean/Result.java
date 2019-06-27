package com.xiazhe.bean;

/*该类为访问页面的返回结果的javabean
* 通过抓包可以看到，访问某些url需要返回这样一个结果
* 其结果通常为
* {"status":200,"msg":"OK","data":null}
* 形式的json数据。具体的数据可以根据结果自行更改*/
public class Result {
    private int status;
    private String msg;
    private String data;

    public Result() {
    }

    public Result(int status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
