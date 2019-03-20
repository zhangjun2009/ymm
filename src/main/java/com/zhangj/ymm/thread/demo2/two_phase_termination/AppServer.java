package com.zhangj.ymm.thread.demo2.two_phase_termination;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangj
 * @date 2019/3/18
 */
public class AppServer extends Thread {
    private final int port;
    private final static int DEFAULT_PORT = 12272;
    private volatile boolean start = true;
    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private final static ExecutorService executor = Executors.newFixedThreadPool(10);
    private ServerSocket server;

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(port);
            while (start) {
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                executor.submit(clientHandler);
                clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        this.clientHandlers.stream().forEach(ClientHandler::stop);
        this.executor.shutdown();
    }

    public void shutDown() throws IOException {
        this.start = false;
        this.interrupt();
        this.server.close();
    }
}
