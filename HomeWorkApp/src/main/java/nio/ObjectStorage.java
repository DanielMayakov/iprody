package nio;

public interface ObjectStorage<T> {
    void put(String namespace, String name, T object) throws Exception;
    T get(String namespace, String name) throws ObjectNotFoundException;
}
