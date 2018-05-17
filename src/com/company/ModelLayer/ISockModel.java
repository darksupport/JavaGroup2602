package com.company.ModelLayer;

import java.util.List;

/**
 * Created by Brainacad4 on 23.04.2018.
 */
public interface ISockModel {
    List<ISock> getAllSocks();

    ISock addSock(ISock sock);

    ISock updateSock(ISock sock);

    boolean deleteSock(int id);

    ISock getSockById(int id);

    List<ISock> getSockByCondition(String fieldName, String condition, String value);
}
