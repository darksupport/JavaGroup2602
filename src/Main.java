import com.company.DAOLayer.*;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.SockModel;
import com.company.SimpleServer.ServerClass;
//import com.company.UILayer.ConsoleSock;
//import com.company.UILayer.IUISock;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
try {
    //IDAOSock daoObject = new DAOFileSock();
    Connection con = DBTools.getConnection("localhost",3306,"root","1111");
    IDAODBOwner daoOwner = new DAODBOwner(con);
    IDAOSock daoObject = new DAODBSock(con, daoOwner);
     ISockModel model = new SockModel(daoObject);
     ServerClass server = new ServerClass(7000,model);
     Thread thr = new Thread(server);
     thr.start();
     //IUISock socInput = new ConsoleSock(model);
     // socInput.mainMenu();
    }
    catch (SQLException ex)
    {
        System.out.println("Data read exception." + ex.getMessage());
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

    }
}
