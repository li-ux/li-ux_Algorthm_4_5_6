package com.example.li_ux_algorthm_4_5_6.bean;

public class circle extends Shape{
    private int semidiameter;

    public circle(int semidiameter) {
        this.semidiameter = semidiameter;
    }

    @Override
    public int calArea() {
        return (int) (this.semidiameter * this.semidiameter * 3.14);
    }
}
