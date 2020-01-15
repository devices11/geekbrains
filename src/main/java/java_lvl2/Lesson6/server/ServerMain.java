package java_lvl2.Lesson6.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    ClientHandler clientHandler;
    DataOutputStream out;

    public ServerMain() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8193);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                clientHandler = new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String msg) {
        clientHandler.sendMsg(msg);
    }
}
