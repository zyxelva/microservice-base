package com.taeyeon.zyx.common;

/**
 * @author zyx
 * @date 2018/9/27 027 10:42
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Page<T> implements Serializable {
    private int pageNo;
    private int pageSize;
    private long total;
    private int first;
    private int last;
    private int prev;
    private int next;
    private boolean firstPage;
    private boolean lastPage;
    private int length;
    private int slider;
    private List<T> list;
    private String orderBy;
    private String funcName;
    private String funcParam;
    private String message;

    public Page() {
        this.pageNo = 1;
        this.pageSize = 20;
        this.length = 8;
        this.slider = 1;
        this.list = new ArrayList();
        this.orderBy = "";
        this.funcName = "page";
        this.funcParam = "";
        this.message = "";
        this.pageSize = -1;
    }

    public Page(int pageNo, int pageSize) {
        this(pageNo, pageSize, 0L);
    }

    public Page(int pageNo, int pageSize, long total) {
        this(pageNo, pageSize, total, new ArrayList());
    }

    public Page(int pageNo, int pageSize, long total, List<T> list) {
        this.pageNo = 1;
        this.pageSize = 20;
        this.length = 8;
        this.slider = 1;
        this.list = new ArrayList();
        this.orderBy = "";
        this.funcName = "page";
        this.funcParam = "";
        this.message = "";
        this.setTotal(total);
        this.setPageNo(pageNo);
        this.pageSize = pageSize == 0 ? 20 : pageSize;
        this.list = list;
    }

    public void initialize() {
        this.first = 1;
        this.last = (int) (this.total / (long) (this.pageSize < 1 ? 20 : this.pageSize) + (long) this.first - 1L);
        if (this.total % (long) this.pageSize != 0L || this.last == 0) {
            ++this.last;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.pageNo <= 1) {
            this.pageNo = this.first;
            this.firstPage = true;
        }

        if (this.pageNo >= this.last) {
            this.pageNo = this.last;
            this.lastPage = true;
        }

        if (this.pageNo < this.last - 1) {
            this.next = this.pageNo + 1;
        } else {
            this.next = this.last;
        }

        if (this.pageNo > 1) {
            this.prev = this.pageNo - 1;
        } else {
            this.prev = this.first;
        }

        if (this.pageNo < this.first) {
            this.pageNo = this.first;
        }

        if (this.pageNo > this.last) {
            this.pageNo = this.last;
        }

    }

    public String toString() {
        return "";
    }

    public String getHtml() {
        return this.toString();
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
        if ((long) this.pageSize >= total) {
            this.pageNo = 1;
        }

    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    @JsonIgnore
    public int getFirst() {
        return this.first;
    }

    @JsonIgnore
    public int getLast() {
        return this.last;
    }

    public int getTotalPage() {
        return this.getLast();
    }

    @JsonIgnore
    public boolean isFirstPage() {
        return this.firstPage;
    }

    @JsonIgnore
    public boolean isLastPage() {
        return this.lastPage;
    }

    @JsonIgnore
    public int getPrev() {
        return this.isFirstPage() ? this.pageNo : this.pageNo - 1;
    }

    @JsonIgnore
    public int getNext() {
        return this.isLastPage() ? this.pageNo : this.pageNo + 1;
    }

    public List<T> getList() {
        return this.list;
    }

    public Page<T> setList(List<T> list) {
        this.list = list;
        this.initialize();
        return this;
    }

    @JsonIgnore
    public String getOrderBy() {
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|total|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, 2);
        return sqlPattern.matcher(this.orderBy).find() ? "" : this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @JsonIgnore
    public String getFuncName() {
        return this.funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    @JsonIgnore
    public String getFuncParam() {
        return this.funcParam;
    }

    public void setFuncParam(String funcParam) {
        this.funcParam = funcParam;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isDisabled() {
        return this.pageSize == -1;
    }

    @JsonIgnore
    public boolean isNotTotal() {
        return this.total == -1L;
    }

    public int getFirstResult() {
        int firstResult = (this.getPageNo() - 1) * this.getPageSize();
        if ((long) firstResult >= this.getTotal()) {
            firstResult = 0;
        }

        return firstResult;
    }

    public int getMaxResults() {
        return this.getPageSize();
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public static final <T> Page<T> emptyPage() {
        return new Page();
    }
}

