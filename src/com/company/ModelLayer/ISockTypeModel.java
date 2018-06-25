package com.company.ModelLayer;

import com.company.ModelLayer.SockTypeModel.SockType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Brainacad4 on 18.06.2018.
 */
@WebService
public interface ISockTypeModel {
    @WebMethod List<SockType> getAllSockTypes(boolean onlyActive);
    @WebMethod SockType updateSockType(SockType type);
    @WebMethod boolean deleteSockType(int id);
    @WebMethod SockType addSockType(SockType newSockType);
}
