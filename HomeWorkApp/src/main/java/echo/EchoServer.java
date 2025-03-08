package echo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        int port = 7; // Порт для echo-протокола
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ожидает подключения на порту " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился: " + clientSocket.getInetAddress());

            // Потоки для чтения и записи
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Thread sendThread = getThread(clientSocket);
            sendThread.start();

            // Чтение сообщений от клиента
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Сообщение от клиента: " + inputLine);
            }

        } catch (IOException e) {
            System.out.println("Ошибка в работе сервера: " + e.getMessage());
        }
    }

    private static Thread getThread(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Отдельный поток для отправки сообщений с сервера
        // Отправляем сообщение клиенту
        return new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.print("Введите сообщение для клиента: ");
                    String message = scanner.nextLine();
                    out.println(message); // Отправляем сообщение клиенту
                }
            } catch (Exception e) {
                System.out.println("Ошибка при отправке сообщения: " + e.getMessage());
            }
        });
    }
}

