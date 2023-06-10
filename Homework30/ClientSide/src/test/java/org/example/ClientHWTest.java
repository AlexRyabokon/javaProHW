package org.example;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientHWTest {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 3345;

    private ClientHW client;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Scanner scanner;

    @BeforeEach
    public void setUp() throws IOException {
        client = new ClientHW();
        socket = mock(Socket.class);
        reader = mock(BufferedReader.class);
        writer = mock(PrintWriter.class);
        scanner = new Scanner(System.in);

        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("Server message".getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

        client.socket = socket;
        client.reader = reader;
        client.writer = writer;
        client.scanner = scanner;
    }

    @Test
    public void testStart() throws IOException {
        when(reader.readLine()).thenReturn("Server message").thenReturn(null);

        assertDoesNotThrow(() -> client.start());

        verify(socket).close();
        verify(writer).println(anyString());
        verify(reader, times(2)).readLine();
    }

    @Test
    public void testHandleServerMessages() throws IOException {
        when(reader.readLine()).thenReturn("Server message").thenReturn(null);

        assertDoesNotThrow(() -> client.handleServerMessages());

        verify(reader, times(2)).readLine();
    }
}