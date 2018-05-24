package com.company.SimpleServer;

import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class StringModelFacade {

    ISockModel model;

    public StringModelFacade(ISockModel model)
    {
        this.model = model;
    }

    public String getAllSocks()
    {
        StringBuilder result = new StringBuilder("");
        for (ISock sock:model.getAllSocks()) {
           result.append("#" + sock.toString());
        }
        return result.toString();
    }

    public void addSock(String sockStr)
    {
        ISock sock = stringToSock(sockStr);
        model.addSock(sock);
    }

    ISock stringToSock(String str)
    {
        String []fields = str.split("\\|");
        int id = Integer.parseInt(fields[0]);
        String type = fields[1];
        String color = fields[2];
        int size = Integer.parseInt( fields[3]);
        return new SockData(type,color,size,id,null);
    }
}
