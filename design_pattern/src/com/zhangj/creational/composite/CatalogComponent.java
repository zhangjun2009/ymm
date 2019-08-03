package com.zhangj.creational.composite;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogCompent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(CatalogComponent catalogCompent){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }


    public double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }


    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }
}
