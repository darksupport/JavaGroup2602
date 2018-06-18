package com.company.DAOLayer;

import com.company.ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brainacad4 on 10.05.2018.
 */
public class DAODBSock implements IDAOSock {

       private static String selectAllSocksQuery = "Select id_socks,color_socks,size_socks,type_socks,owner_socks,name_owner \n" +
            "FROM sockdb.socks \n" +
            //"left join sockdb.sock_types ON sock_types.id_sock_types = socks.type_socks \n" +
               "left join sockdb.owner ON socks.owner_socks = owner.id_owner ";

    private static String insertSockQuery = "Insert into sockdb.socks \n" +
            "(color_socks,size_socks,type_socks) \n" +
            "values (?,?,?)";


    private static String updateSock = "Update sockdb.socks SET color_socks = ?, size_socks =? , socks.type_socks = ?, socks.owner_socks =? WHERE socks.id_socks = ?";

    private  Connection con;
    PreparedStatement pstm;
    IDAODBOwner daoOwner;
    IDAODBSockType daoSockType;

    public DAODBSock(Connection con, IDAODBOwner daoOwner, IDAODBSockType daoSockType) throws SQLException {
       this.con = con;
       this.daoOwner = daoOwner;
       this.daoSockType = daoSockType;
    }

    @Override
    public int addSock(ISock sock) {
        try {
            pstm = con.prepareStatement(insertSockQuery);
            pstm.setString(1,sock.getColor());
            pstm.setInt(2,sock.getSize());
            pstm.setInt(3,sock.getType().getSockTypeId());
            return pstm.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(" addSock(ISock sock) error" + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
        }
        return -1;
    }

    @Override
    public int[] addSock(ISock[] sock) {
        return new int[0];
    }

    @Override
    public List<ISock> getSockCollection() {
        List<ISock> result = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectAllSocksQuery);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                result.add(convertFromResultSet(rs));
            }
        }
        catch (SQLException ex)
        {
            System.out.println("getSockCollection() error." + ex.getMessage());
        }
        finally {
            DBTools.CloseResult(rs);
            DBTools.CloseStatment(pstm);
            return result;
        }

    }

    private ISock convertFromResultSet(ResultSet rs) throws SQLException
    {
        int result_id = rs.getInt(1);
        String colorSock = rs.getString(2);
        int sizeSock = rs.getInt(3);
        int idTypeSock = rs.getInt(4);
        int idOwner = rs.getInt(5);
        IOwnerData owner = daoOwner.getOwnerById(idOwner);
        ISockType type = daoSockType.getById(idTypeSock);
        return new SockData((SockType) type, colorSock, sizeSock, result_id,(OwnerData) owner);
    }



    @Override
    public ISock readSock(int id) {
        ISock result = null;
        ResultSet rs = null;
        String queryWithCondition = selectAllSocksQuery + "WHERE id_socks = ?";
        try {
            pstm = con.prepareStatement(queryWithCondition);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            if(rs.next())
            {
              result = convertFromResultSet(rs);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ReadSock(int id) error." + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            DBTools.CloseResult(rs);
            return  result;
        }
    }

    @Override
    public List<ISock> getSockByCondition(String field, String condition, Object value) throws SQLException {
       String query = selectAllSocksQuery + " WHERE " + field + " " + condition + " ?";
       List<ISock> result = new ArrayList<>();
       pstm = con.prepareStatement(query);
       pstm.setObject(1,value);
       ResultSet rs = pstm.executeQuery();
       while (rs.next())
       {
          result.add(convertFromResultSet(rs));
       }
       return result;
    }

    @Override
    public boolean updateSock(ISock changedSock)  {
        try {
            pstm = con.prepareStatement(updateSock);
            pstm.setString(1, changedSock.getColor());
            pstm.setInt(2, changedSock.getSize());
            pstm.setInt(3, changedSock.getType().getSockTypeId());
            pstm.setInt(4, changedSock.getOwner().getId());
            pstm.setInt(5, changedSock.getId());
            pstm.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("updateSock(ISock changedSock) error." + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
        }
        return false;
    }

    @Override
    public boolean deleteSock(int id) {
        return false;
    }

    @Override
    public boolean deleteSock(int[] id) {
        return false;
    }
}
