package FileHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class dataReader {

    public void readFromFile(String path) {
        InputStream file = dataReader.class.getResourceAsStream("/data/" + path);
        if (file == null) {
            System.err.println("Could not find /data/" + path + " on the classpath.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String part : line.split("\\|")) {
                    if (!part.isEmpty()) {
                        System.out.println(part);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readInfo(String path) {
        InputStream file = dataReader.class.getResourceAsStream("/data/" + path);
        if (file == null) {
            System.err.println("Could not find /data/" + path + " on the classpath.");
            return "";
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {
            String line;
            String info = "";
            while ((line = reader.readLine()) != null) {
                for (String part : line.split("\\|")) {
                    if (!part.isEmpty()) {
                        System.out.println(part + "\n");
                    }
                    info += part;
                }
            }
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
