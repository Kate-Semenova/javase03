package main;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;

/**
 * Created by Ekaterina Semenova on 10.03.2018.
 */
public class CrazyLogger {
    private StringBuilder stringBuilder = new StringBuilder();
    private Calendar date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private static int count = 0;

    public void addLog(String log) {
        date = Calendar.getInstance();
        stringBuilder.append(dateFormat.format(date.getTime())).append(" ").append(log).append("\n");
    }

    public void findInfo(String info) {
       // StringBuilder stringBuilderKeeper = new StringBuilder(stringBuilder);
        int index = stringBuilder.indexOf(info);
        char n = '\n';
        String result;

        if (index == -1) {
            System.out.println("No information about \"" + info + "\"");
            result = "unsuccessfully";
        } else {
            while (index != -1) {
                count++;
                int beginning = index;
                while (stringBuilder.charAt(beginning) != n && beginning != 0) {
                    beginning--;
                }
                while (stringBuilder.charAt(index) != n && index < stringBuilder.length()) {
                    index++;
                }
                System.out.println(stringBuilder.subSequence(beginning, index).toString().trim());
                index = stringBuilder.indexOf(info, index);
            }
            result = "successfully and have found " + count + " logs";
        }

        addLog("User was searching for information about \"" + info + "\" with findInfo(String info)" + result
        );
        count = 0;
    }

    public void findInfo(int day, int month, int year, int hour, int minute) {
        StringBuilder stringBuilderInner = new StringBuilder();
        if (day < 10) {
            stringBuilderInner.append("0").append(day).append(".");
        } else {
            stringBuilderInner.append(day).append(".");
        }
        if (month < 10) {
            stringBuilderInner.append("0").append(month).append(".");
        } else {
            stringBuilderInner.append(month).append(".");
        }
        stringBuilderInner.append(year).append(" ");
        if (hour < 10) {
            stringBuilderInner.append("0").append(hour).append(":");
        } else {
            stringBuilderInner.append(hour).append(":");
        }
        if (minute < 10) {
            stringBuilderInner.append("0").append(minute);
        } else {
            stringBuilderInner.append(minute);
        }
        String str = stringBuilderInner.toString();

        this.findInfo(str);
    }

    // this.findInfo(dateFormat.format());
    //TODO

    public void findInfo(Date date) {
        String string = dateFormat.format(date);
        this.findInfo(string);
    }

    public String toString() {
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addLog("Hello");
        crazyLogger.addLog("Byu");
        crazyLogger.addLog("Why?");
        crazyLogger.findInfo("Hell");
        crazyLogger.findInfo(11, 3, 2018, 14, 38);
        Date date = new Date(1333333333333L);
        crazyLogger.findInfo(date);
        Date date1 = new Date();
        date1.toInstant();
        crazyLogger.findInfo(date1);

        System.out.println("================================");
        System.out.println("==========The whole log=========");
        System.out.println(crazyLogger.toString());

    }
}
