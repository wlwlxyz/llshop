package com.wl.llshop.common.dto;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 20:21
 * Version:V1.0
 */
public class TreeNode {
    private Long id;
    private String text;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
