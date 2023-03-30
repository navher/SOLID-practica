package com.kreitek.service;

import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.FileConverter;

public class FileConverterMp3ToWavImpl implements FileConverter {

    @Override
    public FileSystemItem convert(File file) {

        if (!"mp3".equalsIgnoreCase(file.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = file.getName().lastIndexOf(".");
        String nameWithoutExtension = file.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = file.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItem result = new File(file.getParent(), newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;

    }
}
