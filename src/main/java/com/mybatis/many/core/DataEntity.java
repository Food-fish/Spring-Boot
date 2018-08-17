package com.mybatis.many.core;

import org.springframework.format.annotation.DateTimeFormat;


public class DataEntity<T> extends BaseEntity<T> {
    /** 
	 * @Fields serialVersionUID ：TODO
	 */ 
	private static final long serialVersionUID = 1L;
	
	private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createDate;
    private String updateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateDate;
    private String delFlag;

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public DataEntity(String createBy, String createDate, String updateBy, String updateDate, String delFlag) {
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.delFlag = delFlag;
    }
}
