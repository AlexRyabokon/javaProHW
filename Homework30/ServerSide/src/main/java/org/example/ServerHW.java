package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ServerHW {
    private static final int PORT = 3345;
    private static final String SERVER_NAME = "Server";
    private static final String CLIENT_NAME = "client-";
    private static final Logger LOGGER = Logger.getLogger(ServerHW.class.getName());

    private List<ClientHandler> clients;

    public static void main(String[] args) {
        ServerHW server = new ServerHW();
        server.start();
    }

    public ServerHW() {
        clients = new ArrayList<>();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            LOGGER.info("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                LOGGER.info("New client connected: " + clientSocket);

                String clientName = generateClientName();
                ClientHandler clientHandler = new ClientHandler(clientName, clientSocket);
                clients.add(clientHandler);
                broadcastMessage("[SERVER] " + clientName + " successfully connected.");

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private String generateClientName() {
        int clientCount = clients.size();
        return CLIENT_NAME + (clientCount + 1);
    }

    private synchronized void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    private synchronized void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    private class ClientHandler implements Runnable {
        private String clientName;
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(String clientName, Socket clientSocket) {
            this.clientName = clientName;
            this.clientSocket = clientSocket;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    if (inputLine.equals("-exit")) {
                        break;
                    }
                    else if(inputLine.equals("-show all")) {
                        LOGGER.info(String.valueOf(clients));
                    } else if (inputLine.startsWith("-file")) {
                        String filePath = inputLine.substring("-file".length()).trim();
                        receiveFile(filePath);
                    } else {
                        LOGGER.info("Received message from " + clientName + ": " + inputLine);
                        broadcastMessage(clientName + ": " + inputLine);
                    }
                }

                LOGGER.info(clientName + " disconnected.");
                removeClient(this);
                broadcastMessage("[SERVER] " + clientName + " disconnected.");

                reader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String message) {
            writer.println(message);
        }

        private void receiveFile(String filePath) throws IOException {
            byte[] buffer = new byte[8192];
            InputStream inputStream = clientSocket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            LOGGER.info("File received: " + filePath);
            sendMessage("[SERVER] File received: " + filePath);
        }
    }
}
