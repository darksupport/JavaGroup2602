package com.company.ModelLayer;

import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.SearchForFileDAO.SearchManager;

import java.sql.SQLException;
import java.util.List;

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
    public void addSock(ISock sock)
    {
        sockDao.addSock(sock);
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

    @Override
    public List<ISock> getSockByCondition(String fieldName, String condition, String value) {
        try {
            return sockDao.getSockByCondition(fieldName, condition, value);
        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public List<ISock> findBy(Object findValue,String fieldName)
    {
        List<ISock> allSocks = getAllSocks();
        SearchManager searchManager = new SearchManager(allSocks);
        return searchManager.search(fieldName,findValue);
    }
}
