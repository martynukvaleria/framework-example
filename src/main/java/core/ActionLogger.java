package core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class ActionLogger {
    private static final Logger LOGGER = Logger.getLogger(ActionLogger.class.getName());
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    static {
        LOGGER.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + System.lineSeparator();
            }
        });

        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.INFO);
    }

    public static void log(String action, String details) {
        String timestamp = DATE_FORMAT.format(new Date());
        String logMessage = String.format("[%s] %s - %s", timestamp, action, details);
        LOGGER.info(logMessage);
    }

    public static void logAction(String actionType, String locator) {
        log(actionType, "Element: " + locator);
    }

    public static void logActionWithText(String actionType, String locator, String text) {
        log(actionType, String.format("Element: %s, Text: '%s'", locator, text));
    }
}
