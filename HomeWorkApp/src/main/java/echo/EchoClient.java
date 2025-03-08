package echo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost"; // Адрес сервера
        int port = 7; // Порт сервера

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Подключено к серверу: " + host + ":" + port);

            // Потоки для чтения и записи
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Thread sendThread = getThread(socket);
            sendThread.start();

            // Чтение сообщений от сервера
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Сообщение от сервера: " + inputLine);
            }

        } catch (IOException e) {
            System.out.println("Ошибка в работе клиента: " + e.getMessage());
        }
    }

    private static Thread getThread(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Отдельный поток для отправки сообщений с клиента
        // Отправляем сообщение серверу
        return new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.print("Введите сообщение для сервера: ");
                    String message = scanner.nextLine();
                    out.println(message); // Отправляем сообщение серверу
                }
            } catch (Exception e) {
                System.out.println("Ошибка при отправке сообщения: " + e.getMessage());
            }
        });
    }
}
