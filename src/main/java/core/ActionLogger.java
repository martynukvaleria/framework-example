package core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionLogger {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void log(String action, String details) {
        String timestamp = DATE_FORMAT.format(new Date());
        String logMessage = String.format("[%s] %s - %s", timestamp, action, details);

        System.out.println(logMessage);
    }

    public static void logAction(String actionType, String locator) {
        log(actionType, "Element: " + locator);
    }

    public static void logActionWithText(String actionType, String locator, String text) {
        log(actionType, String.format("Element: %s, Text: '%s'", locator, text));
    }
}