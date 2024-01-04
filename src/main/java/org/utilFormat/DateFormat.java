package org.utilFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static String formatDate(LocalDateTime dateTime){
        if (dateTime == null) return null;
        return FORMATTER.format(dateTime);
    }
}
