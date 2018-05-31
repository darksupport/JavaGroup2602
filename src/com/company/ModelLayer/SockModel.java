package com.company.ModelLayer;

import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.SearchDBDAO.SearchManager;


import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Brainacad4 on 23.04.2018.
 */
@WebService(endpointInterface = "com.company.ModelLayer.ISockModel")
public class SockModel implements ISockModel {

    IDAOSock sockDao;
    SearchManager searchManager;

    public SockModel(IDAOSock sockDao)
    {
        this.sockDao = sockDao;
        this.searchManager = new SearchManager(this);
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

    @Override
    public List<ISock> findBy(Object findValue,String fieldName)
    {
        return searchManager.search(fieldName,findValue);
    }
}
