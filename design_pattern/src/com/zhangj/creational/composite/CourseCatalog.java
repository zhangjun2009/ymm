package com.zhangj.creational.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;

    }

    @Override
    public void add(CatalogComponent catalogCompent) {
        items.add(catalogCompent);
    }


    @Override
    public void remove(CatalogComponent catalogCompent) {
        items.remove(catalogCompent);
    }

    @Override
    public void print() {
        for (CatalogComponent catalogComponent : items) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
            }
            catalogComponent.print();
        }
    }
}
