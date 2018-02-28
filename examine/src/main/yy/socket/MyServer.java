package yy.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author XieLongZhen
 * @time 2018/2/27 20:36
 */
public class MyServer {
    public static void main(String[] args) {

        MyServer myServer = new MyServer();

        myServer.receiveFile();

    }



    public void receiveFile() {

        Socket clientSocket = null;

        InputStream inputStream = null;

        FileOutputStream fileOutputStream = null;

        // 定义缓冲区

        byte[] buffer = new byte[1024];

        try {

            ServerSocket serverSocket = new ServerSocket(10000);

            clientSocket = serverSocket.accept();

            inputStream = clientSocket.getInputStream();

            fileOutputStream = new FileOutputStream("/tmp/dst.data");

            int length;

            while ((length = inputStream.read(buffer, 0, buffer.length)) > 0) {

                fileOutputStream.write(buffer, 0, length);

                fileOutputStream.flush();

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (inputStream != null) {

                try {

                    inputStream.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            if (fileOutputStream != null) {

                try {

                    fileOutputStream.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            if (clientSocket != null &&clientSocket.isConnected()) {

                try {

                    clientSocket.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }
}
