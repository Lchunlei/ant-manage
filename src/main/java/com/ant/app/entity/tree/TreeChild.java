package com.ant.app.entity.tree;

public class TreeChild {
    private Integer id;
    private String text;
    private String iconCls;
    private Boolean checked;

    public TreeChild() {
    }

    public TreeChild(Integer id, String text, String iconCls, Boolean checked) {
        this.id = id;
        this.text = text;
        this.iconCls = iconCls;
        this.checked = checked;
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

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
