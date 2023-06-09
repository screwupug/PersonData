package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation implements Writable {


    @Override
    public boolean writeInFile(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
