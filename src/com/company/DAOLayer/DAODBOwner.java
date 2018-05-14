package com.company.DAOLayer;

import com.company.ModelLayer.IOwnerData;
import com.company.ModelLayer.OwnerData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Brainacad4 on 14.05.2018.
 */
public class DAODBOwner implements IDAODBOwner {

    String selectOwnerById = "SELECT id_owner,name_owner,sex_owner," +
            "age_owner,legsize_owner FROM sockdb.owner WHERE id_owner = ?";

    private Connection con;
    private PreparedStatement ps;

    public DAODBOwner(Connection con)
    {
       this.con = con;
    }


    private IOwnerData readFromResultSet(ResultSet rs) throws SQLException {
        if(rs.next())
        {
           int id = rs.getInt(1);
           String name = rs.getString(2);
           String sex = rs.getString(3);
           int age = rs.getInt(4);
           int legSize = rs.getInt(5);
           return new OwnerData(id,name,legSize,age,sex);
        }
        return null;
    }

    @Override
    public IOwnerData getOwnerById(int id)
    {
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(selectOwnerById);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            return readFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBTools.CloseStatment(ps);
        }
        return null;
    }


}
