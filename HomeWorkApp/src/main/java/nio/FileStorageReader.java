package nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileStorageReader implements ObjectStorageReader {
    private final FileStorage fileStorage;

    public FileStorageReader(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    @Override
    public byte[] read(String namespace, String name) throws Exception {
        Path filePath = fileStorage.get(namespace, name);

        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(buffer);
            return buffer.array();
        }
    }

    @Override
    public List<byte[]> read(String namespace, String name, int chunkSize) throws Exception {
        Path filePath = fileStorage.get(namespace, name);

        List<byte[]> chunks = new ArrayList<>();
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(chunkSize);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                byte[] chunk = new byte[buffer.remaining()];
                buffer.get(chunk);
                chunks.add(chunk);
                buffer.clear();
            }
        }
        return chunks;
    }
}

