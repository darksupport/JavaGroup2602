package com.company.ModelLayer;

import com.company.DAOLayer.DAOFileSock;
import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.Search.SearchManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brainacad4 on 23.04.2018.
 */
public class SockModel implements ISockModel {

    IDAOSock sockDao;

    public SockModel(IDAOSock sockDao)
    {
        this.sockDao = sockDao;
    }

    @Override
    public List<ISock> getAllSocks()
    {
        return sockDao.getSockCollection();
    }

    @Override
    public ISock addSock(ISock sock)
    {
        int id = sockDao.addSock(sock);
        return id>0 ? sockDao.readSock(id): null;
    }

    @Override
    public ISock updateSock(ISock sock)
    {
       return sockDao.updateSock(sock) ?
             sockDao.readSock(sock.getId()): null;
    }

    @Override
    public boolean deleteSock(int id)
    {
       return sockDao.deleteSock(id);
    }

    @Override
    public ISock getSockById(int id)
    {
        return sockDao.readSock(id);
    }


    public List<ISock> findBy(Object findValue,String fieldName)
    {
        List<ISock> allSocks = getAllSocks();
        SearchManager searchManager = new SearchManager(allSocks);
        return searchManager.search(fieldName,findValue);
    }
}
