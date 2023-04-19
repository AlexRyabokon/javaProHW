package filenavigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private Map<String, List<FileData>> files;

    public Map<String, List<FileData>> getFiles() {
        return files;
    }

    public void setFiles(Map<String, List<FileData>> files) {
        this.files = files;
    }

    public FileNavigator() {
        this.files = new HashMap<>();
    }

    public void add(FileData fileData) {
        String path = fileData.getPath();
        if (this.files.containsKey(path)) {
            this.files.get(path).add(fileData);
        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(fileData);
            this.files.put(path, fileList);
        }
    }

    public void addConsist(FileData file) {
        String path = file.getPath();

        boolean found = false;
        for (String key : files.keySet()) {
            if (path.startsWith(key)) {
                List<FileData> fileList = files.get(key);
                fileList.add(file);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("File path does not match any existing paths in the navigator.");
        }
    }

    public List<FileData> find(String path) {
        if (this.files.containsKey(path)) {
            return this.files.get(path);
        } else {
            return new ArrayList<>();
        }
    }

    public List<FileData> filterBySize(String path, long maxSize) {
        List<FileData> fileList = new ArrayList<>();
        if (this.files.containsKey(path)) {
            for (FileData fileData : this.files.get(path)) {
                if (fileData.getSize() <= maxSize) {
                    fileList.add(fileData);
                }
            }
        }
        return fileList;
    }

    public void remove(String path) {
        if (this.files.containsKey(path)) {
            this.files.remove(path);
        }
    }
}
