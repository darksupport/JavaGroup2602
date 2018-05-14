package com.company.ModelLayer;

/**
 * Created by 1111 on 05.04.2018.
 */
public interface ISock extends Comparable {

    void setType(String type);
    void setSize(int size);
    void setColor(String color);
    void setOwner(IOwnerData owner);

    String getType();
    int getSize();
    String getColor();
    int getId();
    IOwnerData getOwner();
}
