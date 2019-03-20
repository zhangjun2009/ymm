package com.zhangj.ymm.thread.demo2.two_phase_termination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author zhangj
 * @date 2019/3/18
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter pw = new PrintWriter(outputStream)) {
            while (running) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("come from client >" + message + "\n");
                pw.write("echo " + message);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.running = true;
        } finally {
            this.stop();
        }
    }

    public void stop() {
        if (!running) {
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
