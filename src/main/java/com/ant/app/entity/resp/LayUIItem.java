package com.ant.app.entity.resp;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/9/27
 */
public class LayUIItem<T> {
    private List<T> item;

    public List<T> getItem() {
        return item;
    }

    public void setItem(List<T> item) {
        this.item = item;
    }
}
