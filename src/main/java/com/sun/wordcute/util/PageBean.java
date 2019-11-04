package com.sun.wordcute.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页工具类
 * @Author: SunK
 * @CreateDate: 2018/5/23 16:05
 * @Version: 1.0
 */
@Data
public class PageBean implements Serializable {

    // 总页码数(计算得来)
    private int totalPage;

    // 没有显示大小(固定写死)
    private int pageSize;

    // 要查看的页面(前台页面传递)
    private int pageNumber;

    // 总记录数(查询数据库)
    private int totalRecord;

    // 起始索引(计算得来)
    private int startIndex;

    // 查询数据库
    private List result;

    public int getStartIndex() {
        return startIndex=(this.getPageNumber() - 1) * this.getPageSize();
    }


    public int getTotalPage() {
        return totalPage = this.getTotalRecord() % this.getPageSize() == 0
                ? (this.getTotalRecord() / this.getPageSize())
                : (this.getTotalRecord() / this.getPageSize() + 1);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public PageBean() {

    }
}
