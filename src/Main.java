import com.company.DAOLayer.*;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.SockModel;
import com.company.SimpleServer.ServerClass;
import com.company.UILayer.ConsoleSock;
import com.company.UILayer.IUISock;
import com.company.WebService.SockServiceImpl;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
try {
    Connection con = DBTools.getConnection("localhost",3306,"root","1111");
    IDAODBOwner daoOwner = new DAODBOwner(con);
    IDAOSock daoObject = new DAODBSock(con, daoOwner);
     ISockModel model = new SockModel(daoObject);
     Endpoint.publish("http://localhost:8080/ws/sock",model);
    }
    catch (SQLException ex)
    {
        System.out.println("Data read exception." + ex.getMessage());
    }

    }
}
