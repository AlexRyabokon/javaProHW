package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class ClientHW {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 3345;
    private static final Logger LOGGER = Logger.getLogger(ClientHW.class.getName());


Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    Scanner scanner;


    public static void main(String[] args) {
        ClientHW client = new ClientHW();
        client.start();

    }

    public ClientHW() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            LOGGER.info("Connected to server.");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            Thread messageThread = new Thread(this::handleServerMessages);
            messageThread.start();

            while (true) {
                String input = scanner.nextLine();
                writer.println(input);

                if (input.equals("-exit")) {
                    break;
                }
            }

            socket.close();
            LOGGER.info("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void handleServerMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                LOGGER.info(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
