package model;

public interface Writable {
    boolean writeInFile(String data, String fileName) throws Exception;
}
