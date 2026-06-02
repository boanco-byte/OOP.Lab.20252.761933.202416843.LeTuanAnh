package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws Exception {

        String filename = "C:/OOP/OOP.Lab.20252.761933.202416843.LeTuanAnh/Lab03/OtherProjects/src/hust/soict/dsai/test.exe";
        
        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            
            long startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b);
            }
            String outputString = outputStringBuilder.toString();
            long endTime = System.currentTimeMillis();
            
            System.out.println("Processing time (StringBuilder): " + (endTime - startTime) + "ms");
            System.out.println("Output length: " + outputString.length());
        } catch (Exception e) {
            System.err.println("Lỗi: Không tìm thấy file! Hãy kiểm tra lại đường dẫn.");
            e.printStackTrace();
        }
    }
}