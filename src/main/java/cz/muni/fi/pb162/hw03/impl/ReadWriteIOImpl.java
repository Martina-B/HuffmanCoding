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
import java.util.stream.Collectors;

/**
 * This class is used to work with input and output streams.
 * 
 * @author Martina Balakova, 456595
 */
public class ReadWriteIOImpl implements ReadWriteIO {

    @Override
    public String streamToString(InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String fileToString(File file) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            return streamToString(in);
        }
    }

    @Override
    public void stringToStream(String string, OutputStream outputStream) throws IOException {
        BufferedWriter buffout = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
        buffout.write(string);
        buffout.newLine();
        buffout.flush();
    }

    @Override
    public void stringToFile(String string, File file) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            stringToStream(string, out);
        }
    }
    
}
