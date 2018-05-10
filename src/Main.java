import com.company.DAOLayer.DAODBSock;
import com.company.DAOLayer.DAOFileSock;
import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.SockModel;
import com.company.UILayer.ConsoleSock;
import com.company.UILayer.IUISock;

import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
try {
     //IDAOSock daoObject = new DAOFileSock();
     IDAOSock daoObject = new DAODBSock("localhost",3306,"root","1111");
     ISockModel model = new SockModel(daoObject);
     IUISock socInput = new ConsoleSock(model);
      socInput.mainMenu();
    }
    catch (SQLException ex)
    {
        System.out.println("Data read exception." + ex.getMessage());
    }

    }
}
