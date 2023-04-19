package filenavigator;

import java.util.Objects;

public class FileData {

    private String name;
    private long size;
    private String path;

    public FileData(String name, long size, String path) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.size = size < 0  ? 0 : size;
        this.path = Objects.requireNonNull(path, "Path cannot be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
