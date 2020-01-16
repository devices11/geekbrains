package java_lvl2.Lesson6.client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class ServerHandler {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    String IP_ADPRESS = "localhost";
    int PORT = 8193;


    public void handler() {


        try {
            socket = new Socket(IP_ADPRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            /** Тред лисенер входящего потока */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/clientClosed");
                                break;
                            }
                            System.out.println("Server: " + str);
                        }
                    } catch (SocketException e) {
                        System.err.print("The server is not connected! ");
                        System.out.println("Reconnect...");

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        handler();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            /** Тред отправляющий в поток сообщение */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        while (true) {
                            String str = reader.readLine();
                            sendMsg(str);

                            if (str.equals("/end")) {
                                out.writeUTF("/clientClosed");
                                break;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (ConnectException e) {
            System.err.print("The server is not connected! ");
            System.out.println("Reconnect...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            handler();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
