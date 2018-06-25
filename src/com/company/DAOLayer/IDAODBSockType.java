package com.company.DAOLayer;

import com.company.ModelLayer.SockTypeModel.ISockType;
import com.company.ModelLayer.SockTypeModel.SockType;

import java.util.List;

/**
 * Created by Brainacad4 on 18.06.2018.
 */
public interface IDAODBSockType {

    ISockType getById(int id);
    List<SockType> getAllSockTypes();
    int addSockType(ISockType type);
    ISockType updateSockType(ISockType changedType);
    boolean deactivateSockType(int id);
}
