package sample.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidation {
    private static final String STANDART_DATE_PATTERN = "^[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}$";
    private static final String REVERSED_DATE_PATTERN = "^[0-9]{2}+[-]+[0-9]{2}+[-]+[0-9]{4}$";

    public static boolean isStandartDate(String date){
        Pattern pattern = Pattern.compile(STANDART_DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }
    public static boolean isReversedDate(String date){
        Pattern pattern = Pattern.compile(REVERSED_DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }
}