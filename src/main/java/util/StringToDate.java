package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
    public Date convertStringToDate(String dateString) {
        // Specify the format of the date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Convert string to date
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Handle invalid date format
            System.err.println("Invalid date format: " + e.getMessage());
            return null;
        }
    }
}