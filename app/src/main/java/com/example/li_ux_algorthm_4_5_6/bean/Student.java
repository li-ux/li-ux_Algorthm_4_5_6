package com.example.li_ux_algorthm_4_5_6.bean;

public class Student implements Comparable{
    private int id;
    private String name;
    private int age;
    private int score;

    public Student(int id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score){this.score = score;}

    public int getScore(){return this.score;}

    public int compareTo(Object obj){
        Student stu = (Student)obj;
        return stu.id - this.id == 0 ? stu.age - this.age: stu.id - this.id;
    }
}

