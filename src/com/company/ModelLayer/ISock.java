package com.company.ModelLayer;

import com.company.ModelLayer.SockTypeModel.SockType;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by 1111 on 05.04.2018.
 */
@XmlJavaTypeAdapter(SockDataAdapter.class)
public interface ISock extends Comparable {

    void setType(SockType type);
    void setSize(int size);
    void setColor(String color);
  //  void setOwner(IOwnerData owner);

    SockType getType();
    int getSize();
    String getColor();
    int getId();
    OwnerData getOwner();
}
