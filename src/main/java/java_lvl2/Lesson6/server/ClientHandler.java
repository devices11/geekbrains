package java_lvl2.Lesson6.server;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ServerMain server;

    public ClientHandler(final ServerMain server, final Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            /** Тред лисенер входящего потока */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            System.out.println("Client: " + str);
                        }
                    } catch (SocketException e) {
                        System.err.println("The client socket is closed!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            /** Тред с отправкой сообщения в исходящий поток */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        while (true) {
                            String str = reader.readLine();
                            server.broadcastMsg(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Метод отправки в исходящий поток сообщения
     * @param str текст сообщения
     */
    public void sendMsg(String str) {
        try {
            out.writeUTF(str);


        } catch (SocketException e) {
            System.err.println("No connected clients!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
