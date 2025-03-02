package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр FileStorage
            FileStorage storage = new FileStorage("storage");

            // Добавляем файл в хранилище
            Path sourceFile = Paths.get("example.txt"); // Убедитесь, что файл существует
            storage.put("namespace1", "example.txt", sourceFile);

            // Получаем файл из хранилища
            Path retrievedFile = storage.get("namespace1", "example.txt");
            System.out.println("Retrieved file: " + retrievedFile);

            // Читаем файл целиком через FileStorageReader
            FileStorageReader reader = new FileStorageReader(storage);
            byte[] content = reader.read("namespace1", "example.txt");
            System.out.println("File content: " + new String(content));

            // Читаем файл по частям через FileStorageReader
            int chunkSize = 10; // Размер чанка в байтах
            var chunks = reader.read("namespace1", "example.txt", chunkSize);
            System.out.println("Chunks:");
            for (byte[] chunk : chunks) {
                System.out.println(new String(chunk));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

