package com.company.ModelLayer;

/**
 * Created by Brainacad4 on 14.05.2018.
 */
public class OwnerData implements IOwnerData {

    public OwnerData(int id, String name, int leg_size, int age, String sex) {
        this.id = id;
        this.name = name;
        this.leg_size = leg_size;
        this.age = age;
        this.sex = sex;
    }

    public OwnerData() {
        this.id = -1;
        this.name = "";
        this.leg_size = 0;
        this.age = 0;
        this.sex = "";
    }

    public OwnerData( String name, int leg_size, int age, String sex) {
        this.id = -1;
        this.name = name;
        this.leg_size = leg_size;
        this.age = age;
        this.sex = sex;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLeg_size() {
        return leg_size;
    }

    @Override
    public void setLeg_size(int leg_size) {
        this.leg_size = leg_size;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    private int id;
    private String name;
    private int leg_size;
    private int age;
    private String sex;


}
