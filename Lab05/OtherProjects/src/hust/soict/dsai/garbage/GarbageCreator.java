package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "C:\\OOP\\OOP.Lab.20252.761933.202416843.LeTuanAnh\\Lab03\\OtherProjects\\src\\hust\\soict\\dsai\\test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char)b;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Processing time (String): " + (endTime - startTime) + "ms");
        System.out.println("Output length: " + outputString.length());
    }
}