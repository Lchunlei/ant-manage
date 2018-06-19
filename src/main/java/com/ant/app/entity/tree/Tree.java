package com.ant.app.entity.tree;

import java.util.List;

public class Tree {
    private Integer id;
    private String text;
    private String iconCls;
    private List<TreeChild> children;

    public Tree() {
    }

    public Tree(Integer id, String text, String iconCls, List<TreeChild> children) {
        this.id = id;
        this.text = text;
        this.iconCls = iconCls;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<TreeChild> getChildren() {
        return children;
    }

    public void setChildren(List<TreeChild> children) {
        this.children = children;
    }
}
