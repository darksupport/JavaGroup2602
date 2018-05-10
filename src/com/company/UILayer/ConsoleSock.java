package com.company.UILayer;

import com.company.ModelLayer.ISearchManager;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SearchForFileDAO.*;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.ISock;

import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.List;

/**
 * Created by 1111 on 05.04.2018.
 */
public class ConsoleSock implements IUISock {

    ISockModel sockModel;
    Scanner scn;
    public ConsoleSock(ISockModel sockModel)
    {
        this.sockModel = sockModel;
        scn = new Scanner(System.in);
    }

    private static String getMainMenuText()
    {
        return "Show all: 0\nAdd new item: 1\nUpdate item: 2\n"
                + "Delete item: 3\nSearchForFileDAO : 4\nExit : 5\nPlease choice option: ";
    }

    @Override
    public ISock getSockFromUser() throws NoSuchFieldException {
        SockData result = new SockData();
        System.out.println("Please enter new sockData.");
        System.out.print("Type: ");
        result.setType(validateAndReenter("type", scn.nextLine()));
        System.out.print("Size: ");
        result.setSize(Integer.parseInt(validateAndReenter("size", scn.nextLine())));
        System.out.print("Color: ");
        result.setColor(validateAndReenter("color", scn.nextLine()));

        return result;
    }

    private String validateAndReenter(String fieldName, String value) throws NoSuchFieldException {
        while (!BaseValidator.validateSockField(fieldName,value))
        {
            System.out.println("Please reenter value: ");
            value = scn.nextLine();
        }
        return value;
    }
    private String validateAndReenter(Type type, String value) {
        while (!BaseValidator.validateField(type.getTypeName(),value))
        {
            System.out.println("Please reenter value: ");
            value = scn.nextLine();
        }
        return value;
    }


    @Override
    public void showSock(ISock sock) {
        System.out.println(sock.toString());
    }

    @Override
    public void showSock(List<ISock> socks) {
        for (ISock sock: socks) {
            showSock(sock);
        }
    }
    @Override
    public ISock updateSock(ISock sock)
    {
        System.out.println("Data to change:");
        System.out.println("Field 1: " + sock.getType());
        System.out.println("Field 2: " + sock.getColor());
        System.out.println("Field 3: " + sock.getSize());
        System.out.println("Press 0 for exit");
        boolean continueEdit = true;
        while (continueEdit) {
            System.out.println("Please input field number for change:");

            Integer fieldIndex = Integer.parseInt(validateAndReenter(Integer.TYPE,scn.nextLine()));
            System.out.println("Please input new value:");
            String newValue = scn.nextLine();

            if (fieldIndex == 0) {
                return sock;
            }
            if (fieldIndex == 1) {
                sock.setType(newValue);
            }
            if (fieldIndex == 2) {
                sock.setColor(newValue);
            }
            if (fieldIndex == 3) {
                sock.setSize(Integer.parseInt(newValue));
            }
        }
        return  null;
    }

    @Override
    public void deleteSock()
    {
        showSock(sockModel.getAllSocks());
        System.out.println("Please enter sock number for delete: ");
        int id = Integer.parseInt(scn.nextLine());
        if (sockModel.deleteSock(id))
        {
            System.out.println("Removed.");
        }
        else
        {
            System.out.println("Removing error.");
        }
    }

    private void sockUpdate(int id)
    {
        ISock sock = sockModel.getSockById(id);
        sock = updateSock(sock);
        sockModel.updateSock(sock);
    }

    @Override
    public void mainMenu()
    {
       boolean continu = true;
       while(continu) {
           System.out.println(getMainMenuText());
           Integer res = Integer.parseInt(scn.nextLine());
           switch (res) {
               case 0:
                   showSock(sockModel.getAllSocks());
                   break;
               case 1:
                   try {
                       ISock newSock = getSockFromUser();
                       sockModel.addSock(newSock);
                     }
                     catch (NoSuchFieldException ex)
                    {
                        System.out.println("System critical error;");
                        return;
                    }
                   break;
               case 2:
                   showSock(sockModel.getAllSocks());
                   System.out.println("Please enter sock number: ");
                   Integer sockId = Integer.parseInt(scn.nextLine());
                   sockUpdate(sockId);
                   break;
               case 3:
                   deleteSock();
                   break;
               case 4:
                   ISearchManager manager = new SearchManager(sockModel.getAllSocks());
                   System.out.println("Please enter serach field:");
                   String fieldName = scn.nextLine();
                   System.out.println("Please enter serach value:");
                   String searchValue = scn.nextLine();
                   showSock(manager.search(fieldName,searchValue));
                   break;
               case  5:
                   continu = false;
                   break;
           }
       }
    }
}
