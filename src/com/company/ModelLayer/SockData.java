package com.company.ModelLayer;

import com.company.ModelLayer.SockTypeModel.SockType;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by 1111 on 05.04.2018.
 */
public class SockData implements ISock,Comparable {

    @XmlTransient
   public SockType type;
    @XmlTransient
   public String color;
    @XmlTransient
    public int size;
    @XmlTransient
    public  int id;
    @XmlTransient
    public OwnerData owner;


    public OwnerData getOwner() {
        return owner;
    }

    public void setOwner(OwnerData owner) {
        this.owner = owner;
    }

    public  SockData()
    {
        this.type = new SockType();
        this.color = "";
        this.size = 0;
        this.id = -1;
    }

    public  SockData(SockType type, String color, int size, OwnerData owner)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = -1;
        this.owner = owner;
    }

    public  SockData(SockType type, String color, int size, int id, OwnerData owner)
    {
        this.type = type;
        this.color = color;
        this.size = size;
        this.id = id;
        this.owner = owner;
    }

    public  SockData(int id, ISock sock)
        {
        this.type = sock.getType();
        this.color = sock.getColor();
        this.size = sock.getSize();
        this.owner = sock.getOwner();
        this.id = id;
    }

    @Override
    public void setType(SockType type) {
        this.type = type;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public SockType getType() {
        return this.type;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.id);
        sb.append("|" + this.type.getSockTypeName());
        sb.append("|" + this.color);
        sb.append("|" + this.size);
        if (null != owner) {
            sb.append("|" + this.owner.getName());
        }
        return  sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof ISock)
        {
            if (this.getId() > ((ISock)o).getId()) return  1;
            if (this.getId() < ((ISock)o).getId()) return  -1;
        }
        return 0;
    }

}
