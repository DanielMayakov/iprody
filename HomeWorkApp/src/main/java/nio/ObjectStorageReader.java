package nio;

import java.util.List;

public interface ObjectStorageReader {
    byte[] read(String namespace, String name) throws Exception;
    List<byte[]> read(String namespace, String name, int chunkSize) throws Exception;
}

