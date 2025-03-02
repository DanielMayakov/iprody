package nio;

import java.io.IOException;
import java.nio.file.*;

public class FileStorage implements ObjectStorage<Path> {
    private final Path rootDirectory;

    public FileStorage(String rootDirectory) {
        this.rootDirectory = Paths.get(rootDirectory);
        if (!Files.exists(this.rootDirectory)) {
            try {
                Files.createDirectories(this.rootDirectory);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create root directory: " + rootDirectory, e);
            }
        }
    }

    @Override
    public void put(String namespace, String name, Path object) throws IOException {
        Path namespacePath = rootDirectory.resolve(namespace);
        if (!Files.exists(namespacePath)) {
            Files.createDirectories(namespacePath);
        }

        Path destination = namespacePath.resolve(name);
        Files.copy(object, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public Path get(String namespace, String name) throws ObjectNotFoundException {
        Path filePath = rootDirectory.resolve(namespace).resolve(name);
        if (!Files.exists(filePath)) {
            throw new ObjectNotFoundException("File not found: " + filePath.toString());
        }
        return filePath;
    }
}

