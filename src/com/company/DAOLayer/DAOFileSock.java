package com.company.DAOLayer;

import com.company.ModelLayer.ISock;
import com.company.ModelLayer.SockData;
import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public class DAOFileSock implements IDAOSock {

    List<ISock> sockCollection;
    Path path ;
    public  DAOFileSock() throws IOException {
        path = Paths.get("testDataFile.txt");
        if (!Files.exists(path))
        {
          Files.createFile(path);
        }
        List<String> data =  Files.readAllLines(path);
        sockCollection = new ArrayList<>();
        readSock(data);
    }

    int getNewId()
    {
        return sockCollection.size()==0 ? 0 :
                sockCollection.get(sockCollection.size() - 1).getId()+1;
    }

    boolean writeData()
    {
        try {
            List<String> stringSockData = new ArrayList<>();
            for (ISock sock: sockCollection) {
              stringSockData.add(sock.toString());
            }
            Files.write(path,stringSockData);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public int addSock(ISock sock) {
        if (sock.getId()<0)
        {
           ISock newSock = new SockData(getNewId(),sock);
            sockCollection.add(newSock);
        }
        writeData();
        return sock.getId();
    }

    @Override
    public int [] addSock(ISock[] sock) {
        int [] result = new int[sock.length];
        int i =0;
        for (ISock element:sock) {
           result[i] =  addSock(element);i++;
        }
        return result;
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

    @Override
    public List<ISock> getSockCollection() {
        return sockCollection;
    }

    private List<ISock> readSock(List<String> data) {
        for (String str:data) {
            ISock sock = stringToSock(str);
            sockCollection.add(sock);
        }
        sockCollection.sort(new Comparator<ISock>() {
            @Override
            public int compare(ISock o1, ISock o2) {
                return o1.compareTo(o2);
            }
        });
        return sockCollection;
    }

    @Override
    public ISock readSock(int id) {
        ISock result = null;
        for (ISock sock: sockCollection) {
            if (sock.getId() == id )
            {
                result = sock;
                break;
            }
        }
        return result;
    }

    @Override
    public List<ISock> getSockByCondition(String field, String condition, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateSock(ISock changedSock) {
       ISock oldSock = readSock(changedSock.getId());
       if (null == oldSock)
       {
           return  false;
       }
       int index = sockCollection.indexOf(oldSock);
       sockCollection.remove(oldSock);
       sockCollection.add(index,changedSock);
       writeData();
       return  true;
    }

    @Override
    public boolean deleteSock(int id)
    {
        ISock deleteSock = readSock(id);
        if (null == deleteSock)
        {
            return  false;
        }
        sockCollection.remove(deleteSock);
        writeData();
        return  true;
    }

    @Override
    public boolean deleteSock(int[] id) {
        return false;
    }
}
