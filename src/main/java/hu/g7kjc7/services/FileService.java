/**
 * @Author Koncsik Benedek András G7KJC7 h047161
 * @Date 17/10/2023
 */
package hu.g7kjc7.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes());
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
