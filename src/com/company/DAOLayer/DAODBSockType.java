package com.company.DAOLayer;

import com.company.ModelLayer.ISockType;
import com.company.ModelLayer.SockType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brainacad4 on 18.06.2018.
 */
public class DAODBSockType implements IDAODBSockType {

    private Connection con;
    private PreparedStatement pstm;

    private static String selectIdByTypeName = "Select id_sock_types from sockdb.sock_types where type_sock_type = ? limit 1";

    private static String selectIdById = "Select id_sock_types,type_sock_type,type_sock_active from sockdb.sock_types where id_sock_types = ? limit 1";

    private static String insertSockType = "Insert into sockdb.sock_types (type_sock_type, type_sock_active) values (?,?)";

    private static String selectAllRecords = "Select id_sock_types,type_sock_type,type_sock_active from sockdb.sock_types";

    private static String updateSockType = "Update sockdb.sock_types SET type_sock_type = ? ,type_sock_active = ? where id_sock_types = ?";

    public DAODBSockType(Connection con)
    {
        this.con = con;
    }

    private int getByName(String name)
    {
        ResultSet rs = null;
        int result = -1;
        try {
            pstm = con.prepareStatement(selectIdByTypeName);
            pstm.setString(1,name);
            rs = pstm.executeQuery();
            if (rs.next())
            {
                result = rs.getInt(1);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("getByName(String type) error." + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            DBTools.CloseResult(rs);
            return  result;
        }
    }

    SockType convertFromRS(ResultSet rs) throws SQLException {
        SockType result = null;
            int type_id = rs.getInt(1);
            String name = rs.getString(2);
            boolean active = rs.getBoolean(3);
            result = new SockType(type_id,name,active);
        return  result;
    }

    @Override
    public ISockType getById(int id) {
        ResultSet rs = null;
        ISockType result = null;
        try {
            pstm = con.prepareStatement(selectIdById);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            if (rs.next())
            {
                result = convertFromRS(rs);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("getByName(String type) error." + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            DBTools.CloseResult(rs);
            return  result;
        }
    }

    @Override
    public List<SockType> getAllSockTypes() {
        ResultSet rs = null;
        List<SockType> result = new ArrayList<>();

        try {
            pstm = con.prepareStatement(selectAllRecords);
            rs = pstm.executeQuery();
            while (rs.next())
            {
              result.add(convertFromRS(rs));
            }
        }
        catch (SQLException ex)
        {
            System.out.println("getByName(String type) error." + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            DBTools.CloseResult(rs);
            return  result;
        }
    }

    @Override
    public int addSockType(ISockType type) {
        int resultId = -1;
        try
        {
            pstm = con.prepareStatement(insertSockType);
            pstm.setString(1,type.getSockTypeName());
            pstm.setBoolean(2, type.getActive());
            pstm.executeUpdate();
            resultId = getByName(type.getSockTypeName());
        }
        catch (SQLException ex)
        {
            System.out.println("addSockType(String type) error" + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            return  resultId;
        }
    }

    @Override
    public ISockType updateSockType(ISockType changedType) {
        ISockType result = null;
        try
        {
            pstm = con.prepareStatement(updateSockType);
            pstm.setString(1,changedType.getSockTypeName());
            pstm.setBoolean(2, changedType.getActive());
            pstm.setInt(3,changedType.getSockTypeId());
            pstm.executeUpdate();
            result= getById(changedType.getSockTypeId());
        }
        catch (SQLException ex)
        {
            System.out.println("updateSockType error" + ex.getMessage());
        }
        finally {
            DBTools.CloseStatment(pstm);
            return  result;
        }
    }

    @Override
    public boolean deactivateSockType(int id) {
        ISockType type = getById(id);
        type.setActive(false);
        return  (updateSockType(type) != null );
    }
}
