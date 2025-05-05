package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties = new Properties();

    public ConfigReader(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);

        if (value != null && value.contains("${")) {
            int start = value.indexOf("${") + 2;
            int end = value.indexOf("}", start);
            if (start > 1 && end > start) {
                String envKey = value.substring(start, end);
                String envValue = System.getenv(envKey);
                return envValue != null ? envValue : "";
            }
        }

        return value;
    }
}
