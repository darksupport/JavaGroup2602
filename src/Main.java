import com.company.DAOLayer.*;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.ISockTypeModel;
import com.company.ModelLayer.SockModel;
import com.company.ModelLayer.SockTypeModel;

import javax.xml.ws.Endpoint;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
try {
    Connection con = DBTools.getConnection("localhost",3306,"root","1111");
    IDAODBOwner daoOwner = new DAODBOwner(con);
    IDAODBSockType daoSockType = new DAODBSockType(con);
    IDAOSock daoObject = new DAODBSock(con, daoOwner,daoSockType);
     ISockModel model = new SockModel(daoObject);
    ISockTypeModel sockTypeModel = new SockTypeModel(daoSockType);
     Endpoint.publish("http://localhost:8080/ws/sock",model);
     Endpoint.publish("http://localhost:8080/ws/socktype",sockTypeModel);
    }
    catch (SQLException ex)
    {
        System.out.println("Data read exception." + ex.getMessage());
    }

    }
}
