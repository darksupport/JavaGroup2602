import com.company.DAOLayer.DAOFileSock;
import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;
import com.company.ModelLayer.SockModel;
import com.company.UILayer.ConsoleSock;
import com.company.UILayer.IUISock;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
try {
     IDAOSock daoObject = new DAOFileSock();
     ISockModel model = new SockModel(daoObject);
     IUISock socInput = new ConsoleSock(model);
      socInput.mainMenu();
    }catch (IOException ex)
    {
        System.out.println("Data read exception.");
    }

    }
}
