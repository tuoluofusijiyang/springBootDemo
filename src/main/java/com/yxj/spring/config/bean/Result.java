package com.yxj.spring.config.bean;

/**
 * 返回结果
 * @author ServerZhang
 * @date 2018年5月28日
 */
public class Result {

    private Boolean success;
    private String infor;
    private Object data;

    public Result(Boolean success, String infor, Object data){
        if (success == null) {
            success = false;
        }
        this.success = success;
        this.infor = infor;
        this.data = data;
    }

    public Result(Boolean success, String infor){
        if (success == null) {
            success = false;
        }
        this.success = success;
        this.infor = infor;
        this.data = null;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}