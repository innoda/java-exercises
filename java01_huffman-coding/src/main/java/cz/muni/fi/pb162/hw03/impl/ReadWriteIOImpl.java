package cz.muni.fi.pb162.hw03.impl;

import cz.muni.fi.pb162.hw03.ReadWriteIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * This class provides reading from a file / stream and writing to a file / stream.
 * Implements ReadWriteIO interface.
 * 
 * @author Magdalena Kunikova
 */
public class ReadWriteIOImpl implements ReadWriteIO {

    @Override
    public String streamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder string = new StringBuilder();
        
        String line;
        while ((line = reader.readLine()) != null) {
            string.append(line);
            
        }
        return string.toString();
    }

    @Override
    public String fileToString(File file) throws IOException {
        try (FileInputStream writer = new FileInputStream(file)) {
            return streamToString(writer);          
        }
    }

    @Override
    public void stringToStream(String string, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.append(string);
        writer.flush();
    }

    @Override
    public void stringToFile(String string, File file) throws IOException {
        try (FileOutputStream writer = new FileOutputStream(file)) {
            stringToStream(string, writer);
            writer.close();
        }
    }
    
}
