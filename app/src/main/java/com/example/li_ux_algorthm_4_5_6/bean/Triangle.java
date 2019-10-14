package com.example.li_ux_algorthm_4_5_6.bean;

public class Triangle extends Shape {
    private int height;
    private int width;

    public Triangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int calArea() {
        return (this.height * this.width)>>1;
    }
}
