package com.company.ModelLayer.SockTypeModel;

/**
 * Created by Brainacad4 on 18.06.2018.
 */
public interface ISockType {

    int getSockTypeId();
    String getSockTypeName();
    void setSockTypeName(String name);
    boolean getActive();
    void setActive(boolean active);
}
