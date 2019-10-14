package com.example.li_ux_algorthm_4_5_6.bean;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int calArea() {
        return this.height * this.width;
    }
}
