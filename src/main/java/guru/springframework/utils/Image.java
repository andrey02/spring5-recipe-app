package guru.springframework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Image {

    public static byte[] generateBytes(String imagePath) throws IOException {

        File file = new File(imagePath);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return fileContent;
    }
}
