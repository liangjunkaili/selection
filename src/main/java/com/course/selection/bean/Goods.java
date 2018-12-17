package com.course.selection.bean;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:12 AM
 * @Version 1.0
 **/
public class Goods {
    private int id;
    private String img;
    private String title;
    private String intro;
    private String label;
    private int price;//单位为分，都为整数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
