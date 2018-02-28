package yy.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author XieLongZhen
 * @time 2018/2/27 20:34
 */
public class MyClient {
    public static void main(String[] args) {

        MyClient myClient = new MyClient();

        myClient.sendFile();

    }



    public void sendFile() {

        Socket socket = new Socket();

        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 10000);

        FileInputStream fileInputStream = null;

        OutputStream outputStream = null;

        // 定义缓冲区

        byte[] buffer = new byte[1024];

        try {

            socket.connect(socketAddress);

            fileInputStream = new FileInputStream("/tmp/src.data");

            outputStream = socket.getOutputStream();

            int length;

            while ((length = fileInputStream.read(buffer, 0, buffer.length)) > 0) {

                outputStream.write(buffer, 0, length);

                outputStream.flush();

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (fileInputStream != null) {

                try {

                    fileInputStream.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            if (outputStream != null) {

                try {

                    outputStream.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            if (socket != null &&socket.isConnected()) {

                try {

                    socket.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }
}
