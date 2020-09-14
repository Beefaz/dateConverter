package sample;

import sample.utils.DateValidation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int[] bonusDatesBetween = {2010, 2015};
        printBonusDatesBetween(bonusDatesBetween[0], bonusDatesBetween[1]);
    }

    private static void printBonusDatesBetween(int fromYear, int toYear){
        //symbols can be changed to / * - ?
        String requiredFormat = "yyyy.mm.dd";
        //date symbols can be changed to / * - ?, date can be written in reverse, order in array doesn't matter.
        String[] inputDates = {"1700-01-02", "11-11-2011", "2015/10/12", "12*12/2014", "2013.10.20", "2009.09*19", "2005-10/11", "2014?05-02"};


        ArrayList <String> dates = new ArrayList<>();

        for(String date:inputDates){
            String standartDate = standartizeDate(date);
            String formattedDate = formatDate(standartDate, requiredFormat);
            if (Integer.parseInt(formattedDate.substring(0,4))>=fromYear&&Integer.parseInt(formattedDate.substring(0,4))<toYear){
                dates.add(formattedDate);
            }
        }
        Collections.sort(dates);
        dates.forEach(System.out::println);
    }

    private static String standartizeDate(String date) {
        String standartizedDate;
        if (!DateValidation.isStandartDate(date)) {
            standartizedDate = date.replaceAll("[./*?]", "-");
            return standartizedDate;
        }
        return date;
    }

    private static String formatDate(String date, String requiredFormat) {
        String standartDateFormat = "dd-mm-yyyy";
        if (!DateValidation.isReversedDate(date)) {
            standartDateFormat = "yyyy-mm-dd";
        }

        Date dateForFormatting = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(standartDateFormat);
        try {
            dateForFormatting = simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        simpleDateFormat.applyPattern(requiredFormat);
        return simpleDateFormat.format(dateForFormatting);
    }
}
