package com.company.ModelLayer;

/**
 * Created by Brainacad4 on 18.06.2018.
 */
public class SockType implements ISockType {

    int id;
    String name;
    boolean active;
    public SockType()
    {
        this.id = -1;
        this.name = "";
        this.active = true;
    }

    public SockType(String name)
    {
        this.id = -1;
        this.name = name;
        this.active = true;
    }

    public SockType(int id, String name, boolean active)
    {
        this.id = id;
        this.name = name;
        this.active = active;
    }
    @Override
    public int getSockTypeId() {
        return id;
    }

    @Override
    public String getSockTypeName() {
        return name;
    }

    @Override
    public void setSockTypeName(String name) {
        this.name =name;
    }

    @Override
    public boolean getActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
