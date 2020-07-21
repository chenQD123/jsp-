package org.TianYa.entity;

import java.util.List;

public class Page {
    // 当前页
    private int currentPage;
    // 页面大小
    private int pageSize;

    // 总数据
    private int totalCount;
    // 总页数
    private int totalPage;
    // 当前页的数据集合
    private List<Favorite> favorites;

    public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Favorite> favorites) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.favorites = favorites;
    }

    public Page() {
        super();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    // 当调用了数据总数的set（）和页面大小set（）时，自动计算出总页数
    // 在servlet里，setTotalCount（）要写在size之前，因为这样才能计算出来countPage的值
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        // 自动计算出
        this.totalPage = this.getTotalCount() % this.getPageSize() == 0 ? this.getTotalCount() / this.getPageSize()
                : this.getTotalCount() / this.getPageSize() + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    // 当调用了数据总数的set（）和页面大小set（）时，自动计算出总页数
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;

    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

}
