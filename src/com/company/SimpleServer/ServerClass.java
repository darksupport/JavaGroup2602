package com.company.SimpleServer;

import com.company.ModelLayer.ISockModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class ServerClass implements Runnable{

    ServerSocket listener;
    ISockModel model;
    boolean enabled = true;

    public ServerClass(int port, ISockModel model) throws IOException {
        this.listener = new ServerSocket(port);
        this.model = model;
    }

    @Override
    public void run() {
        try {
            while (enabled)
            {
                Socket socket = listener.accept();
                System.out.println("New client conected" + socket.getInetAddress());
                ConnectionHandler connect = new ConnectionHandler(socket,this.model);
                Thread thr = new Thread(connect);
                thr.start();
                //----- invoke handler method
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
