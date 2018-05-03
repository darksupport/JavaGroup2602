package com.company.UILayer;

import com.company.ModelLayer.ISock;

import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public interface IUISock {

    ISock getSockFromUser() throws NoSuchFieldException;
    void showSock(ISock sock);
    void showSock(List<ISock> socks);
    ISock updateSock(ISock sock);
    void deleteSock();
    void mainMenu();
}
