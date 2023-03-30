package com.kreitek.files;

import com.kreitek.interfaces.FileSystemDirectory;
import com.kreitek.interfaces.FileSystemItem;
import com.kreitek.service.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements FileSystemDirectory {
    private final List<FileSystemItem> files;

    public Directory(Directory parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        return FileManager.calculateSize(files);
    }
}
