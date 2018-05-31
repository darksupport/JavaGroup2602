package com.company.ModelLayer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Brainacad4 on 23.04.2018.
 */
@WebService
public interface ISockModel {
   @WebMethod List<ISock> getAllSocks();

   @WebMethod  void addSock(ISock sock);

   @WebMethod  ISock updateSock(ISock sock);

   @WebMethod boolean deleteSock(int id);

   @WebMethod  ISock getSockById(int id);

   @WebMethod  List<ISock> getSockByCondition(String fieldName, String condition, String value);
   @WebMethod  List<ISock> findBy(Object findValue,String fieldName);
}
