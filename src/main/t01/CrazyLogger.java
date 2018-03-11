package main.t01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ekaterina Semenova on 10.03.2018.
 */
public class CrazyLogger {
    private StringBuilder stringBuilder = new StringBuilder();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private String methodUsed = "";
    private String methodUsedBefore = "";
    private int count = 0;
    private static final int TEN = 10;

    public CrazyLogger() {
        addMessage("CrazyLogger has been created");
    }

    public Date getTimeOfCreation() {
        methodUsedBefore = methodUsed;
        methodUsed = "getTimeOfCreation()";
        String stringDate = stringBuilder.substring(0, 16);
        Date date;
        try {
            date = dateFormat.parse(stringDate);
            addMessage(String.format("User was looking for time of creation with %s successfully", methodUsed));

        } catch (ParseException exception) {
            date = null;
            addMessage(String.format("User was looking for time of creation with %s unsuccessfully", methodUsed));
        }
        return date;
    }

    public void addMessage(String message) {
        Calendar date = Calendar.getInstance();
        stringBuilder.append(dateFormat.format(date.getTime())).append(" - ").append(message).append("\n");
        methodUsedBefore = methodUsed;
        methodUsed = "addMessage(String message)";
    }

    public String lastMethodUsed() {
        String returner = methodUsed;
        if (methodUsed.equals("addMessage(String message)")) {
            returner = methodUsedBefore;
        }
        methodUsedBefore = methodUsed;
        methodUsed = "lastMethodUsed()";
        addMessage(String.format("User was searching for information about the last method used with %s", methodUsed));

        return returner;
    }

    public void findInfo(String info) {
        if (!methodUsed.contains("date") && !methodUsed.contains("year")) {
            methodUsedBefore = methodUsed;
            methodUsed = "findInfo(String info)";
        }
        int index = stringBuilder.indexOf(info);
        char n = '\n';
        String result;

        System.out.println(String.format("Results for \"%s\"", info));

        if (index == -1) {
            String preposition = "about";
            if (methodUsed.contains("date") || methodUsed.contains("year")) {
                preposition = "on date";
            }
            System.out.println("No information " + preposition + " \"" + info + "\"");
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
            if (count == 1) {
                result = String.format("successfully and have found %d message", count);
            } else {
                result = String.format("unsuccessfully and have found %d messages", count);
            }
        }

        addMessage(String.format("User was searching for information about \"%s\" with %s %s", info, methodUsed, result));
        count = 0;
    }

    public void findInfo(int day, int month, int year, int hour, int minute) {
        StringBuilder stringBuilderInner = new StringBuilder();
        if (day < TEN) {
            stringBuilderInner.append("0").append(day).append(".");
        } else {
            stringBuilderInner.append(day).append(".");
        }
        if (month < TEN) {
            stringBuilderInner.append("0").append(month).append(".");
        } else {
            stringBuilderInner.append(month).append(".");
        }
        stringBuilderInner.append(year).append(" ");
        if (hour < TEN) {
            stringBuilderInner.append("0").append(hour).append(":");
        } else {
            stringBuilderInner.append(hour).append(":");
        }
        if (minute < TEN) {
            stringBuilderInner.append("0").append(minute);
        } else {
            stringBuilderInner.append(minute);
        }
        String string = stringBuilderInner.toString();
        methodUsedBefore = methodUsed;
        methodUsed = "findInfo(int day, int month, int year, int hour, int minute)";
        this.findInfo(string);
    }

    public void findInfo(Date date) {
        String string = dateFormat.format(date);
        methodUsedBefore = methodUsed;
        methodUsed = "findInfo(Date date)";
        this.findInfo(string);
    }

    public String toString() {
        return stringBuilder.toString();
    }

}
