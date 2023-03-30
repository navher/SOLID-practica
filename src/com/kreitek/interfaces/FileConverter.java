package com.kreitek.interfaces;

import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;

public interface FileConverter {
    FileSystemItem convert(File file);
}
