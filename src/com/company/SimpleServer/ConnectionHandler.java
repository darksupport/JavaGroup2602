package com.company.SimpleServer;

        import com.company.ModelLayer.ISockModel;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.Socket;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class ConnectionHandler implements Runnable{

    Socket socket;
    StringModelFacade modelFacade;
    public ConnectionHandler(Socket socket, ISockModel modelFacade)
    {
        this.socket = socket;
        this.modelFacade = new StringModelFacade(modelFacade);
    }


    @Override
    public void run() {
        try {
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            while (socket.isConnected()) {
                String data = reader.readLine();
                if ("showAll".equals(data))
                {
                    pr.println(modelFacade.getAllSocks());
                }
                if ("addNewSock".equals(data)) {
                    String sock = reader.readLine();
                    modelFacade.addSock(sock);
                }
            }
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
